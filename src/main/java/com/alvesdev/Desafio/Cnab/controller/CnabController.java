package com.alvesdev.Desafio.Cnab.controller;

import com.alvesdev.Desafio.Cnab.model.Transacao;
import com.alvesdev.Desafio.Cnab.service.CnabService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping(value = "/cnab")
@Tag(name = "Cnab ParseFlow")
public class CnabController {

    private CnabService cnabService;

    public CnabController(CnabService cnabService) {
        this.cnabService = cnabService;
    }

    @Operation(summary = "Recebe o arquivo .txt para conversão", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Arquivo Processado"),
            @ApiResponse(responseCode = "400", description = "Arquivo inválido ou vazio"),
            @ApiResponse(responseCode = "500", description = "Erro ao receber arquivo")
    })
    @PostMapping(value = "/upload-file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("Arquivo vazio ou não enviado!");
        }
        cnabService.parseTransacao(file);
        return ResponseEntity.ok("Arquivo processado!");
    }

    @Operation(summary = "Lista todas as transações", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a busca dos dados")
    })
    @GetMapping("/listar-transacao")
    public ResponseEntity<List<Transacao>> listTransacao() {
        return ResponseEntity.ok(cnabService.listTransacoes());
    }

    @Operation(summary = "Deleta todas as transações", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dados deletados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao deletar os dados")
    })
    @DeleteMapping("/limpar")
    public ResponseEntity<String> deletar() {
        cnabService.limparTransacoes();
        return ResponseEntity.ok("Tudo limpo!");
    }


}
