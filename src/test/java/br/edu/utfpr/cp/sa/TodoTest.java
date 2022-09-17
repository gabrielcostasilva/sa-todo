package br.edu.utfpr.cp.sa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodoTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void shouldAddTodo() throws Exception {
        Todo.main(new String[] { "add", "To do the dishes" });

        assertEquals(
                "[To do the dishes]",
                outputStreamCaptor.toString().trim());

        Todo.main(new String[] { "remove", "To do the dishes" }); // clean up
    }

    @Test
    public void shouldRemoveTodo() throws Exception {
        Todo.main(new String[] { "add", "To do the dishes" });        
        Todo.main(new String[] { "remove", "To do the dishes" });

        assertEquals(
                "[To do the dishes]\n[]",
                outputStreamCaptor.toString().trim());

    }

}
