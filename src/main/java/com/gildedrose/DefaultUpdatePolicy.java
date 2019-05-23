package com.gildedrose;

public class DefaultUpdatePolicy {
    public DefaultUpdatePolicy() {
    }

    void update(Item item) {
        if (item.quality > 0)
            item.quality = item.quality - 1;

        item.sellIn = item.sellIn - 1;

        if (item.quality > 0 && item.sellIn < 0)
            item.quality = item.quality - 1;
    }
}