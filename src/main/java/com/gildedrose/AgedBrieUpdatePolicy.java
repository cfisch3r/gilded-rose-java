package com.gildedrose;

class AgedBrieUpdatePolicy extends AbstractUpdatePolicy {

    private static final String AGED_BRIE = "Aged Brie";

    public void update(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            increaseQuality(item);

            item.sellIn -= 1;

            if (item.sellIn < 0)
                increaseQuality(item);
        } else {
            forward(item);
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50)
            item.quality += 1;
    }
}