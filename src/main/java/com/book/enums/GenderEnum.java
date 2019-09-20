package com.book.enums;

import com.google.common.collect.Lists;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum GenderEnum {
    MAN("01","男"),
    WO_MAN("02","女")
    ;

    private String value;

    private String name;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static final Map<String, GenderEnum> valueLookup = new ConcurrentHashMap<>(values().length);

    static {
        for (GenderEnum type : EnumSet.allOf(GenderEnum.class)) {
            valueLookup.put(type.value, type);
        }
    }

    GenderEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public static GenderEnum resolve(String value) {

        return (value != null ? valueLookup.get(value) : null);
    }

    public static GenderEnum fromValue(String value) {
        GenderEnum data = valueLookup.get(value);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + value + "]不正确，没有找到对应的 GenderEnum");
        }
        return data;
    }

    public static List <Map> channelTypeEnumList() {
        List list = Lists.newArrayList();
        for (GenderEnum channelTypeEnum : GenderEnum.values()) {
            Map<String, Object> map = new HashMap<>();
            map.put("value", channelTypeEnum.getValue());
            map.put("name", channelTypeEnum.getName());
            list.add(map);
        }
        return list;
    }

    public static List<String> channelTypeEnums(){
        List<String> list = Lists.newArrayList();
        for (GenderEnum channelTypeEnum : GenderEnum.values()) {
            list.add(channelTypeEnum.getValue());
        }
        return list;
    }
}
