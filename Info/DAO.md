# DAO - Data Access Object

pattern architetturale che ha come scopo quello di separare le logiche di business da quelle di accesso ai dati

## Model Book + JPA Annotation

```java
@Entity
@Table(name = "BOOK")
public class Book {
  @Id
  @Column(name = "ISBN")
  String isbn;
  @Column(name = "AUTORE")
  String autore;
  @Column(name = "TITOLO")
  String titolo;
  public String getIsbn() { return isbn; }
  public void setIsbn(String isbn) { this.isbn = isbn; }
  public String getAutore() { return autore; }
  public void setAutore(String autore) { this.autore = autore; }
  public String getTitolo() { return titolo; }
  public void setTitolo(String titolo) { this.titolo = titolo; }
  public String toString() {
    return isbn + " - " + autore + " - " + titolo;
  }
}
```

## Interfaccia DAO
Interfaccia che descrive il repository

```java
public interface BookDao {
  public void insert(Book book);
  public void update(Book book);
  public void delete(String isbn);
  public Book findByISBN(String isbn);
  public List<Book> findAllBooks();
  public int bookCount();
}
```

## Implementazione DAO
Implementazione specifica che gestisce l'accesso ai dati

Per esempio implementazione in JDBC e Hibernate.

### JDBC (JDBCTemplate)

```java
public class BookJdbcDao implements BookDao {
  private JdbcTemplate jdbcTemplate;
  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
  }
  //Inserimento
  public void insert(Book book)
  {
    jdbcTemplate.update("insert into books (isbn, autore, titolo) values (?, ?, ?)", new Object[] { book.getIsbn(), book.getAutore(), book.getTitolo() });
  }
  //Modifica
  public void update(Book book)
  {
    jdbcTemplate.update("update books set autore = ?, titolo = ? where isbn = ?", new Object[] { book.getIsbn(), book.getAutore(), book.getTitolo() });
  }
  // Eliminazione
  public void delete(String isbn)
  {
	jdbcTemplate.update("delete from books where isbn = ?", new Object[] { isbn });
  }
  // Query di un intero
  public int bookCount() {
	    int rowCount = jdbcTemplate.queryForInt("select count(1) from books");
	    return rowCount;
	  }
       //Query di un singolo oggetto
  public Book findByISBN(String isbn) {
    Book book = (Book) jdbcTemplate.queryForObject("select * from books where isbn = ?",
                                                   new Object[] { isbn },
                                                   new BookRowMapper());
    return book;
  }
  // Query di una lista
  public List<Book> findAllBooks() {
    List<Book> books = (List<Book>) jdbcTemplate.query("select * from books",
                                                       new BookRowMapper());
    return books;
  }
}
// Classe RowMapper
public class BookRowMapper implements RowMapper {
  public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
      Book book= new Book();
      book.setIsbn(rs.getString("isbn"));
      book.setAutore(rs.getString("autore"));
      book.setTitolo(rs.getString("titolo"));
      return book;
  }

}
```

#### SimpleJdbcDaoSupport 

```java
public class BookSimpleJdbcDaoSupportNamedValue extends SimpleJdbcDaoSupport {
  public void update(Book book) {
	  MapSqlParameterSource parameters = new MapSqlParameterSource();
	  parameters.addValue("isbn", book.getIsbn());
		parameters.addValue("author", book.getAuthor());
		parameters.addValue("title", book.getTitle());
	  getSimpleJdbcTemplate().update("update books set author = :author, title = :title where isbn = :isbn",
	                                 parameters);
	}


  // ...
}
```

#### SimpleJdbcDaoSupport 

```java
public class BookSimpleJdbcDaoSupportNamedValue extends SimpleJdbcDaoSupport {
  public void insert(Book book) {
    // Binding automatico dei parametri
    SqlParameterSource parameters = new BeanPropertySqlParameterSource(book);
    //Inserimento
    getSimpleJdbcTemplate().update("insert into books (isbn, author, title) values (:isbn, :author, :title)",
	                               parameters);
  }
  ...
}
```




### Hibernate (HibernateTemplate + HibernateDaoSupport)

```java
public class BookHibernateDaoSupport extends HibernateDaoSupport implements BookDao {


  @Transactional
  public int bookCount() {
    return findAllBooks().size();
  }
  @Transactional
  public void delete(String isbn) {
    Book book = (Book) getHibernateTemplate().get(Book.class, isbn);
    getHibernateTemplate().delete(book);
  }


  @Transactional(readOnly = true)
  public List findAllBooks() {
    return getHibernateTemplate().find("from Book");
  }
  @Transactional(readOnly = true)
  public Book findByISBN(String isbn) {
    return (Book) getHibernateTemplate().get(Book.class, isbn);
  }
  @Transactional
  public void insert(Book book) {
    getHibernateTemplate().saveOrUpdate(book);
  }
  public void update(Book book) {
    getHibernateTemplate().saveOrUpdate(book);
  }
}
```


