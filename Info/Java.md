# Java

# Getter and Setter

For each properties you can make a getter and/or setter, to do this you use two method with prefixed the name of the property by *get* or *set* (for Boolean *get* is *is*)

```java
public class Example {

    protected String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    protected Boolean completed;

    public Boolean isCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
```