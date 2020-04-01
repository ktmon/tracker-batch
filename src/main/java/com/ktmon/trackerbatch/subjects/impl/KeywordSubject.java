package com.ktmon.trackerbatch.subjects.impl;

import com.ktmon.trackerbatch.dto.KeywordParams;
import com.ktmon.trackerbatch.observers.Observer;
import com.ktmon.trackerbatch.subjects.Subject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KeywordSubject implements Subject<KeywordParams> {

    List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void collect(KeywordParams keywordParams) {
        observers.forEach(observer -> observer.update(keywordParams));
    }
}
