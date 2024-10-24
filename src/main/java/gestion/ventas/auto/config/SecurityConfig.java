package gestion.ventas.auto.config;

import gestion.ventas.auto.security.RestAuthenticationEntryPoint;
import gestion.ventas.auto.security.TokenAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@SuppressWarnings("removal")
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.cors()
                .configurationSource(request -> {
                    var cors = new CorsConfiguration();
                    cors.setAllowedOrigins(List.of("*"));
                    cors.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
                    cors.setAllowedHeaders(List.of("*"));
                    return cors;
                })
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .exceptionHandling()
                .authenticationEntryPoint(new RestAuthenticationEntryPoint())
                .and()
                .authorizeHttpRequests(auth -> {
                    auth
                            .requestMatchers(
                                    "/api/usuario/create/**",
                                    "/api/usuario/login/**"
                            )
                            .permitAll()
                            .anyRequest()
                            .authenticated();
                })
                .addFilterBefore(createTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public TokenAuthenticationFilter createTokenAuthenticationFilter() {
        return new TokenAuthenticationFilter();
    }
}
