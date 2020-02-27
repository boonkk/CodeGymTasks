package com.codegym.task.task39.task3901;

import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    @Test
    public void testSomeValues() {
        Assert.assertEquals(0,Solution.lengthOfLongestUniqueSubstring(""));
        Assert.assertEquals(1,Solution.lengthOfLongestUniqueSubstring("11111111"));
        Assert.assertEquals(3,Solution.lengthOfLongestUniqueSubstring("123123123123123"));
        Assert.assertEquals(2,Solution.lengthOfLongestUniqueSubstring("koko"));
        Assert.assertEquals(9, Solution.lengthOfLongestUniqueSubstring("kurczak z koni"));
        Assert.assertEquals(5, Solution.lengthOfLongestUniqueSubstring("picza"));
        Assert.assertEquals(1, Solution.lengthOfLongestUniqueSubstring("     "));
        Assert.assertEquals(2,Solution.lengthOfLongestUniqueSubstring("eooeeooe"));
        Assert.assertEquals(9,Solution.lengthOfLongestUniqueSubstring("rybacka dolina"));

    }
}
