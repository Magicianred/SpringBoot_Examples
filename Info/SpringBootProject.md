# Spring Boot Project

## Mode for create Spring Boot Project

1. Spring Initializr
https://start.spring.io

2. Use STS or STS Eclipse Plugin and Create a Spring Boot Maven Project directly from Eclipse
https://spring.io/tools

3. Manually Create a Maven Project and add Spring Boot Starter Dependencies


## Spring Boot Architecture

four layers:

- Presentation Layer
It is the frontend layer of Spring Boot architecture, which is responsible for managing the HTTP requests, translates the JSON parameter to object and vice-versa, and also authenticates the request and forward it to the business layer. In a nutshell, It consists of views.

- Business Layer
It manages all the business logic with the help of service classes and uses services provided by data access layers. It performs validation and authorization, for example, admin verifications.

- Persistence Layer
The persistence layer is responsible for translating the business objects from and to database rows. It contains all the storage logic.

- Database Layer
The database layer handles the database, such as MySQL, MongoDB, and more. All the DB operations, such as CRUD, are performed in this layer.

# Spring Modules

- Spring JDBC
- Spring MVC
- Spring Security
- Spring AOP
- Spring ORM
- Spring Test
