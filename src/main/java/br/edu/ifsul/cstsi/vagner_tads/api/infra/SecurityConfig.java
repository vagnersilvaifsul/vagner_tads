package br.edu.ifsul.cstsi.vagner_tads.api.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //        //Basic Authentication
        http
            .csrf(csrf -> csrf.disable()) //desabilita a proteção contra ataques Cross-site Request Forger
            .authorizeHttpRequests(req -> {
                req.requestMatchers(HttpMethod.POST, "/api/v1/login").permitAll(); //exceto, a rota de login
                req.anyRequest().authenticated(); //demais rotas devem ser autenticadas
            })
            .httpBasic(Customizer.withDefaults())
            .userDetailsService(userDetailsService);
        return http.build();
    }
}
