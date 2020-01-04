package com.gildedrose.stages;

import com.gildedrose.Item;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ThenStage extends Stage<ThenStage> {

    @ExpectedScenarioState
    List<Item> itemList = new ArrayList<>();

    public ThenStage Qualitity_of_the_item_is(int expectedQuality) {
        assertThat(itemList.get(0).quality).isEqualTo(expectedQuality);
        return self();
    }

    public ThenStage Qualitity_of_the_item_is_less_or_equal(int qualityLimit) {
        assertThat(itemList.get(0).quality).isLessThanOrEqualTo(qualityLimit);
        return self();
    }

    public ThenStage SellIn_of_the_item_is(int expectedSellIn) {
        assertThat(itemList.get(0).sellIn).isEqualTo(expectedSellIn);
        return self();
    }
}
