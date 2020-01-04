package com.gildedrose.stages;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import java.util.ArrayList;
import java.util.List;

public class WhenStage extends Stage<WhenStage> {

    @ExpectedScenarioState
    List<Item> itemList = new ArrayList<>();

    public WhenStage items_are_updated() {
        GildedRose app = new GildedRose(itemList.toArray(new Item[]{}));
        app.updateQuality();
        return self();
    }



}
