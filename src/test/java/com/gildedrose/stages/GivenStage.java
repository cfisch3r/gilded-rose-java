package com.gildedrose.stages;

import com.gildedrose.Item;
import com.gildedrose.SELLIN_PERIODS;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import java.util.ArrayList;
import java.util.List;

public class GivenStage extends Stage<GivenStage> {

    @ProvidedScenarioState
    List<Item> itemList = new ArrayList<>();

    public GivenStage an_item_with_Sellin_of_$_and_Quality_of_$(int sellIn, int quality) {
        itemList.add(new Item("", sellIn, quality));
        return self();
    }

    public GivenStage item_$_with_Sellin_of_$_and_Quality_of_$(String name, int sellIn, int quality) {
        itemList.add(new Item(name, sellIn, quality));
        return self();
    }

    public GivenStage an_item_with_Sellin_of_$_and_Quality_of_$(SELLIN_PERIODS sellInPeriod, int quality) {
        itemList.add(new Item("", sellInPeriod.value(), quality));
        return self();
    }

    public GivenStage item_$_with_Sellin_of_$_and_Quality_of_$(String name, SELLIN_PERIODS sellInPeriod, int quality) {
        itemList.add(new Item(name, sellInPeriod.value(), quality));
        return self();
    }
}
