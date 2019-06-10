package com.gildedrose;

import com.tngtech.jgiven.annotation.IsTag;
import com.tngtech.jgiven.junit5.JGivenExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@ExtendWith(JGivenExtension.class)
@IsTag( name="Business Cases")
@Retention( RetentionPolicy.RUNTIME )
public @interface BusinessCaseSpecification {
    String value();
}
