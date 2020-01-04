package com.gildedrose.tags;

import com.tngtech.jgiven.annotation.IsTag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IsTag( name = "Unexpected Behaviour",
        description = "Discussion with PO required" )
@Retention( RetentionPolicy.RUNTIME )
public @interface UnexpectedBehaviour {
}
