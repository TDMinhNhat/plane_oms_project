package dev.skyherobrine.services.service;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import dev.skyherobrine.library.models.PageResponse;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

public interface IManagement<S extends Serializable, P, R extends AbstractEntityProperty, F extends Serializable> {

    R createOrUpdate(S s);
    R delete(P p);
    R findById(P p);
    PageResponse<R> findAll(F filter);
}
