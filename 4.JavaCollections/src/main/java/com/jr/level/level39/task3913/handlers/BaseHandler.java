package com.jr.level.level39.task3913.handlers;

public abstract class BaseHandler<E, B> implements Handler<E, B> {
    private Handler<E, B> next;

    @Override
    public Handler<E, B> linkNext(Handler<E, B> next){
        if(next != null) {
            this.next = next;
            return next;
        }
        return this;
    }

    @Override
    public abstract boolean handle(E entry, B box);

    protected boolean handleNext(E entry, B box){
        if(next != null){
            return next.handle(entry, box);
        }
        return true;
    }

}
