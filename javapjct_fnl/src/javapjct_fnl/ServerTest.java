package javapjct_fnl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ServerTest {

    private Server server;

    @BeforeEach
    public void setup() {
        
        server = new Server();
    }

    @Test
    public void testPrepareMessageForDisplay() {
        // Test to ensure that the prepareMessageForDisplay method formats the message correctly
        String input = "Hello";
        String expected = "Hello\n"; // Expect the input to be formatted with a newline character
        assertEquals(expected, server.prepareMessageForDisplay(input), "The message should be formatted with a newline at the end.");
    }
}
