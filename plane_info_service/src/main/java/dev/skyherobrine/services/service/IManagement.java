package dev.skyherobrine.services.service;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

public interface IManagement<S extends Serializable, P, R extends AbstractEntityProperty, F extends Serializable> {

    R createOrUpdate(S s);
    R delete(P p);
    R findById(P p);
    Collection<R> findAll();
    Collection<R> findAll(Integer page, Integer size, Map<String, Sort.Direction> sorts, F filter);
}
