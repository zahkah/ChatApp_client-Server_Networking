package javapjct_fnl;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ClientTest {

    private Client client;

    @Before
    public void setUp() {
        client = new Client(); 
    }

    @Test
    public void testFormatMessageForDisplay() {
        String input = "Test message";
        String expected = "Test message\n";
        assertEquals(expected, client.formatMessageForDisplay(input));
    }

}