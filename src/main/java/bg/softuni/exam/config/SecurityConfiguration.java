package bg.softuni.exam.config;

import bg.softuni.exam.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends GlobalMethodSecurityConfiguration {

    @Autowired
    private ClothesMethodSecurityExpressionHandler clothesMethodSecurityExpressionHandler;

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return clothesMethodSecurityExpressionHandler;
    }

    @Bean
    public ClothesMethodSecurityExpressionHandler createExpressionHandler(ClothesService clothesService) {
        return new ClothesMethodSecurityExpressionHandler(clothesService);
    }

}
