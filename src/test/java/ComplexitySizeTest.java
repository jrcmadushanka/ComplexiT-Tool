import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ComplexitySizeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void complexityDueToSize() {

        ComplexitySize cs = new ComplexitySize();

        String statement = "import java.util.ArrayList;";
        String statement2 = "public static ArrayList complexityDueToSize(String statement) {";

        ArrayList<String> output = cs.complexityDueToSize(statement);
        ArrayList<String> output2 = cs.complexityDueToSize(statement2);

        assertEquals( "3" , output.get(0));
        assertEquals( "1" , output2.get(0));
    }
}