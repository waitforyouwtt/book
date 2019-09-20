package com.book.enums;

import com.google.common.collect.Lists;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum LeisureActivitiesEnum {
    IN_HONE("01","宅家"),
    HEALTH("02","健身"),
    READ("03","读书"),
    FILM("04","看电影"),
    PARTY("05","陪异性朋友"),
    WORK("06","兼职");

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

    private static final Map<String, LeisureActivitiesEnum> valueLookup = new ConcurrentHashMap<>(values().length);

    static {
        for (LeisureActivitiesEnum type : EnumSet.allOf(LeisureActivitiesEnum.class)) {
            valueLookup.put(type.value, type);
        }
    }

    LeisureActivitiesEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public static LeisureActivitiesEnum resolve(String value) {

        return (value != null ? valueLookup.get(value) : null);
    }

    public static LeisureActivitiesEnum fromValue(String value) {
        LeisureActivitiesEnum data = valueLookup.get(value);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + value + "]不正确，没有找到对应的 GenderEnum");
        }
        return data;
    }

    public static List <Map> channelTypeEnumList() {
        List list = Lists.newArrayList();
        for (LeisureActivitiesEnum channelTypeEnum : LeisureActivitiesEnum.values()) {
            Map<String, Object> map = new HashMap<>();
            map.put("value", channelTypeEnum.getValue());
            map.put("name", channelTypeEnum.getName());
            list.add(map);
        }
        return list;
    }

    public static List<String> channelTypeEnums(){
        List<String> list = Lists.newArrayList();
        for (LeisureActivitiesEnum channelTypeEnum : LeisureActivitiesEnum.values()) {
            list.add(channelTypeEnum.getValue());
        }
        return list;
    }
}
