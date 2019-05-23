package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Gilded Rose")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GildedRoseTest {

    @Test
    public void reduces_Item_Quality_on_Update() {
        Item[] items = new Item[] { new Item("item", 5, 8) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(7);
    }

    @Test
    public void reduces_Item_Sell_In_on_Update() {
        Item[] items = new Item[] { new Item("item", 5, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].sellIn).isEqualTo(4);
    }
}
