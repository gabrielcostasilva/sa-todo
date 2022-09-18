# Todo
This project introduces a Todo that allows adding and removing todo tasks. 

This project is used throughout the Software Architecture module I teach at [Universidade Tecnológica Federal do Paraná, Cornélio Procópio, Brasil](http://www.utfpr.edu.br/campus/cornelioprocopio) for Software Engineering graduate students. 

The main branch shows a use case for the [KISS principle](https://en.wikipedia.org/wiki/KISS_principle) implementation. Check out other branches to find out how this project evolves to address other design principles.

## Project Overview
This Todo consists of one single class - [Todo](./src/main/java/br/edu/utfpr/cp/sa/Todo.java). `todos` is a private attribute that holds a `java.util.List` of `String`, representing todos.  

`add(String)` and `remove(String)` support todo management by adding and removing a todo to/from `todos`. The code snippet below shows the `remove(String)` method as an example.

```java
public List<String> remove(String todo) {
    this.todos.removeIf(t -> t.equalsIgnoreCase(todo)); // (1)
    return this.todos; // (2)
}
```

1. Removes a given todo, in case it exists in the todo list.
2. Returns the updated todo list.

This project uses `org.apache.commons.io.FileUtils` for saving the todo list in a text file, in the file system. The `Todo` class constructor tries to retrieve existing todos from an existing file. If the a previous file does not exist, a new list is instantiated. See the full constructor in the snippet below.


```java
public Todo() throws Exception {
    try {
        todos = FileUtils.readLines(
            new File("todo.db"), 
            "UTF-8");
        
    } catch (Exception e) {
        todos = new ArrayList<>();
    }
}
```

Finally, the `main` method decides which path to undertake based on command line arguments. After performing an action, the updated todo list is saved into the text file.

## Project Setup
This project requires Maven and Java 17 installed. The easiest way to run the project is building a package.

Within the project folder, type and run: `mvn clean package`. This will generate the `target` folder with a compiled `jar` file.

To try out the app, type and run: `java -jar target/todo-1.0-SNAPSHOT.jar add "To do the dishes"`

Please notice that the last two arguments represent the todo operation and title.

## Testing
This project features a [test class](./src/test/java/br/edu/utfpr/cp/sa/TodoTest.java) that asserts the implementation correctness. This project uses JUnit 5 for creating unit tests.

One can run all tests by typing and running: `mvn clean test`

