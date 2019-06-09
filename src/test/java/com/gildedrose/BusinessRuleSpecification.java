package com.gildedrose;

import com.tngtech.jgiven.annotation.IsTag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IsTag( name="Business Rules",
        prependType = false)
@Retention( RetentionPolicy.RUNTIME )
public @interface BusinessRuleSpecification {
    String value();
}
