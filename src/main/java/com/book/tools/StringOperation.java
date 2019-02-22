package com.book.tools;

import com.book.common.Constants;
import org.apache.commons.lang3.StringUtils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author${罗显}
 * @date 2019/2/22
 * @time 14:06
 * 字符串操作工具类
 */
public class StringOperation {
    /**
     * 根据指定长度生成随机数字和字母
     * @param length
     */
    public static String stringRandomGenerate(int length) {
        String val = "";
        Random random = new Random();
        //length为几位密码
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
    /**
     *随机生成6位数字
     */
    public static int generateSixNumber(){
        //10000 -5位 1000-4位
        return  (int)((Math.random()*9+1)*100000);
    }
    /**
     * 随机生成5-6位数字
     */
    public static int generateNumber() {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random rand = new Random();
        for (int i = 10; i > 1; i--) {
            int index = rand.nextInt(i);
            int tmp = array[index];
            array[index] = array[i - 1];
            array[i - 1] = tmp;
        }
        int result = 0;
        for (int i = 0; i < 6; i++) {
            result = result * 10 + array[i];
        }
        return result;
    }
    /**
     * 只显示第一个汉字，其他隐藏为2个星号<例子：李**>
     * @param str
     * @param index 1 为从第index位开始隐藏
     */
    public static String hideStrIndex(String str, int index) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        return StringUtils.rightPad(StringUtils.left(str, index), StringUtils.length(str), "*");
    }
    /**
     * 110****58，前面保留n位明文，后面保留m位明文
     * @param str
     * @param  n
     * @param  m
     */
    public static String hideAround(String str, int n, int m) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        return StringUtils.left(str, n).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(str, m), StringUtils.length(str), "*"), "***"));
    }
    /**
     * 显示后n位，其他隐藏<例子：****1234>
     * @param str
     */
    public static String hideRight(String str, int end) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        return StringUtils.leftPad(StringUtils.right(str, end), StringUtils.length(str), "*");
    }

    /**
     * 判断是否是中文
     * @param str
     */
    public static boolean isChineseStr(String str) {
        Pattern pattern = Pattern.compile("^[\u4E00-\u9FA5]+$");
        char[] c = str.toCharArray();

        for (int i = 0; i < c.length; ++i) {
            Matcher matcher = pattern.matcher(String.valueOf(c[i]));
            if (!matcher.matches()) {
                return false;
            }
        }
        return true;
    }
    /**
     * 获取字符串的长度
     * @param s
     */
    public static int strLength(String s) {
        int valueLength = 0;
        String chinese = s;

        for (int i = 0; i < s.length(); ++i) {
            String temp = s.substring(i, i + 1);
            if (temp.matches(chinese)) {
                ++valueLength;
            } else {
                ++valueLength;
            }
        }
        return valueLength;
    }
    /**
     * 根据类型将目标变成大/小写，返回结果
     * @param target
     * @return
     */
    public static String toUpperCase(String target,String type){
        if(Constants.UPPER.equals(type)){
            return target.toUpperCase();
        }else if(Constants.LOWER.equals(type)){
            return target.toLowerCase();
        }else{
            return target;
        }
    }
    /**
     * compareTo()的返回值是整型,它是先比较对应字符的大小(ASCII码顺序),
     * 如果第一个字符和参数的第一个字符不等,结束比较,返回他们之间的差值,
     * 如果第一个字符和参数的第一个字符相等,则以第二个字符和参数的第二个字符做比较,
     * 以此类推,直至比较的字符或被比较的字符有一方全比较完,这时就比较字符的长度.
     * @param var1
     * @param var2
     */
    public int toCompareTo(String var1,String var2){
        return var1.compareTo(var2);
    }
    /**
     * 比较时不区分大小写
     * @param var1
     * @param var2
     * @return 返回0 则相等，否则不相等
     */
    public static int compareToIgnoreCase(String var1,String var2){
        return var1.compareToIgnoreCase(var2);
    }
    /**
     * 以空格进行拆分
     * @param str
     */
    public static String toSplit(String str){
        String [] arr = str.split("\\s+");
        for(String ss : arr){
            System.out.println("得到的结果："+ss);
        }
       return null;
    }
    /**
     * @param target
     * @param target2
     */
    public static boolean toEquals(String target,String target2){
        return target.equals(target2);
    }
    /**
     * 返回字符串的长度
     * @param target
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
    public static String substring(String target,Integer length,Integer length2){
        if(org.springframework.util.StringUtils.isEmpty(length2)){
            return  target.substring(length);
        }else{
            return target.substring(length,length2);
        }
    }
    /**
     * 根据类型判断目标是否以条件开头/结尾
     * @param target
     * @param target2
     */
    public static boolean startOrEndWith(String target,String target2,String type){
        if(Constants.START_WITH.equals(type)){
            return  target.startsWith(target2);
        }else if(Constants.END_WITH.equals(type)){
            return  target.endsWith(target2);
        }
        return false;
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


    public static void main(String[] args) {
        System.out.println("根据指定长度生成随机数字和字母："+stringRandomGenerate(6));
        System.out.println("根据指定长度生成随机数字："+generateSixNumber());
        System.out.println("隐藏字符："+hideStrIndex("根据指定长度生成随机数字",2));
        System.out.println("隐藏中间字符："+hideAround("76854930-232",2,6));
        System.out.println("隐藏前面字符："+hideRight("76854930-232",6));
        System.out.println("获取字符串的长度："+strLength("中国"));
        System.out.println("将目标小写变大写："+toUpperCase("BB",null));
        System.out.println("比较字符串是否相等[不区分大小写]："+compareToIgnoreCase("BB","b"));
        //System.out.println("以空格进行拆分："+toSplit("e afd"));;
        System.out.println("比较字符串是否相等："+toEquals("BB","BB"));
        System.out.println("获取字符串的长度："+strLength("中国"));
        System.out.println("截取字符串："+substring("你好啊小姐姐",2,4));
        System.out.println("pa"+startOrEndWith("你好啊","你","start"));
    }
}
