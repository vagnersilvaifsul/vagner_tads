package br.edu.ifsul.cstsi.vagner_tads.api.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByUsuario(String usuario);
}
