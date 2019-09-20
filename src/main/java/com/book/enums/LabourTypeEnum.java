package com.book.enums;

import com.google.common.collect.Lists;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
//兼职类型：01 体力，02 脑力 03，不关心
public enum LabourTypeEnum {
    PHYSICAL_LABOR("01","体力劳动"),
    MENTAL_LABOUR("02","脑力劳动"),
    INDIFFERENT("03","不关心")
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

    private static final Map<String, LabourTypeEnum> valueLookup = new ConcurrentHashMap<>(values().length);

    static {
        for (LabourTypeEnum type : EnumSet.allOf(LabourTypeEnum.class)) {
            valueLookup.put(type.value, type);
        }
    }

    LabourTypeEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public static LabourTypeEnum resolve(String value) {

        return (value != null ? valueLookup.get(value) : null);
    }

    public static LabourTypeEnum fromValue(String value) {
        LabourTypeEnum data = valueLookup.get(value);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + value + "]不正确，没有找到对应的 LabourTypeEnum");
        }
        return data;
    }

    public static List <Map> channelTypeEnumList() {
        List list = Lists.newArrayList();
        for (LabourTypeEnum channelTypeEnum : LabourTypeEnum.values()) {
            Map<String, Object> map = new HashMap<>();
            map.put("value", channelTypeEnum.getValue());
            map.put("name", channelTypeEnum.getName());
            list.add(map);
        }
        return list;
    }

    public static List<String> channelTypeEnums(){
        List<String> list = Lists.newArrayList();
        for (LabourTypeEnum channelTypeEnum : LabourTypeEnum.values()) {
            list.add(channelTypeEnum.getValue());
        }
        return list;
    }
}
