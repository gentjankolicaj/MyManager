package io.gentjankolicaj.app.mymanager.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum QueryType {

    NORMAL("NORMAL"), AUDIT("AUDIT");

    private final String value;

}
