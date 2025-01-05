package br.com.rfsystems.springsecuritykeycloak.config;

import br.com.rfsystems.springsecuritykeycloak.conveters.JWTConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(AbstractHttpConfigurer::disable)
//        .authorizeHttpRequests(
//            authorizeConfig -> {
//              authorizeConfig.requestMatchers("/public").permitAll();
//              authorizeConfig.requestMatchers("/logout").permitAll();
//              authorizeConfig.requestMatchers("/token").permitAll();
//              authorizeConfig.anyRequest().authenticated();
//            })
//        .oauth2Login(withDefaults())
            .oauth2ResourceServer(oauth2 -> oauth2
                    .jwt(jwt -> jwt.jwtAuthenticationConverter(new JWTConverter())));
    return http.build();
  }
}
