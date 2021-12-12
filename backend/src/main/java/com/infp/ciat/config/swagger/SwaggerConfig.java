package com.infp.ciat.config.swagger;

import org.apache.http.HttpHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket restAPI() {
        Parameter parameters = new ParameterBuilder()
                .name(HttpHeaders.AUTHORIZATION)
                .description("JWT Token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();

        List<Parameter> global_parameters = new ArrayList<>();
        global_parameters.add(parameters);

        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(global_parameters)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.infp.ciat"))
                .paths(PathSelectors.any())
                .build();
    }

    /***
     * 메인에서 보여질 swagger info
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("CIAT Swagger docs")
                .version("1.0.0")
                .description("CIAT Swagger docs입니다.")
                .build();
    }
}