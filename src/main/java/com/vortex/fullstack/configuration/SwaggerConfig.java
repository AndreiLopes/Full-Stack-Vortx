package com.vortex.fullstack.configuration;

import com.vortex.fullstack.constants.GenericConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage(GenericConstants.CONTROLLERS_PACKAGE))
                .paths(PathSelectors.any()).build().useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.POST, responseMessageForPOST()).apiInfo(apiInfo());
    }

    private List<ResponseMessage> responseMessageForPOST() {
        return new ArrayList<ResponseMessage>() {
            {
                add(new ResponseMessageBuilder().code(500)
                        .message(GenericConstants.INTERNAL_SERVER_ERROR).build());
                add(new ResponseMessageBuilder().code(400)
                        .message(GenericConstants.DDD_NOT_FOUND_ERROR + " || " + GenericConstants.INVALID_PLAN_ERROR)
                        .build());
            }
        };
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(GenericConstants.SWEGGER_CONFIG_TITLE)
                .description(GenericConstants.SWEGGER_CONFIG_DESCRIPTION)
                .version(GenericConstants.SWEGGER_CONFIG_VERSION)
                .contact(new Contact(GenericConstants.SWEGGER_CONFIG_CONTACT_NAME,
                        GenericConstants.SWEGGER_CONFIG_CONTACT_WEBSITE, GenericConstants.SWEGGER_CONFIG_CONTACT_EMAIL))
                .build();
    }
}
