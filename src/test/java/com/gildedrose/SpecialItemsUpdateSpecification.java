package com.gildedrose;

import com.tngtech.jgiven.annotation.ScenarioStage;
import com.tngtech.jgiven.junit5.JGivenExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

@ExtendWith(JGivenExtension.class)
@BusinessRuleSpecification("Updates on Special Items")
class SpecialItemsUpdateSpecification {

    private static final int MAX_QUALITY = 50;

    @ScenarioStage
    GildedRoseScenario scenario;


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
        scenario
                .given().item_$_with_Sellin_of_$_and_Quality_of_$(ITEM_NAMES.AGED_BRIE.getName(),5,10)
                .when().items_are_updated()
                .then().Qualitity_of_the_item_is(11);
    }

    @Test
    @UnexpectedBehaviour
    void Quality_Of_Brie_increases_twice_as_fast_after_sell_by_date() {
        scenario
                .given().item_$_with_Sellin_of_$_and_Quality_of_$(ITEM_NAMES.AGED_BRIE.getName(),0,10)
                .when().items_are_updated()
                .then().Qualitity_of_the_item_is(12);
    }

    @ParameterizedTest
    @EnumSource(SELLIN_PERIODS.class)
    void Quality_Of_Brie_never_exceeds_50(SELLIN_PERIODS sellinPeriod) {
        scenario
                .given().item_$_with_Sellin_of_$_and_Quality_of_$(ITEM_NAMES.AGED_BRIE.getName(),sellinPeriod,MAX_QUALITY)
                .when().items_are_updated()
                .then().Qualitity_of_the_item_is(MAX_QUALITY);
    }

    @ParameterizedTest
    @EnumSource(SELLIN_PERIODS.class)
    void Quality_for_Sulfuras_never_changes(SELLIN_PERIODS sellinPeriod) {
        scenario
                .given().item_$_with_Sellin_of_$_and_Quality_of_$(ITEM_NAMES.SULFURAS.getName(),sellinPeriod,10)
                .when().items_are_updated()
                .then().Qualitity_of_the_item_is(10);
    }

    @Test
    void SellIn_for_Sulfuras_never_changes() {
        scenario
                .given().item_$_with_Sellin_of_$_and_Quality_of_$(ITEM_NAMES.SULFURAS.getName(),5,10)
                .when().items_are_updated()
                .then().SellIn_of_the_item_is(5);
    }

    @Test
    void Quality_Of_Backstage_Passes_increases_on_Update() {
        scenario
                .given().item_$_with_Sellin_of_$_and_Quality_of_$(ITEM_NAMES.BACKSTAGE_PASSES.getName(),15,10)
                .when().items_are_updated()
                .then().Qualitity_of_the_item_is(11);
     }

    @Test
    void Quality_Of_Backstage_Passes_increases_by_2_when_sellin_less_or_equal_to_10() {
        scenario
                .given().item_$_with_Sellin_of_$_and_Quality_of_$(ITEM_NAMES.BACKSTAGE_PASSES.getName(),10,10)
                .when().items_are_updated()
                .Qualitity_of_the_item_is(12);
    }

    @Test
    void Quality_Of_Backstage_Passes_increases_by_3_when_sellin_less_or_equal_to_5() {
        scenario
                .given().item_$_with_Sellin_of_$_and_Quality_of_$(ITEM_NAMES.BACKSTAGE_PASSES.getName(),5,10)
                .when().items_are_updated()
                .then().Qualitity_of_the_item_is(13);
    }

    @Test
    void Quality_Of_Backstage_Passes_drops_to_0_when_sell_by_date_is_reached() {
        scenario
                .given().item_$_with_Sellin_of_$_and_Quality_of_$(ITEM_NAMES.BACKSTAGE_PASSES.getName(),0,10)
                .when().items_are_updated()
                .then().Qualitity_of_the_item_is(0);
    }

    @ParameterizedTest
    @ValueSource(ints = { 15,10,5,0,-1 })
    void Quality_Of_Backstage_Passes_never_exceeds_50(int sellIn) {
        scenario
                .given().item_$_with_Sellin_of_$_and_Quality_of_$(ITEM_NAMES.BACKSTAGE_PASSES.getName(),sellIn,50)
                .when().items_are_updated()
                .then().Qualitity_of_the_item_is_less_or_equal(MAX_QUALITY);
    }

}
