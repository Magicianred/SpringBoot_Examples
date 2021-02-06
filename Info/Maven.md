# Maven

Maven follows Convention over Configuration

## Pre defined folder structure

### Source Code
```
${basedir}/src/main/java
${basedir}/src/main/resources
```

### Test Code
```
${basedir}/src/test
```

## Command

### mvn clean install

we are executing the complete maven build life cycle.

Build LifeCycle is a sequence of steps

Validate
Compile
Test
Package
Integration Test
Verify
Install
Deploy

### mvn –version 
Find the maven version

### mvn compile
compiles source files
### mvn test-compile 
compiles test files - one thing to observe is this also compiles source files

### mvn clean
 deletes target directory

### mvn test
run unit tests

### mvn package
creates a jar for the project

### help:effective-settings
Debug Maven Settings

### help:effective-pom
Look at the complete pom after all inheritances from parent poms are resolved

### dependency:tree
Look at all the dependencies and transitive dependencies

### dependency:sources
Download source code for all dependencies

### –debug
Debug flag. Can be used with all the above commands