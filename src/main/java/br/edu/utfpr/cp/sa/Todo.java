package br.edu.utfpr.cp.sa;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Todo {
    
    public static void main(String[] args) throws Exception {

        var app = new Todo();

        var result = switch(args[0]) {
            case "add" -> app.add(args[1]);
            case "remove" -> app.remove(args[1]);
            default -> app.todos;
        };

        FileUtils.writeLines(new File("todo.db"), app.todos); 

        System.out.println(result);
    }

    private List<String> todos;

    public Todo() throws Exception {
        try {
            todos = FileUtils.readLines(
                new File("todo.db"), 
                "UTF-8");
            
        } catch (Exception e) {
            todos = new ArrayList<>();
        }
    }

    public List<String> add(String todo) {
        this.todos.add(todo);
        return this.todos;
    }

    public List<String> remove(String todo) {
        this.todos.removeIf(t -> t.equalsIgnoreCase(todo));
        return this.todos;
    }
    
}