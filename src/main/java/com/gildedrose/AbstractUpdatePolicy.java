package com.gildedrose;

abstract class AbstractUpdatePolicy implements UpdatePolicy {

    private UpdatePolicy nextUpdatePolicy;

    public abstract void update(Item item);

    public UpdatePolicy and(UpdatePolicy nextUpdatePolicy) {
        this.nextUpdatePolicy = nextUpdatePolicy;
        return this.nextUpdatePolicy;
    }

    protected void forward(Item item) {
        if (nextUpdatePolicy != null)
            nextUpdatePolicy.update(item);
    }
}
