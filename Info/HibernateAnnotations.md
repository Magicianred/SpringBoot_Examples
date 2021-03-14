# Hibernate Annotations

## Classes annotations

### @Entity (required)
Define this class as Entity, there are a corrispondent table in the database.

```java
@Entity
```

Default name is the name of the class, but it is good practice specify it.

```java
@Entity(name = "Person")
```

### @Table
Define the name of the Table to map

```java
@Table(name = "people")
```

### @MappedSuperclass
Defined an abstract class whom been extended by Entity class, there is no Table mapped to it

## Properties annotations

### @Id (required)
Mark this property as Primary Key

### @GeneratedValue
Mark this property as Auto increment / ID generation

```java
@GeneratedValue(
        strategy = SEQUENCE,
        generator = "user_sequence"
)
```

### @SequenceGenerator

```java
@SequenceGenerator(
        name = "user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1
)
```

### @Column

```java
@Column(
        name = "id",
        updatable = false
)
```

#### unique = true (attribute of @Column)
enforces the unique constraint

#### nullable = true (attribute of @Column)
define if nullable

### @OneToOne
defines a one-to-one relationship between 2 entities

#### mappedBy (attribute of @OneToOne)
points to the relationship owner

#### cascade = CascadeType.ALL
CascadeType.ALL save automatically entity related

### @JoinColumn
defines a foreign key column



## Properties validation annotations

The annotations can be put on property or *getter* method

### @NotNull
Check the value will be not null

### @Size

```java
@Size(
    min = 5,
    max = 25,
    message = "The string is required, min 5 and max 25 chars"
)
protected String text;
```

### @Future

Check if the date is in the future.

```java
@Future
protected Date dateOfPayment;
```

### Custom constrains

```java
ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
Validator validator = factory.getValidator();

Order order = new Order();
order.setNumber("ABC123");
order.setDateOfPayment(new Date());

Set<ConstraintViolation<Order>> violations = validator.validate(order);

/* violations.size() == 1 // show how many rules are violate */

ConstraintViolation<Order> violation = violations.iterator().next();
String failedPropertyName = violation.getPropertyPath().iterator().next().getName();

/* failedPropertyName == "dateOfPayment" */
```

## Global annotations metadata

You can use global annotation creating a file *package-info.java* inside root of your package.

### @NamedQuery

```java
@org.hibernate.annotations.NamedQueries({
    @org.hibernate.annotations.NamedQuery(
        name = "findItemsWithDiscount",
        query = "select * from Items where discount = 1 order by insertDate desc"
    ),
    @org.hibernate.annotations.NamedQuery(
        name = "findLastThreeItemsMoreRecent",
        query = "select * from Items order by insertDate desc limit 3"
    )
})
package org.example.your.package;
```

## Vendor annotations

There are some annotations related to specific vendor database.

