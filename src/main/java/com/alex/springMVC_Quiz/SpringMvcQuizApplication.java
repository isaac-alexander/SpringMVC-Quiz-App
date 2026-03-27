package com.alex.springMVC_Quiz;

import com.alex.springMVC_Quiz.entity.Question;
import com.alex.springMVC_Quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringMvcQuizApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcQuizApplication.class, args);
	}

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void run(String... args) throws Exception{
        questionRepository.saveAll(List.of(
                new Question("1. What does MVC stand for in Spring MVC?", "a) Multi-View Controller", "b) Module-View-Controller", "c) Model-View-Controller", "d) Model-Value-Configuration", "C"),

                new Question("2. What is Spring MVC", "a) A programming language for web development.", "b) A lightweight Java framework for building web applications.", "c) A database management system for web applications.", "d) A library for handling server-side rendering.", "B"),

                new Question("3. Which annotation is used to create a Spring MVC controller class?", "a) @ControllerBean", "b) @SpringController", "c) @WebController", "d) @Controller", "D"),

                new Question("4. Which of the following handles the HTTP request in Spring MVC?", "a) DispatcherServlet", "b) HandlerInterceptor", "c) HttpListener",
                        "d) RequestHandler", "A"),

                new Question("5. Which annotation binds a method parameter to a named attribute?", "a) @ModelAttribute", "b) @ParameterAttribute", "c) @BindAttribute", "d) @RequestValue", "A"),

                new Question("6. How can you handle exceptions in Spring MVC?", "a) @ExceptionHandler", "b) @CatchException", "c) @ErrorResolver", "d) @ResolveError", "A"),

                new Question("7. What is the purpose of the ModelAndView object in Spring MVC?", "a) To store and pass data between the controller and the view.", "b) To define the layout and styling of the web application.", "c) To handle user authentication and authorization.", "d) To manage the application's data access layer.", "A"),

                new Question("8. Which annotation is used to bind a method parameter to a web request header?", "a) @RequestHeader", "b) @Header", "c) @BindHeader", "d) @HTTPHeader", "A"),

                new Question("9. How can you access request parameters in a Spring MVC controller method?", "a) By using the @RequestParam annotation.", "b) By accessing them directly from the HttpServletRequest object.", "c) By using the @PathVariable annotation.", "d) By using the @RequestHeader annotation.", "A"),

                new Question("10. In Spring MVC, what is the role of the ViewResolver?", "a) Resolving bean dependencies", "b) Handling exceptions", "c) Resolving views to specific URLs", "d) Handling request parameters", "C"),

                new Question("11. Which annotation is used to denote a regular expression in URI template in Spring MVC?", "a) @Regex", "b) @PathVariable", "c) @URIExpression", "d) @MatchPattern", "B"),

                new Question("12. Which Spring MVC module provides integration with RESTful services?", "a) Spring RestController", "b) Spring REST", "c) Spring Web MVC", "d) Spring WebFlux", "C"),

                new Question("13. Which annotation indicates a method should handle HTTP POST requests?", "a) @HttpPost", "b) @PostHandler", "c) @RequestMapping(method = RequestMethod.POST)", "d) @PostMapping", "D"),

                new Question("14. What does the @ResponseBody annotation do?", "a) It sends the return value of a method back to the web response body.", "b) It binds the parameters of a method to the request body.", "c) It triggers an exception handling method.", "d) It binds the result of a method to a view.", "A"),

                new Question("15. How do you redirect to another URL in Spring MVC?", "a) \"redirect:/url_path\"", "b) \"forward:/url_path\"", "c) \"goto:/url_path\"", "d) \"move:/url_path\"", "A"),

                new Question("16. Which of the following annotations is used to handle multipart file uploads?", "a) @FileUpload", "b) @MultipartFile", "c) @RequestFile", "d) @UploadPart", "B"),

                new Question("17. How do you specify that a controller method should produce JSON as a response?", "a) @Produces(\"application/json\")", "b) @ResponseBody(type=\"json\")", "c) @ResponseFormat(\"JSON\")", "d) @RequestMapping(produces=\"application/json\")", "D"),

                new Question("18. Which of the following represents a form-backing bean in Spring MVC?", "a) @FormEntity", "b) @ModelEntity", "c) @ModelAttribute", "d) @BeanForm", "C"),

                new Question("19. Which of the following components decides which controller method is to be called for a request?", "a) DispatcherServlet", "b) Controller", "c) HandlerMapping", "d) ViewResolver", "C"),

                new Question("20. What does the @Valid annotation in Spring MVC do?", "a) It ensures that the method is correctly overridden from a superclass.", "b) It triggers validation of a method parameter or field.", "c) It ensures that an HTTP request is valid.", "d) It validates the return type of a method.", "B"),

                new Question("21. Which Spring annotation is used to handle Cross-Origin Resource Sharing (CORS) in Spring MVC?", "a) @CrossOrigin", "b) @CORSHandler", "c) @EnableCORS", "d) @CORSConfig", "A"),

                new Question("22. Which Spring Boot Starter would you use for developing web applications?", "a) spring-boot-starter-web", "b) spring-boot-starter-jdbc", "c) spring-boot-starter-data", "d) spring-boot-starter-app", "A"),

                new Question("23. In which layer is Spring MVC used?", "a) Data layer", "b) Business layer", "c) Presentation layer", "d) Integration layer", "C")
        ));
    }

}
