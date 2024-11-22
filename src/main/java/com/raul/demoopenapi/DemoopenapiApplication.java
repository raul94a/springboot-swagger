package com.raul.demoopenapi;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ForwardedHeaderFilter;

@SpringBootApplication
@Configuration
public class DemoopenapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoopenapiApplication.class, args);
    }
    @Bean
    ForwardedHeaderFilter forwardedHeaderFilter() {
        return new ForwardedHeaderFilter();
    }

    @Value("${spring.api.common.version}")
    String apiVersion;
    @Value("${spring.api.common.title}")
    String apiTitle;
    @Value("${spring.api.common.description}")
    String apiDescription;
    @Value("${spring.api.common.termsOfService}")
    String apiTermsOfService;
    @Value("${spring.api.common.license}")
    String apiLicense;
    @Value("${spring.api.common.licenseUrl}")
    String apiLicenseUrl;
    @Value("${spring.api.common.externalDocDesc}")
    String apiExternalDocDesc;
    @Value("${spring.api.common.externalDocUrl}")
    String apiExternalDocUrl;
    @Value("${spring.api.common.contact.name}")
    String contactName;
    @Value("${spring.api.common.contact.url}")
    String contactUrl;
    @Value("${spring.api.common.contact.email}")
    String contactEmail;

    @Bean
    public OpenAPI getOpenApiDocumentation() {
        return new OpenAPI()
                .info(new Info().title(apiTitle)
                        .description(apiDescription)
                        .version(apiVersion)
                        .contact(new Contact()
                                .name(contactName)
                                .url(contactUrl)
                                .email(contactEmail)
                        )
                        .termsOfService(apiTermsOfService)
                        .license(new License().name(apiLicense).url(apiLicenseUrl))
                ).externalDocs(new ExternalDocumentation().description(apiExternalDocDesc).url(apiExternalDocUrl));
    }

}
