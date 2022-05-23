package ru.ivanovds.april.market;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@PropertySource("classpath:app.properties")
@EnableSwagger2
@Slf4j
public class AprilMarketApplication {
    public static void main(String[] args) {
        SpringApplication.run(AprilMarketApplication.class, args);
    }
}
