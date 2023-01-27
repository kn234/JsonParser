package expression.parser;;

import junit.framework.Assert;
import org.junit.Test;


public class JsonTest {
    @Test
    public void test() {
        Assert.assertEquals(true, Json.parse("true"));

    }
    @Test
    public void testSpace(){
        Assert.assertEquals(true, Json.parse("  true    "));
        Assert.assertEquals(true, Json.parse("  true"));
        Assert.assertEquals(true, Json.parse("true    "));
    }
    @Test
    public void testStringParse(){
        Assert.assertEquals("true", Json.parse(" \"true\"  "));
        Assert.assertEquals("    true    ", Json.parse("  \"    true    \""));
        Assert.assertEquals("true  ", Json.parse("\"true  \"  "));
    }
    
}
