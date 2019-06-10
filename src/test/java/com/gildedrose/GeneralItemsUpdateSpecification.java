package com.gildedrose;

import com.tngtech.jgiven.annotation.ScenarioStage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@BusinessCaseSpecification("Updates on General Items")
class GeneralItemsUpdateSpecification {

    @ScenarioStage
    GildedRoseScenario scenario;

    @Test
    void Item_Quality_is_reduced_on_Update() {
        scenario
                .given().an_item_with_Sellin_of_$_and_Quality_of_$(5,8)
                .when().items_are_updated()
                .then().Qualitity_of_the_item_is(7);
    }


    @ParameterizedTest
    @EnumSource(value = SELLIN_PERIODS.class, names = { "ON_SELL_BY_DATE", "AFTER_SELL_BY_DATE" })
    void Item_Quality_is_reduced_twice_as_fast_after_sell_by_date(SELLIN_PERIODS sellInPeriod) {
        scenario
                .given().an_item_with_Sellin_of_$_and_Quality_of_$(sellInPeriod,10)
                .when().items_are_updated()
                .then().Qualitity_of_the_item_is(8);
    }

    @Test
    void Item_Sellin_is_reduces_on_Update() {
        scenario
                .given().an_item_with_Sellin_of_$_and_Quality_of_$(5,7)
                .when().items_are_updated()
                .then().SellIn_of_the_item_is(4);
    }

    @ParameterizedTest
    @EnumSource(SELLIN_PERIODS.class)
    void Item_Quality_never_drops_below_zero(SELLIN_PERIODS sellinPeriod) {
        scenario
                .given().an_item_with_Sellin_of_$_and_Quality_of_$(sellinPeriod,0)
                .when().items_are_updated()
                .then().Qualitity_of_the_item_is(0);
    }
}
