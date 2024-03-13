package com.nt.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerApiDocumentationCreation {

	@Bean
	public Docket createApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.nt"))
				.paths(PathSelectors.regex("/tourist.*")).build().apiInfo(createApiInfo());
	}

	public ApiInfo createApiInfo() {
		return new ApiInfoBuilder().title("Tourist Api Generation")
				.description("This swagger api provides the url and request methods of a tourist Data")
				.contact(new Contact("siva", "https://www.facebook.com/profile.php?id=100019192995850",
						"sivakrishnavelpula777@gmail.com"))
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENCE-2.0.html").version("1.0.0")
				.build();
	}
}
