package com.book.enums;

import com.google.common.collect.Lists;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
//服务人群
public enum ServicePopulationEnum {
    small_student("01","小学生"),
    middle_student("02","中学生"),
    hight_student("03","高中生"),
    foreigner("04","外国人"),
    INDIFFERENT("05","不关心");
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

    private static final Map<String, ServicePopulationEnum> valueLookup = new ConcurrentHashMap<>(values().length);

    static {
        for (ServicePopulationEnum type : EnumSet.allOf(ServicePopulationEnum.class)) {
            valueLookup.put(type.value, type);
        }
    }

    ServicePopulationEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public static ServicePopulationEnum resolve(String value) {

        return (value != null ? valueLookup.get(value) : null);
    }

    public static ServicePopulationEnum fromValue(String value) {
        ServicePopulationEnum data = valueLookup.get(value);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + value + "]不正确，没有找到对应的 GenderEnum");
        }
        return data;
    }

    public static List <Map> channelTypeEnumList() {
        List list = Lists.newArrayList();
        for (ServicePopulationEnum channelTypeEnum : ServicePopulationEnum.values()) {
            Map<String, Object> map = new HashMap<>();
            map.put("value", channelTypeEnum.getValue());
            map.put("name", channelTypeEnum.getName());
            list.add(map);
        }
        return list;
    }

    public static List<String> channelTypeEnums(){
        List<String> list = Lists.newArrayList();
        for (ServicePopulationEnum channelTypeEnum : ServicePopulationEnum.values()) {
            list.add(channelTypeEnum.getValue());
        }
        return list;
    }
}
