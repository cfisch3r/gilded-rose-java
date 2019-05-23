package com.gildedrose;

class SulfurasUpdatePolicy extends AbstractUpdatePolicy{

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public void update(Item item) {
        if (!item.name.equals(SULFURAS))
            forward(item);
    }
}
