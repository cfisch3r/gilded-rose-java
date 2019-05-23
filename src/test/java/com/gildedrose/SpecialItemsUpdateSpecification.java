package com.gildedrose;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Gilded Rose Special Item Specification")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SpecialItemsUpdateSpecification {

    @Test
    void Quality_Of_Brie_increases_with_time() {
        Item[] items = singleItemList("Aged Brie",5,10);
        updateItems(items);
        assertThat(items[0].quality).isEqualTo(11);
    }

    @Test
    @Tag("WTF")
    void Quality_Of_Brie_increases_twice_as_fast_after_sell_by_date() {
        Item[] items = singleItemList("Aged Brie",0,10);
        updateItems(items);
        assertThat(items[0].quality).isEqualTo(12);
    }

    @ParameterizedTest
    @ValueSource(ints = { 10,0,-1 })
    void Quality_Of_Brie_never_exceeds_50(int sellIn) {
        Item[] items = singleItemList("Aged Brie",sellIn,50);
        updateItems(items);
        assertThat(items[0].quality).isEqualTo(50);
    }

    @ParameterizedTest
    @ValueSource(ints = { 10,0,-1 })
    void Quality_for_Sulfuras_never_changes(int sellIn) {
        Item[] items = singleItemList("Sulfuras, Hand of Ragnaros",sellIn,10);
        updateItems(items);
        assertThat(items[0].quality).isEqualTo(10);
    }

    @Test
    void SellIn_for_Sulfuras_never_changes() {
        Item[] items = singleItemList("Sulfuras, Hand of Ragnaros",5,10);
        updateItems(items);
        assertThat(items[0].sellIn).isEqualTo(5);
    }

    @Test
    void Quality_Of_Backstage_Passes_increases_on_Update() {
        Item[] items = singleItemList("Backstage passes to a TAFKAL80ETC concert",15,10);
        updateItems(items);
        assertThat(items[0].quality).isEqualTo(11);
    }

    @Test
    void Quality_Of_Backstage_Passes_increases_by_2_when_sellin_less_or_equal_to_10() {
        Item[] items = singleItemList("Backstage passes to a TAFKAL80ETC concert",10,10);
        updateItems(items);
        assertThat(items[0].quality).isEqualTo(12);
    }

    @Test
    void Quality_Of_Backstage_Passes_increases_by_3_when_sellin_less_or_equal_to_5() {
        Item[] items = singleItemList("Backstage passes to a TAFKAL80ETC concert",5,10);
        updateItems(items);
        assertThat(items[0].quality).isEqualTo(13);
    }

    @Test
    void Quality_Of_Backstage_Passes_drops_to_0_when_sell_by_date_is_reached() {
        Item[] items = singleItemList("Backstage passes to a TAFKAL80ETC concert",0,10);
        updateItems(items);
        assertThat(items[0].quality).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = { 15,10,5,0,-1 })
    void Quality_Of_Backstage_Passes_never_exceeds_50() {
        Item[] items = singleItemList("Backstage passes to a TAFKAL80ETC concert",15,50);
        updateItems(items);
        assertThat(items[0].quality).isEqualTo(50);
    }

    private Item[] singleItemList(String item, int sellIn, int quality) {
        return new Item[]{new Item(item, sellIn, quality)};
    }

    private void updateItems(Item[] items) {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
    }
}
