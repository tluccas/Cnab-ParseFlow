package com.alvesdev.Desafio.Cnab.repository;

import com.alvesdev.Desafio.Cnab.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
