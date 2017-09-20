package com.barbarum.common.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.BiFunction;

@RunWith(Parameterized.class)
public class TestTestCase {


    private FunctionUtil util;

    @Parameterized.Parameter
    public int expect;

    @Parameterized.Parameter(1)
    public int inputA;

    @Parameterized.Parameter(2)
    public int inputB;


    @Before
    public void setup() {
        this.util = FunctionUtil.get(FunctionUtil.Type.JUNIT);
    }

    @Parameterized.Parameters(name = "{index}: testDataset - (({0}), ({1}, {2}))")
    public static Collection<Integer[]> data() {
        return Arrays.asList(new Integer[]{3, 1, 2}, new Integer[]{4, 3, 1});
    }

    @Test
    public void testExample() {
        this.testWithFunction(TestCase::input);
    }

    @Test
    public void testExample1() {
        this.testWithFunction(TestCase::input);
    }

    private void testWithFunction(BiFunction<Integer, Integer, Integer>... functions) {
        this.util.testEquals(expect, inputA, inputB, functions);
    }
}
