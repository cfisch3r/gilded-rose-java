package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("As special Case Gilded Rose")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SpecialItemsUpdateSpecification {

    @Test
    void increases_Quality_Of_Brie_on_Update() {
        Item[] items = singleItemList("Aged Brie",5,10);
        updateItems(items);
        assertThat(items[0].quality).isEqualTo(11);
    }

    @Test
    void increases_Quality_Of_Brie_twice_as_fast_after_sell_by_date() {
        Item[] items = singleItemList("Aged Brie",0,10);
        updateItems(items);
        assertThat(items[0].quality).isEqualTo(12);
    }

    private Item[] singleItemList(String item, int sellIn, int quality) {
        return new Item[]{new Item(item, sellIn, quality)};
    }

    private void updateItems(Item[] items) {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
    }
}
