package be.bnpparibasfortis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
		return new ApiInfoBuilder().title("Kata Tennis API reference for developers").description("<br/>"
				+ "<h3>About this Kata</h3>"

				+ "<p>"
				+ "This short and simple Kata should be performed using <b>Test Driven Development (TDD)</b>. It is about implementing a simple tennis game. It is inspired by Wii tennis, "
				+ "where they have simplified tennis, so each set is one game." + "</p>"

				+ "<h3>Requirements for Java position</h3>" + "<ol>"

				+ "<li>"
				+ "&#127919; Use Java and Spring. a UI is not mandatory (the visual design of the UI is not important) and it can be tested via a command line application or API testing tool "
				+ "(like postman for instance)."

				+ "<dl>"
				+ "  <dt><h4><span style='color:green;'>&#10004; </span> Java 1.8 + Spring Boot 2 + Swagger 2</h4></dt>"
				+ "  <dd>The proposal of this Swagger Interface (OpenAPI) did not replace a front-end but supports the developers as a reference. This Java project is made using Maven, "
				+ "so it is possible to run the application by running the command line, as below.</dd>"
				+ "  <dd><span style='color:#eff5f5; background-color:#2f4f4f'>$> ./mvnw spring-boot:run, ./mvnw test, etc</span></dd>"
				+ "</dl>" + "</li>"

				+ "<li>" + "&#127919; We expect to have a README.md that explains how to compile and run this code."
				+ "<dl>" + "  <dt><h4><span style='color:green;'>&#10004; </span> README.md</h4></dt>"
				+ "  <dd>The README.md markdown can be reached in the root. It lists de dependencies and explains how to compile and run the project.</dd>"
				+ "</dl>" + "</li>"

				+ "<li>" + "&#127919; We expect an application that we can run and fulfil the requirements." + "<dl>"
				+ "  <dt><h4><span style='color:green;'>&#10004; </span> Deployable.</h4></dt>"
				+ "</dl>" + "</li>"

				+ "<li>"
				+ "&#127919; We expect you to produce the best code you can possibly provide to us and, later on, that you are able to explain the choices you made. Of course, "
				+ "the final result matters but, please, take into account that we are not only evaluating your final code: we will evaluate your overall approach to solve the problem."
				+ "<dl>" + "  <dt><h4><span style='color:green;'>&#10004; </span> Solution</h4></dt>"
				+ "  <dd>This solution was made based on the code https://github.com/follesoe/TennisKataJava, "
				+ "indicated as an example in the http://codingdojo.org/kata/Tennis/ at the end of the page. It was adapted for the Java position requirements described below.</dd>"
				+ "</dl>" + "<dl>" + "  <dt><h4><span style='color:green;'>&#10004; </span> Resources</h4></dt>"
				+ "  <dd>This API respects the principles of REST: Client–server, Stateless, Cacheable, Uniform interface, Layered system, Code on demand.</dd>"
				+ "  <dd>The key abstraction of information in REST for resources are defined by <b>Board and Player</b>. "
				+ "Those can be reached below by groups. Each resource group has descriptions that can be seen expanding by the Show/Hide link. "
				+ "It was named by \"REST Resource Naming Guide\" ref: https://restfulapi.net/resource-naming/.</dd>"
				+ "</dl>" + "</li>"

				+ "<li>"
				+ "&#127919; So please commit all the steps you went through to reach the final solution. It will help us to understand your way of thinking."
				+ "<dl>" + "  <dt><h4><span style='color:green;'>&#10004; </span> Steps by TDD approach</h4></dt>"
				+ "  <dd>.</dd>" + "</dl>" + "</li>"

				+ "<li>" + "&#127919; Please respect these few requirements." + "<dl>"
				+ "  <dt><h4><span style='color:green;'>&#10004; </span> This is the list of requirements.</h4></dt>"
				+ "  <dd>All of the requirements can be seen here and checked at the repository.</dd>" + "</dl>"
				+ "</li>"

				+ "<li>We expect you to spend up to a few hours on this but, of course, this is up to you.</li><br/>"
				+ "</ol>").termsOfServiceUrl("http://github.com/Malnati").license("MIT License")
				.licenseUrl("ricardomalnati@gmail.com").version("1.0").build();
	}
	
	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("tennis-api").apiInfo(this.apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("be.bnpparibasfortis.controller")).paths(PathSelectors.any())
				.build();
	}
}
