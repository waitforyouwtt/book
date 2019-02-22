package com.book.utils;

import org.springframework.util.StringUtils;

/**
 * @Author: 一点点
 * @Date: 2018/10/3 17:13
 * @Version 1.0
 */
public class OperationString {

    /**
     * 将第一个目标替换成第二个目标字，返回结果
     * @param var1
     * @param var2
     * @param result
     * @return
     */
    public String strReplace(String var1 ,String var2,String result){
        result = result.replace(var1,var2);
        //result = result.replaceAll(var1,var2);
        return result;
    }
    /**
     * 将目标小写变大写，返回结果
     * @param target
     * @return
     */
    public String toUpperCase(String target){
        target = target.toUpperCase();
        return target;
    }
    /***
     * 将目标大写变小写，返回结果
     * @param target
     * @return
     */
    public String toLowerCase(String target){
        target = target.toLowerCase();
        return target;
    }
    /**
     * compareTo()的返回值是整型,它是先比较对应字符的大小(ASCII码顺序),
     * 如果第一个字符和参数的第一个字符不等,结束比较,返回他们之间的差值,
     * 如果第一个字符和参数的第一个字符相等,则以第二个字符和参数的第二个字符做比较,
     * 以此类推,直至比较的字符或被比较的字符有一方全比较完,这时就比较字符的长度.
     * @param var1
     * @param var2
     * @return
     */
    public int toCompareTo(String var1,String var2){
        return var1.compareTo(var2);
    }
    /**
     * 比较时不区分大小写
     * @param var1
     * @param var2
     * @return
     */
    public int compareToIgnoreCase(String var1,String var2){
        return var1.compareToIgnoreCase(var2);
    }
    /**
     * 比较时不区分大小写
     * @param var1
     * @param var2
     * @return
     */
    public boolean equalsIgnoreCase(String var1,String var2){
        return var1.equalsIgnoreCase(var2);
    }
    /**
     * 以空格进行拆分
     * @param target
     * @return
     */
    public String toSplit(String target){
        String[]temp=target.split(" ");
        String result = null;
        for(int i=0;i<temp.length;i++){
            result = temp[i];
        }
        return result;
    }
    /**
     *
     * @param target
     * @param target2
     * @return
     */
    public boolean toEquals(String target,String target2){
        return target.equals(target2);
    }
    /**
     * 返回字符串的长度
     * @param target
     * @return
     */
    public int targetLength(String target){
        return target.length();
    }
    /**
     * 从第几位开始截取，返回截取后的结果[如果第二个参数为空]
     * 第几位开始截取，返回截取到想要的位置[第二个参数不为空]
     * @param target
     * @param length
     * @return
     */
    public String substring(String target,Integer length,Integer length2){
        if(StringUtils.isEmpty(length2)){
            return  target.substring(length);
        }else{
            return target.substring(length,length2);
        }
    }
    /**
     * 目标是否以条件开头
     * @param target
     * @param target2
     * @return
     */
    public boolean startsWith(String target,String target2){
        return  target.startsWith(target2);
    }
    /**
     * 目标是否以条件结尾
     * @param target
     * @param target2
     * @return
     */
    public boolean endsWith(String target,String target2){
        return  target.endsWith(target2);
    }
    /**
     * 返回目标的第N位字符
     * @param target
     * @param target2
     * @return
     */
    public char charAt(String target,Integer target2){
        return  target.charAt(target2);
    }

    /**
     * 拼接字符串
     * @param target
     * @param target2
     * @return
     */
    public String concat(String target,String target2){
        return  target.concat(target2);
    }
}
