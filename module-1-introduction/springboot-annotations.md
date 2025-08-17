# Spring Boot Annotations Reference

This document provides a categorized list of important **Spring Boot and Spring Framework annotations** along with their explanations.  
Use it as a quick reference to find annotations based on their use case.

---

## 1. Core Spring Annotations

### `@SpringBootApplication`
- Marks the main class of a Spring Boot application.
- Combines:
  - `@Configuration` (marks as configuration class)
  - `@EnableAutoConfiguration` (enables auto-configuration)
  - `@ComponentScan` (scans for beans in the package and sub-packages).

### `@Configuration`
- Defines a class as a source of bean definitions.
- Typically used along with `@Bean` methods.

### `@Bean`
- Declares a bean that should be managed by the Spring container.
- Used inside `@Configuration` classes.

### `@ComponentScan`
- Tells Spring where to look for components (`@Component`, `@Service`, `@Repository`, etc.).

---

## 2. Stereotype Annotations (Bean Definition)

These help define Spring beans automatically via classpath scanning.

### `@Component`
- Generic stereotype for any Spring-managed bean.

### `@Service`
- Specialization of `@Component`.
- Indicates service layer logic.

### `@Repository`
- Specialization of `@Component`.
- Indicates DAO layer (persistence logic).
- Also enables **exception translation**.

### `@Controller`
- Specialization of `@Component`.
- Marks a class as a Spring MVC controller.

### `@RestController`
- Combines `@Controller` and `@ResponseBody`.
- Used for REST APIs, where return values are written directly to the HTTP response body.

---

## 3. Dependency Injection Annotations

### `@Autowired`
- Marks a constructor, method, or field to be autowired with a matching bean from the Spring context.

### `@Qualifier`
- Used with `@Autowired` when multiple beans of the same type exist.
- Specifies which bean to inject.

### `@Primary`
- Marks a bean as the default choice when multiple candidates exist.

### `@Lazy`
- Initializes a bean only when it is first requested.

### `@Value`
- Injects values into fields from property files or environment variables.  
  Example: `@Value("${app.name}") private String appName;`

### `@Scope`
- Defines the scope of a bean (`singleton`, `prototype`, `request`, `session`).

---

## 4. Spring Boot Configuration Annotations

### `@EnableAutoConfiguration`
- Enables Spring Boot’s auto-configuration mechanism.

### `@ConfigurationProperties`
- Binds properties from `application.properties` / `application.yml` to a POJO.

### `@PropertySource`
- Loads properties from a custom properties file.

### `@Profile`
- Activates a bean only for specific profiles (`dev`, `test`, `prod`).

---

## 5. Web Layer (Spring MVC / REST)

### `@RequestMapping`
- Maps HTTP requests to handler methods or classes.

### `@GetMapping`
- Shortcut for `@RequestMapping(method = RequestMethod.GET)`.

### `@PostMapping`
- Shortcut for POST requests.

### `@PutMapping`
- Shortcut for PUT requests.

### `@DeleteMapping`
- Shortcut for DELETE requests.

### `@PatchMapping`
- Shortcut for PATCH requests.

### `@PathVariable`
- Binds a URI template variable to a method parameter.

### `@RequestParam`
- Extracts query parameters from the request URL.

### `@RequestBody`
- Binds the HTTP request body to a method parameter (usually JSON to POJO).

### `@ResponseBody`
- Writes return value directly to the HTTP response body.

### `@ModelAttribute`
- Binds request parameters to a model object.

### `@CrossOrigin`
- Enables Cross-Origin Resource Sharing (CORS).

---

## 6. Data Persistence (Spring Data JPA)

### `@Entity`
- Marks a class as a JPA entity (mapped to a database table).

### `@Table`
- Specifies table details for an entity.

### `@Id`
- Marks the primary key of an entity.

### `@GeneratedValue`
- Defines primary key generation strategy.

### `@Column`
- Maps an entity field to a table column.

### `@Transient`
- Excludes a field from persistence.

### `@Repository`
- Marks a class as a DAO and enables exception translation.

### `@EnableJpaRepositories`
- Enables Spring Data JPA repositories.

---

## 7. Validation Annotations (JSR-380 / Hibernate Validator)

### `@Valid`
- Triggers validation on a request object.

### `@NotNull`
- Ensures the field is not null.

### `@NotEmpty`
- Ensures a collection/string is not null and not empty.

### `@NotBlank`
- Ensures a string is not null and trimmed length > 0.

### `@Size(min, max)`
- Validates size of strings, collections, arrays.

### `@Min` / `@Max`
- Validates numeric range.

### `@Email`
- Ensures the field is a valid email format.

---

## 8. Testing Annotations

### `@SpringBootTest`
- Loads the full application context for integration testing.

### `@WebMvcTest`
- Loads only the web layer (controllers).

### `@DataJpaTest`
- Loads only JPA components for repository testing.

### `@MockBean`
- Creates and injects a Mockito mock into the application context.

### `@TestConfiguration`
- Provides test-specific bean configurations.

---

## 9. Scheduling and Async

### `@EnableScheduling`
- Enables scheduling tasks with `@Scheduled`.

### `@Scheduled`
- Marks a method to be run on a schedule (cron, fixedRate, fixedDelay).

### `@EnableAsync`
- Enables asynchronous method execution.

### `@Async`
- Executes a method asynchronously in a separate thread.

---

## 10. Security Annotations (Spring Security)

### `@EnableWebSecurity`
- Enables Spring Security configuration.

### `@PreAuthorize`
- Method-level security; checks authorization before method execution.  
  Example: `@PreAuthorize("hasRole('ADMIN')")`

### `@Secured`
- Restricts access to methods based on roles.

### `@RolesAllowed`
- Similar to `@Secured`, supports JSR-250 roles.

---

# 📌 Summary
This list covers the **most commonly used Spring Boot annotations**, categorized by:
- Core & Configuration
- Dependency Injection
- Web (REST/MVC)
- Data Persistence (JPA)
- Validation
- Testing
- Scheduling & Async
- Security

Keep this as a **cheatsheet** when working with Spring Boot projects 🚀
