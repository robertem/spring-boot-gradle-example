package pe.thegoodone.example.demo20052017.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * Created by robert on 20/05/17.
 */
@Configuration
public class RootConfig {

    @Bean
    public Validator localValidatorFactoryBean() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }

}
