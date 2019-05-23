package com.gildedrose;

public interface UpdatePolicy {
    void update(Item item);

    UpdatePolicy and(UpdatePolicy nextUpdatePolicy);
}
