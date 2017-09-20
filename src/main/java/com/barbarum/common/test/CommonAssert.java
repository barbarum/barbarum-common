package com.barbarum.common.test;

public interface CommonAssert {


    <T> void equals(T expect, T actual);


    <T> void arrayEquals(T[] expect, T[] actual);
}
