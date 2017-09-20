package com.barbarum.common.test.junit;

import com.barbarum.common.test.FunctionUtil;
import org.junit.Assert;

public class JunitFunctionUtil extends FunctionUtil {


    @Override
    public <T> void equals(T expect, T actual) {
        Assert.assertEquals(expect, actual);
    }

    @Override
    public <T> void arrayEquals(T[] expect, T[] actual) {
        Assert.assertArrayEquals(expect, actual);
    }
}
