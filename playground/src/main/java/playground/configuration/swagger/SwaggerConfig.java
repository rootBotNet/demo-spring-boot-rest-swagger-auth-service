package playground.configuration.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                /**
                 * select() method returns an instance of ApiSelectorBuilder,
                 * which provides a way to control the end points exposed to Swagger
                 */
                .select()
                /**
                 * Filter API for Swagger Response
                 */
//                .apis(RequestHandlerSelectors.basePackage("playground.v1.controller"))
//                .paths(regex("/v1.*"))
                /**
                 * Predicates for selection of RequestHandlers can be configured with the
                 * help of RequestHandlerSelectors and PathSelectors. Using any() for both
                 * will make documentation for your entire API available through Swagger.
                 */
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())

                /**
                 * Specify the base package that needs to be scanned for endpoints.
                 * Specify any controller found in the base package.
                 */
                .apis(RequestHandlerSelectors.basePackage("playground"))
                .paths(PathSelectors.any())

                .build();
    }
}
