package bibliotech.com.api.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Corrigido para aceitar todas as rotas
                        .allowedOrigins("https://lucas-luzun.github.io") // Corrigido: removeu a barra extra
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*") // Permite todos os cabeçalhos, mas você pode especificar se necessário
                        .allowCredentials(true); // Permite envio de cookies, se necessário
            }
        };
    }
}
