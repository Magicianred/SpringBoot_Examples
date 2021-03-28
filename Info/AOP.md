# AOP - Aspect Oriented Programming

## Esempi

### logging prima dell'esecuzione di un metodo

```java
public class LogBeforeAdvice implements MethodBeforeAdvice {
  public void before(Method method, Object[] args, Object target) throws Throwable {


    // Log prima dell'invocazione del metodo
    System.out.println("[" + new Date() + "]nt"
                       +  target.getClass() + "."  +  method.getName()
                       +  "ntArgomenti: "+ Arrays.toString(args));
  }
}
```

### logging dopo l'esecuzione di un metodo

```java
public class LogAfterReturningAdvice implements AfterReturningAdvice {
  // Log del risultato dell'invocazione del metodo
  public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
    System.out.println("tRisultato: "+ returnValue);
  }
}
```

### logging dell'eccezione

```java
public class LogThrowAdvice implements ThrowsAdvice {
  // Log dell'eccezione ritornata dal metodo
  public void afterThrowing(Exception e) throws Throwable {
    System.out.println("tErrore: " + e.getMessage());
  }
}
```


### controllo completo del metodo: prima, dopo e la stessa esecuzione

```java
public class LogAroundAdvice implements MethodInterceptor {

  public Object invoke(MethodInvocation methodInvocation) throws Throwable {
    // Log prima dell'invocazione del metodo
    System.out.println("[" + new Date() + "]nt"
        +  methodInvocation.getClass() + "."  +  methodInvocation.getMethod().getName()
        +  "ntArgomenti: "+ Arrays.toString(methodInvocation.getArguments()));


    Object result = null;
    try {
			// invocazione metodo
			result = methodInvocation.proceed();
		}
		catch (Exception ex) {
			// Log dell'eccezione ritornata dal metodo
			System.out.println("tErrore: " + ex.getMessage());
		}
		// Log del riusultato dell'invocazione del metodo
		System.out.println("tRisultato: "+ result);
		return result;
	}
}
```