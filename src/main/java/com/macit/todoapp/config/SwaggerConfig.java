package com.macit.todoapp.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(str -> true).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("TodoApp API")
                .description("TodoApp API reference for developers")
                .contact(new Contact("Kerim Can Macit", "https://github.com/krmacit", "kerim.macit@yahoo.com"))
                .version("1.0").build();
    }

}
