package com.codegym.task.task37.task3714;
import org.junit.Assert;
import org.junit.Test;
public class TestRoman {

    @Test
    public void testRoman() {
        Assert.assertEquals(Solution.romanToInteger("IV"), 4);
        Assert.assertEquals(Solution.romanToInteger("VIII"), 8);
        Assert.assertEquals(Solution.romanToInteger("XV"), 15);
        Assert.assertEquals(Solution.romanToInteger("XLIV"), 44);
        Assert.assertEquals(Solution.romanToInteger("MDCX"), 1560);
        Assert.assertEquals(Solution.romanToInteger("I"), 1);

    }
}
