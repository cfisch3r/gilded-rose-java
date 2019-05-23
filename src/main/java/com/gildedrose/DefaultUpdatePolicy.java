package com.gildedrose;

public class DefaultUpdatePolicy extends AbstractUpdatePolicy {

    public void update(Item item) {
        decreaseQuality(item);

        item.sellIn -= 1;

        if (item.sellIn < 0)
            decreaseQuality(item);
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0)
            item.quality -= 1;
    }
}