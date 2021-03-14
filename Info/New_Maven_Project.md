# Create New Maven Project

## Requisites

- Install JDK
- Install Maven
http://maven.apache.org/install.html

## Create with command line

```cmd
mvn archetype:generate -DgroupId=com.javawebtutor -DartifactId=HibernateSampleExample -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Convert to eclipse project
To convert Maven project to support Eclipse IDE, in terminal, navigate to “HibernateSampleExample” project, and issue this command

```cms
mvn eclipse:eclipse 
```

## Reference

https://www.javawebtutor.com/articles/maven/maven_hibernate_example.php