package com.alvesdev.Desafio.Cnab.controller;

import com.alvesdev.Desafio.Cnab.model.Transacao;
import com.alvesdev.Desafio.Cnab.service.CnabService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/cnab")
public class CnabController {

    private CnabService cnabService;

    public CnabController(CnabService cnabService) {
        this.cnabService = cnabService;
    }

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        cnabService.parseTransacao(file);
        return ResponseEntity.ok("Arquivo processado!");
    }

    @GetMapping("/listar-transacao")
    public ResponseEntity<List<Transacao>> listTransacao() {
        return ResponseEntity.ok(cnabService.listTransacoes());
    }

    @DeleteMapping("/limpar")
    public ResponseEntity<String> deletar() {
        cnabService.limparTransacoes();
        return ResponseEntity.ok("Tudo limpo!");
    }


}
