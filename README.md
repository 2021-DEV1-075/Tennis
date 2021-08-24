# Tennis Kata - 2021/08/24

This short and simple Kata should be performed using Test Driven Development (TDD).

## Dependencies

 - Java 1.8
 - Maven

## Requirements for Java position
 - 🎯 Use Java and Spring. a UI is not mandatory (the visual design of the UI is not important) and it can be tested via a command line application or API testing tool (like postman for instance).
    - ✔ Java 1.8 + Spring Boot 2 + Swagger 2
    - The proposal of this Swagger Interface (OpenAPI) did not replace a front-end but supports the developers as a reference. This Java project is made using Maven, so it is possible to run the application by running the command line, as below.
    - $> ./mvnw spring-boot:run, ./mvnw test, etc
 - 🎯 We expect to have a README.md that explains how to compile and run this code.
    - ✔ README.md
    - The README.md markdown can be reached in the root. It lists de dependencies and explains how to compile and run the project.
 - 🎯 We expect an application that we can run and fulfil the requirements.
    - ✔ Deployable.
 - 🎯 We expect you to produce the best code you can possibly provide to us and, later on, that you are able to explain the choices you made. Of course, the final result matters but, please, take into account that we are not only evaluating your final code: we will evaluate your overall approach to solve the problem.
    - ✔ Solution
    - This solution was made based on the code https://github.com/follesoe/TennisKataJava, indicated as an example in the http://codingdojo.org/kata/Tennis/ at the end of the page. It was adapted for the Java position requirements described below.
    - ✔ Resources
    - This API respects the principles of REST: Client–server, Stateless, Cacheable, Uniform interface, Layered system, Code on demand.
    - The key abstraction of information in REST for resources are defined by Board and Player. Those can be reached below by groups. Each resource group has descriptions that can be seen expanding by the Show/Hide link. It was named by "REST Resource Naming Guide" ref: https://restfulapi.net/resource-naming/.
 - 🎯 So please commit all the steps you went through to reach the final solution. It will help us to understand your way of thinking.
    - ✔ Steps by TDD approach
    - Can be reached in the repository branches.
 - 🎯 Please respect these few requirements.
    - ✔ This is the list of requirements.
    - All of the requirements can be seen here and checked at the repository.
We expect you to spend up to a few hours on this but, of course, this is up to you.
