# Hibernate Architecture

## Hibernate Application Architecture involves in the following important class objects
- Configuration: The Configuration object is the first Hibernate object you create in any Hibernate application. It is usually created only once during application initialization. It represents a configuration or properties file required by the Hibernate.

- Session Factory: A Session is used to get a physical connection with a database. The Session object is lightweight and designed to be instantiated each time an interaction is needed with the database. Persistent objects are saved and retrieved through a Session object. The session objects should not be kept open for a long time because they are not usually thread safe and they should be created and destroyed them as needed.

- Transaction Object: A Transaction represents a unit of work with the database and most of the RDBMS supports transaction functionality. Transactions in Hibernate are handled by an underlying transaction manager and transaction (from JDBC or JTA).
This is an optional object and Hibernate applications may choose not to use this interface, instead managing transactions in their own application code.

- Query Object: Query objects use SQL or Hibernate Query Language (HQL) string to retrieve data from the database and create objects. A Query instance is used to bind query parameters, limit the number of results returned by the query, and finally to execute the query.

- Criteria Object: Criteria objects are used to create and execute object-oriented criteria queries to retrieve objects.

