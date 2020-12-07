package kz.bank.bankingsystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import kz.bank.bankingsystem.swagger.CustomConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaRepositories
public class BankingsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingsystemApplication.class, args);
    }
    @Autowired
    ObjectMapper ojectMapper;

    @PostConstruct
    void init() {
        CustomConverter.add(ojectMapper);
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("Project for Architecture") String appDesciption, @Value("Project for Architecture") String appVersion) {

        return new OpenAPI()
                .info(new Info()
                        .title("Banking System")
                        .version(appVersion)
                        .description(appDesciption)
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("SHANYRAQ TEAM").url("https://iitu.kz")));
    }
}
