package com.gildedrose;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Gilded Rose Special Item Specification")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SpecialItemsUpdateSpecification {

    private static final int MAX_QUALITY = 50;

    private enum ITEM_NAMES {
        AGED_BRIE("Aged Brie"),
        SULFURAS("Sulfuras, Hand of Ragnaros"),
        BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert");

        private String name;

        ITEM_NAMES(String name) {

            this.name = name;
        }

        private String getName() {
            return name;
        }
    }

    @Test
    void Quality_Of_Brie_increases_with_time() {
        Item[] items = singleItemList(ITEM_NAMES.AGED_BRIE,5,10);
        updateItems(items);
        assertThat(items[0].quality).isEqualTo(11);
    }

    @Test
    @Tag("WTF")
    void Quality_Of_Brie_increases_twice_as_fast_after_sell_by_date() {
        Item[] items = singleItemList(ITEM_NAMES.AGED_BRIE,0,10);
        updateItems(items);
        assertThat(items[0].quality).isEqualTo(12);
    }

    @ParameterizedTest
    @EnumSource(SELLIN_PERIODS.class)
    void Quality_Of_Brie_never_exceeds_50(SELLIN_PERIODS sellinPeriods) {
        Item[] items = singleItemList(ITEM_NAMES.AGED_BRIE,sellinPeriods.value(),50);
        updateItems(items);
        assertThat(items[0].quality).isLessThanOrEqualTo(MAX_QUALITY);
    }

    @ParameterizedTest
    @EnumSource(SELLIN_PERIODS.class)
    void Quality_for_Sulfuras_never_changes(SELLIN_PERIODS sellinPeriods) {
        Item[] items = singleItemList(ITEM_NAMES.SULFURAS,sellinPeriods.value(),10);
        updateItems(items);
        assertThat(items[0].quality).isEqualTo(10);
    }

    @Test
    void SellIn_for_Sulfuras_never_changes() {
        Item[] items = singleItemList(ITEM_NAMES.SULFURAS,5,10);
        updateItems(items);
        assertThat(items[0].sellIn).isEqualTo(5);
    }

    @Test
    void Quality_Of_Backstage_Passes_increases_on_Update() {
        Item[] items = singleItemList(ITEM_NAMES.BACKSTAGE_PASSES,15,10);
        updateItems(items);
        assertThat(items[0].quality).isEqualTo(11);
    }

    @Test
    void Quality_Of_Backstage_Passes_increases_by_2_when_sellin_less_or_equal_to_10() {
        Item[] items = singleItemList(ITEM_NAMES.BACKSTAGE_PASSES,10,10);
        updateItems(items);
        assertThat(items[0].quality).isEqualTo(12);
    }

    @Test
    void Quality_Of_Backstage_Passes_increases_by_3_when_sellin_less_or_equal_to_5() {
        Item[] items = singleItemList(ITEM_NAMES.BACKSTAGE_PASSES,5,10);
        updateItems(items);
        assertThat(items[0].quality).isEqualTo(13);
    }

    @Test
    void Quality_Of_Backstage_Passes_drops_to_0_when_sell_by_date_is_reached() {
        Item[] items = singleItemList(ITEM_NAMES.BACKSTAGE_PASSES,0,10);
        updateItems(items);
        assertThat(items[0].quality).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = { 15,10,5,0,-1 })
    void Quality_Of_Backstage_Passes_never_exceeds_50(int sellIn) {
        Item[] items = singleItemList(ITEM_NAMES.BACKSTAGE_PASSES,sellIn,50);
        updateItems(items);
        assertThat(items[0].quality).isLessThanOrEqualTo(MAX_QUALITY);
    }

    private Item[] singleItemList(ITEM_NAMES itemName, int sellIn, int quality) {
        return new Item[]{new Item(itemName.getName(), sellIn, quality)};
    }

    private void updateItems(Item[] items) {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
    }
}
