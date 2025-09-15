package dev.tdminhnhat.service.services;

import dev.skyherobrine.library.models.PageResponse;

import java.util.Collection;

public interface IServiceManagement<S extends Record, P, R, F extends Record> {
    R add(S entity);
    R update(P id, S entity);
    R delete(P p);
    R findById(P p);
    Collection<R> findAll();
    PageResponse<?> findAll(F filter);
}
