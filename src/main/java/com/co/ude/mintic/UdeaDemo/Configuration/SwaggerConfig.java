package com.co.ude.mintic.UdeaDemo.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // Creo método público de tipo Docket
    @Bean
    public Docket api (){ //Docket es un objeto de Swagger, se usa para crear la interfaz de la documentación
        return new Docket(DocumentationType.SWAGGER_2) //Tipo de documentación en que se mostrará la información
                .select() //Selecciona todos los verbos que estén en el ApiSelector: Get, Post, Patch, Put, etc...
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()) //Puedo omitir algunos verbos, pero le estoy indicando que los tome todos
                .build() // Construye lo anterior en el objeto Docket para ser pintado
                .apiInfo(apiInfo()) // Objeto apiInfo que contiene un método llamado apiInfo (creado abajo)
                .pathMapping("/"); // No excluirá nada
    }

    // Este apiInfo me permite crear y mostrar información del api
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Api de Prueba Udea Mintic",
                "Ejemplos de Uso Métodos Http",
                "API V 0.0.1",
                "Políticas de uso",
                new Contact("Grupos 15-16", "www.grupos15-16.com", "noreply@grupos15-16.com"),
                "Licencia Libre académica", "API license URL", Collections.emptyList()
        );
    }
}