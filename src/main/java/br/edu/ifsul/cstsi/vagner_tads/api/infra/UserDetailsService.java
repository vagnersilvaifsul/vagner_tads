package br.edu.ifsul.cstsi.vagner_tads.api.infra;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//Classe responsável por gerenciar os usuários da aplicação. Em outras palavras, a aplicação fica responsável por esta gerência a partir desta classe.
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    //Implementação para fornecer os users em memória
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(username.equals("user")){
            return User.withUsername(username).password(encoder.encode("321")).roles("USER").build();
        }else if(username.equals("admin")){
            return User.withUsername(username).password(encoder.encode("321")).roles("USER", "ADMIN").build();
        }
        throw new UsernameNotFoundException("Usuario inexistente.");
    }
}
