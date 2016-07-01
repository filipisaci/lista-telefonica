package com.tecweb.enterprise;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by andrei on 30/06/16.
 */

public abstract class AbstractRepresentationBuilder<E, R, B> {

    protected abstract E fromRepresentation(R dto, B builder);

    protected abstract R toRepresentation(E e);

    public Collection<R> toRepresentation(Collection<E> e) {
        return e.stream().map(this::toRepresentation).collect(Collectors.toList());
    }

    public Collection<E> fromRepresentation(Collection<R> r, B builder) {
        return r.stream().map(e -> fromRepresentation(e, builder)).collect(Collectors.toList());
    }
}