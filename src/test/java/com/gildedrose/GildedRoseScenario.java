package com.gildedrose;

import com.tngtech.jgiven.Stage;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseScenario extends Stage<GildedRoseScenario> {

    private List<Item> itemList = new ArrayList<>();

    GildedRoseScenario an_item_with_Sellin_of_$_and_Quality_of_$(int sellIn, int quality) {
        itemList.add(new Item("", sellIn, quality));
        return self();
    }

    GildedRoseScenario item_$_with_Sellin_of_$_and_Quality_of_$(String name, int sellIn, int quality) {
        itemList.add(new Item(name, sellIn, quality));
        return self();
    }

    GildedRoseScenario an_item_with_Sellin_of_$_and_Quality_of_$(SELLIN_PERIODS sellInPeriod, int quality) {
        itemList.add(new Item("", sellInPeriod.value(), quality));
        return self();
    }

    GildedRoseScenario item_$_with_Sellin_of_$_and_Quality_of_$(String name, SELLIN_PERIODS sellInPeriod, int quality) {
        itemList.add(new Item(name, sellInPeriod.value(), quality));
        return self();
    }

    GildedRoseScenario items_are_updated() {
        GildedRose app = new GildedRose(itemList.toArray(new Item[]{}));
        app.updateQuality();
        return self();
    }

    GildedRoseScenario Qualitity_of_the_item_is(int expectedQuality) {
        assertThat(itemList.get(0).quality).isEqualTo(expectedQuality);
        return self();
    }

    GildedRoseScenario Qualitity_of_the_item_is_less_or_equal(int qualityLimit) {
        assertThat(itemList.get(0).quality).isLessThanOrEqualTo(qualityLimit);
        return self();
    }

    GildedRoseScenario SellIn_of_the_item_is(int expectedSellIn) {
        assertThat(itemList.get(0).sellIn).isEqualTo(expectedSellIn);
        return self();
    }
}
