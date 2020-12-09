package com.study.batch.utility;

public interface FunctionWithException<T,R,E extends Exception>  {
    R apply(T t) throws E;
}