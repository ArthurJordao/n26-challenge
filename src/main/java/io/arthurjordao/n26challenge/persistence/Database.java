package io.arthurjordao.n26challenge.persistence;

import java.util.List;
import java.util.function.Predicate;

public interface Database<T> {
    void save(T object);

    List<T> query(Predicate<T> predicate);
}
