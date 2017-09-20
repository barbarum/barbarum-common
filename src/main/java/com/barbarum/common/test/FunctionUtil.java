package com.barbarum.common.test;

import com.barbarum.common.test.junit.JunitFunctionUtil;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public abstract class FunctionUtil implements CommonAssert {


    public enum Type {
        JUNIT,
        TESTNG
    }

    public <A, B, E> void testEquals(E expect, A paramA, B paramB, BiFunction<A, B, E>... biFunctions) {
        Stream.of(biFunctions).forEach(function -> equals(expect, function.apply(paramA, paramB)));
    }

    public <A, B, E> void testArrayEquals(E[] expect, A paramA, B paramB, BiFunction<A, B, E[]>... biFunctions) {
        Stream.of(biFunctions).forEach(function -> arrayEquals(expect, function.apply(paramA, paramB)));
    }


    public static FunctionUtil get(Type type) {
        if (type == Type.JUNIT) {
            return new JunitFunctionUtil();
        }
        return null;
    }

    public static void main(String[] args) {
        FunctionUtil.get(Type.JUNIT).testEquals(3, 1, 2, TestCase::input);
    }

}
