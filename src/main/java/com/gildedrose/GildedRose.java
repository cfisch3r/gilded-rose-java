package com.gildedrose;

class GildedRose {
    private final AgedBrieUpdatePolicy agedBrieUpdatePolicy = new AgedBrieUpdatePolicy();
    private final BackstagePassUpdatePolicy backstagePassUpdatePolicy = new BackstagePassUpdatePolicy();
    private final DefaultUpdatePolicy defaultUpdatePolicy = new DefaultUpdatePolicy();
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals("Aged Brie")) {
                agedBrieUpdatePolicy.update(items[i]);

            } else if(items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                backstagePassUpdatePolicy.update(items[i]);

            } else if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {


            } else {
                defaultUpdatePolicy.update(items[i]);
            }

        }
    }

    private void update(Item item) {

        defaultUpdatePolicy.update(item);
    }


}