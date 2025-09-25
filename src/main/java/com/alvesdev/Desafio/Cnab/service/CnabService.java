package com.alvesdev.Desafio.Cnab.service;

import com.alvesdev.Desafio.Cnab.model.Transacao;
import com.alvesdev.Desafio.Cnab.repository.TransacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CnabService {

    private final TransacaoRepository transacaoRepository;

    public CnabService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public void parseTransacao(MultipartFile file) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                Transacao transacao = parseLine(line);
                transacaoRepository.save(transacao);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private Transacao parseLine(String line) {
        Transacao transacao = new Transacao();
        List<String> tipoInfo = parseTipo(Integer.parseInt(line.substring(0,1)));
        transacao.setDescricao(tipoInfo.get(0));
        transacao.setNatureza(tipoInfo.get(1));
        transacao.setSinal(tipoInfo.get(2));
        transacao.setData(LocalDate.parse(line.substring(1,9), DateTimeFormatter.BASIC_ISO_DATE));
        BigDecimal valor = new BigDecimal(line.substring(9, 19)).divide(new BigDecimal(100));
        transacao.setValor(valor);
        transacao.setCpf(line.substring(19,30));
        transacao.setCartao(line.substring(30,42));
        transacao.setHora(LocalTime.parse(line.substring(42, 48), DateTimeFormatter.ofPattern("HHmmss")));
        transacao.setDonoLoja(line.substring(48,62).trim());
        transacao.setNomeLoja(line.substring(62).trim());
        return transacao;
    }

    private List<String> parseTipo(int tipo){
        List<String> tipos = new ArrayList<String>();
            switch (tipo) {
                case 1:
                    tipos.add("Débito");
                    tipos.add("Entrada");
                    tipos.add("+");
                    break;
                case 2:
                    tipos.add("Boleto");
                    tipos.add("Saída");
                    tipos.add("-");
                    break;
                case 3:
                    tipos.add("Financiamento");
                    tipos.add("Saída");
                    tipos.add("-");
                    break;
                case 4:
                    tipos.add("Crédito");
                    tipos.add("Entrada");
                    tipos.add("+");
                    break;
                case 5:
                    tipos.add("Recebimento Empréstimo");
                    tipos.add("Entrada");
                    tipos.add("+");
                    break;
                case 6:
                    tipos.add("Vendas");
                    tipos.add("Entrada");
                    tipos.add("+");
                    break;
                case 7:
                    tipos.add("Recebimento TED");
                    tipos.add("Entrada");
                    tipos.add("+");
                    break;
                case 8:
                    tipos.add("Recebimento DOC");
                    tipos.add("Entrada");
                    tipos.add("+");
                    break;
                case 9:
                    tipos.add("Aluguel");
                    tipos.add("Saída");
                    tipos.add("-");
                    break;
                default: throw new IllegalArgumentException("Tipo invalido" + tipo);
            }
            return tipos;
    }

    public List<Transacao> listTransacoes(){
        return transacaoRepository.findAll();
    }

    public void limparTransacoes(){
        transacaoRepository.deleteAll();
    }
}
