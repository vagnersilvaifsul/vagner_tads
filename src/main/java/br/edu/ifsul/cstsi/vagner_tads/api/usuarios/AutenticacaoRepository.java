package br.edu.ifsul.cstsi.vagner_tads.api.usuarios;

import org.springframework.data.repository.Repository;

public interface AutenticacaoRepository extends Repository<Usuario,Long> {
    Usuario findByUsuario(String usuario);
}
