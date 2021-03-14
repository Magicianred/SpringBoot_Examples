# Hibernate Practices

## isPersisted method

Each class @Entity will be have the method idPersisted

```java
public boolean isPersisted() {
    return id != null;
}
```

