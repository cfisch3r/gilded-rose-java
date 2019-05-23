package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Gilded Rose General Item Update Specification")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GildedRoseTest {

    @Test
    void Item_Quality_is_reduces_on_Update() {
        Item[] items = singleItemList(5, 8);
        updateItems(items);
        assertThat(items[0].quality).isEqualTo(7);
    }


    @ParameterizedTest
    @ValueSource(ints = { 0,-1 })
    void Item_Quality_is_reduced_twice_as_fast_after_sell_by_date(int sellIn) {
        Item[] items = singleItemList(sellIn, 10);
        updateItems(items);
        assertThat(items[0].quality).isEqualTo(8);
    }

    @Test
    void Item_Sellin_is_reduces_on_Update() {
        Item[] items = singleItemList(5, 7);
        updateItems(items);
        assertThat(items[0].sellIn).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(ints = { 5,0,-1 })
    void Item_Quality_never_drops_below_zero(int sellIn) {
        Item[] items = singleItemList(sellIn, 0);
        updateItems(items);
        assertThat(items[0].quality).isEqualTo(0);
    }

    private Item[] singleItemList(int sellIn, int quality) {
        return new Item[]{new Item("", sellIn, quality)};
    }

    private void updateItems(Item[] items) {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
    }
}
