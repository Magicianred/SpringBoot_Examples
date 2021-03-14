# JUnit

## Version 4

### Dependency

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope> 
</dependency>
```

### Test Runner

```java
@RunWith(SpringRunner.class)
@WebFluxTest(controllers = EmployeeController.class)
public class EmployeeRestControllerTest {
    //tests
}
```

with Mockito (so that explicit usage of MockitoAnnotations.initMocks(Object) is not necessary)

```java
@RunWith(MockitoJUnitRunner.class)
public class EmployeeRestControllerTest 
{
    @Mock
    private Repository repository;
}
```

## Version 5

### Dependency

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
 
    <!-- exclude junit 4 -->
    <exclusions>
        <exclusion>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
        </exclusion>
    </exclusions>
 
</dependency>
 
<!-- junit 5 -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <scope>test</scope>
</dependency>
 
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <scope>test</scope>
</dependency>
 
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>test</scope>
    <version>1.4.194</version>
</dependency>
```

### Test Runner

```java
//@ExtendWith(SpringExtension.class)  // included in @WebFluxTest
@WebFluxTest(controllers = EmployeeController.class)
@Import(EmployeeService.class)
public class EmployeeControllerTest 
{
    //
}
```

with Mockito (so that explicit usage of MockitoAnnotations.initMocks(Object) is not necessary)

```java
@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest 
{
    //
}
```

### SpringBoot Annotations for test

#### @SpringBootTest

This annotation helps in writing integration tests. It starts the embedded server and fully initializes the application context. We can inject the dependencies in test class using @Autowired annotation.

We can also provide test specific beans configuration using nested @Configuration class or explicit @TestConfiguration classes.

```java
@SpringBootTest(classes = SpringBootDemoApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTests 
{
    @LocalServerPort
    private int port;
 
    @Autowired
    private TestRestTemplate restTemplate;
 
    //tests
}
```

#### @WebMvcTest

This annotation is used for Spring MVC tests. It disables full auto-configuration and instead apply only configuration relevant to MVC tests.

It also auto-configure MockMvc instance as well. We can initialize only one web controller by passing .class as the annotation attribute.

```java
@WebMvcTest(EmployeeRESTController.class)
public class TestEmployeeRESTController {
  
    @Autowired
    private MockMvc mvc;
  
    //
}
```

#### @WebFluxTest

This annotation disables full auto-configuration and instead apply only configuration relevant to WebFlux tests. By default, tests annotated with @WebFluxTest will also auto-configure a WebTestClient.

Typically @WebFluxTest is used in combination with @MockBean or @Import to create any collaborators required by the controller bean.

```java
@WebFluxTest(controllers = EmployeeController.class)
@Import(EmployeeService.class)
public class EmployeeControllerTest 
{
    @MockBean
    EmployeeRepository repository;
 
    @Autowired
    private WebTestClient webClient;
 
    //tests
}
```

## Reference
- https://howtodoinjava.com/spring-boot2/testing/testing-support/