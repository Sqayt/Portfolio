package ru.ivanovds.april.market.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.*;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.ivanovds.april.market"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Spring Boot + Swagger Test")
                .contact(new Contact("SqGoliaf", "https://github.com/Sqayt/", "danil.iwanow@outlook.com"))
                .description("Попытался создать swagger для Rest Сервера, хочу научиться им пользоваться")
                .termsOfServiceUrl("https://vk.com/sqgoliaf")
                .version("1.0")
                .build();
    }


}
