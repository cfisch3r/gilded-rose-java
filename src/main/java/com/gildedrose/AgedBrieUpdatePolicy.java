package com.gildedrose;

public class AgedBrieUpdatePolicy {
    public AgedBrieUpdatePolicy() {
    }

    void update(Item item) {
        if (item.quality < 50)
            item.quality = item.quality + 1;

        item.sellIn = item.sellIn - 1;

        if (item.quality < 50 && item.sellIn < 0)
            item.quality = item.quality + 1;
    }
}