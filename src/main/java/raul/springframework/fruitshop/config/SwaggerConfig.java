package raul.springframework.fruitshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                .pathMapping("/")
//                .apiInfo(metaData());
//    }
//
//    private ApiInfo metaData(){
//
//        Contact contact = new Contact("Raul Menezes", "https://raulmenezes.com",
//                "");
//
//        return new ApiInfo(
//                "Fruit Shop API",
//                "Fruit Shop Documentation",
//                "1.0",
//                "Terms of Service: URL",
//                contact,
//                "Apache License Version 2.0",
//                "https://www.apache.org/licenses/LICENSE-2.0",
//                new ArrayList<>());
//    }

    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider(
            InMemorySwaggerResourcesProvider defaultResourcesProvider) {
        return () -> {
            List<SwaggerResource> resources = new ArrayList<>();
            resources.add(loadResource());
            return resources;
        };
    }

    private SwaggerResource loadResource() {
        SwaggerResource wsResource = new SwaggerResource();
        wsResource.setName("api1");
        wsResource.setSwaggerVersion("2.0");
        wsResource.setLocation("/swagger.yml");
        return wsResource;
    }
}
