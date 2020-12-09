package com.study.batch.utility;

public interface ThrowingConsumer<T, E extends Exception> {
    void accept(T t) throws E;
}

