package be.bnpparibasfortis.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Kata Tennis API reference for developers")
				.description(getDescription())
				.termsOfServiceUrl("https://github.com/2021-DEV1-075/Tennis")
				.license("MIT License")
				.licenseUrl("fkdslv@gmail.com")
				.version("1.0")
				.build();
	}

	private String getDescription() {
        try {
            File file = ResourceUtils.getFile("classpath:swagger.html");
            return new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
        } catch (IOException e) {
            e.getMessage();
        }
        return null;
	}

	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("tennis-api").apiInfo(this.apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("be.bnpparibasfortis.controller")).paths(PathSelectors.any())
				.build();
	}
}
