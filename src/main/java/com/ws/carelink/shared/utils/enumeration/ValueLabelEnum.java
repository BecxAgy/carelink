package com.ws.carelink.shared.utils.enumeration;

public interface ValueLabelEnum<C extends Enum<C>> {

    String getValue();

    String getLabel();
}