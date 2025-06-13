# bc2504-sb Spring Boot
## Part 1
- Create Spring Boot Project, attach dependency
- @GetMapping, @PostMapping, @DeleteMapping, @PutMapping, @PatchMapping
- @RestController
- @RequestParam, @PathVariable, @RequestBody
- Class and Interface (xxxController.java,  xxxOperation.java)
- url design: noun phrase
- pom.xml -> spring web (eg, lombok)
- Example: Calculator (Exercise 1)

## Part 2
- Bean (@Controller, @Service, @Repository, @Component, @Configuration+@Bean, @RestControllerAdvice)
  - @Configuration + @Bean -> i.e. RestTemplate
  - @Component -> i.e. mapper
- Controller (@Autowired Service) -> Service (@Autowired Repository) -> Repository
- Spring Context 
  - Prepared after server starts
  - Check all dependencies, If fail, server fail to start

## Part 3
- Connect Database 
  - pom.xml (jpa + db driver)
  - application.yml (login info)
  - Entity (table, PK, FK)
  - One Repsitory maps to One Entity
   - Given CRUD operations
    - findAll(), findById(), return Optional, save (insert or replace), saveAll, deleteById
   - Custom JPA methods

## Part 4
- DTO (Data Transfer Object)
  - Main Purpose: Serve for your API customer/client.
  - So, DTO structure may not match to your model/entity.
  - Mapper (Builder)
  - model/dto (Call external API -> return JSON)
  - @Getter, @AllArgsConstructor

## Part 5
- GlobalExceptionHandler
  - Able to return a separate unhappy flow
  - return Custom Error Response object (ErrorDTO.java)
  - No longer to use try-catch (Caller)
  - You still need to throw exception object
  - @RestControllerAdvice, @ExceptionHandler
  - enum (error code and message mapping)

## Part 6 (Other functions)
- CommandLineRunner
  - Make sure run() implementation can be executed successfully before server starts
- Scheduling