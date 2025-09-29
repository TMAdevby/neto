package org.example.Lambdas.third;

@FunctionalInterface
public interface OnDoneListener<T> {
    void onDone(T v);
}
