package io.arthurjordao.n26challenge.persistence;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class InMemoryDatabase<T> implements Database<T> {
    private List<T> storage = new CopyOnWriteArrayList<>();

    @Override
    public void save(T object) {
        storage.add(object);
    }

    @Override
    public List<T> query(Predicate<T> predicate) {
        return storage.stream().filter(predicate).collect(Collectors.toList());
    }
}
