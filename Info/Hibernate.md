# Hibernate

## Concept

### persistence unit
It's a starting point in JPA. It define the mapping with classes and the table, the connection string and many others.
You can have more than one *persistence unit*s in your project.

### Classes marked as Entity
Each classes marked as *Entity* are *Table* in database.
The class name is the name of the table.

Each class with *@Entity* annotation must be have *@Id* annotation in a property and *Hibernate* give the name *ID* to table field in the database.

### Properties
Each properties in classes marked as *Entity* are fields in database.
The property name is the name of the table field.

Hibernate use direct property, not getter and setter.

Relation property (List) are checked by reference, you don't create a new array instance of object, you should use the same.

### Abstract classes

#### JpaRepository<,>
Spring Data JPA contains some built-in Repository abstracting common functions based on EntityManager to work with database such as findAll, findById, save, delete, deleteById. All we need for this example is extends JpaRepository.

```java
package com.hellokoding.jpa.repository;

import com.hellokoding.jpa.model.Person;  
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer>{  
}
```

## Relation types

### one-to-many

### many-to-one

- Example: RowOrder in Order (many-to-one multiplicity)

```java
public class RowOrder {
    protected Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
```

### bidirectional relationships or bidirectional navigation

- Example: Order with own RowOrders

```java
public class Order {
    protected Set<RowOrder> rowOrders = new HashSet<RowOrder>();

    public Set<RowOrder> getRowOrders() {
        return rowOrders;
    }

    public void setRowOrders(Set<RowOrder> rowOrders) {
        this.rowOrders = rowOrders;
    }

    public void addRowOrder(RowOrder rowOrder) {
        if(rowOrder == null) {
            throw new NullPointerException("Cannot add null row order");
        }
        if(rowOrder.getOrder() != null) {
            throw new IllegalStateException("Row order is already assigned to an Order");
        }
        getRowOrders.add(rowOrder);
        rowOrder.setOrder(this);
    } 
}
```


## References

- https://hellokoding.com/one-to-one-mapping-in-jpa-and-hibernate/

