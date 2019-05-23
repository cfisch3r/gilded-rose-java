package com.gildedrose;

class GildedRose {
    Item[] items;
    private UpdatePolicy updatePolicy = UpdatePolicyFactory.create();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updatePolicy.update(item);
        }
    }

}