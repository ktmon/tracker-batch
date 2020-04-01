package com.ktmon.trackerbatch.subjects;

import com.ktmon.trackerbatch.observers.Observer;

public interface Subject<T> {
    void attach(Observer observer);

    void detach(Observer observer);

    void collect(T t);
}
