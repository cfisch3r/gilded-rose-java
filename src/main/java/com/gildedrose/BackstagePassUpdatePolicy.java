package com.gildedrose;

public class BackstagePassUpdatePolicy extends AbstractUpdatePolicy {

    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final int FIRST_QUALITY_RAISE_PERIOD = 10;
    private static final int SECOND_QUALITY_RAISE_PERIOD = 5;

    public void update(Item item) {
        if (item.name.equals(BACKSTAGE_PASS)) {
            increaseQuality(item);

            item.sellIn -= 1;

            if (item.sellIn < FIRST_QUALITY_RAISE_PERIOD)
                increaseQuality(item);

            if (item.sellIn < SECOND_QUALITY_RAISE_PERIOD)
                increaseQuality(item);


            if (item.sellIn < 0)
                item.quality = 0;
        } else {
            forward(item);
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50)
            item.quality += 1;
    }
}