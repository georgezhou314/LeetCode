import org.junit.Test;

import java.math.BigInteger;

import static junit.framework.Assert.assertEquals;

public class TestCase {
    @Test
    public void test(){
        MultiplyStrings test=new MultiplyStrings();
        assertEquals(test.multiply("2","3"),"6");
        assertEquals(test.multiply("123","456"),Integer.toString(123*456));
        assertEquals(test.multiply("0","123"),"0");
        BigInteger num2=new BigInteger("134899923323");
        BigInteger big1=num2.multiply(new BigInteger("188899231"));
        assertEquals(test.multiply("188899231","134899923323"),big1.toString());

    }
}
