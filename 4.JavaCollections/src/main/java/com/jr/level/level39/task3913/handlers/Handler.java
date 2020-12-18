package com.jr.level.level39.task3913.handlers;

public interface Handler<E, B> {
    boolean handle(E entry, B box);
    Handler<E, B> linkNext(Handler<E, B> handler);
}
