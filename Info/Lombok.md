# Lombok

Lombok is a tool for generate boilerplate code

## Add in pom.xml

```xml
<dependency>  
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
</dependency>  
```

## Annotations

### Generate constructors

```java
import lombok.AllArgsConstructor;  
import lombok.NoArgsConstructor;  
import lombok.NonNull;  
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Product {  
    @NonNull private Integer id;
    private String name;
}
```

### Generate getters, setters, toString, equals and hashCode

```java
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Product {  
    private Integer id;
    private String name;
}
```

### @Data
unique annotation to generate @Getter + @Setter + @RequiredArgsConstructor + @ToString + @EqualsAndHashCode

```java
@Data
public class Product {  
    private final Integer id;
    private String name;
}
```

### @Value
unique annotation to generate @Getter + @FieldDefaults(makeFinal=true, level=AccessLevel.PRIVATE) + @AllArgsConstructor + @ToString + @EqualsAndHashCode

```java
@Value
public class Product {  
    private Integer id;
    private String name;
}
```

### Add a Logger with @Slf4j
Use @Slf4j to generate a logger field, make sure slf4j-api is already included in your project dependencies

```java
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogExample {  
}
```

## Reference

- https://hellokoding.com/lombok-in-java-and-spring-boot/
- https://howtodoinjava.com/automation/lombok-eclipse-installation-examples/