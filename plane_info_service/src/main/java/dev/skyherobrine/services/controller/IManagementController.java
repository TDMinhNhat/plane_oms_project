package dev.skyherobrine.services.controller;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import dev.skyherobrine.library.models.PageResponse;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

public interface IManagementController<S extends Serializable, P, R extends AbstractEntityProperty, F extends Serializable> {

    ResponseEntity<R> createOrUpdate(S s);
    ResponseEntity<R> delete(P p);
    ResponseEntity<PageResponse<R>> findAll(F f);
}
