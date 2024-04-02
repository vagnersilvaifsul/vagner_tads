package br.edu.ifsul.cstsi.vagner_tads.api.infra;

import br.edu.ifsul.cstsi.vagner_tads.api.usuarios.AutenticacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
    Esta classe implementa o serviço de Autenticação HTTP Basic em Banco de dados (fizemos isso depois da autenticação em memória).
    O método loadUserByUsername é disparado automaticamente pelo Filter Padrão do Spring Security.
 */
@Service
public class UserDetailsServiceHttpBasic implements UserDetailsService {

    @Autowired
    private AutenticacaoRepository usuarioRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRep.findByUsuario(username);
    }
}
