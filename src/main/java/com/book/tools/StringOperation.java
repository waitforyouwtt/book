package com.book.tools;

import com.book.common.Constants;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author${罗显}
 * @date 2019/2/22
 * @time 14:06
 * 字符串操作工具类
 */
public class StringOperation extends org.apache.commons.lang3.StringUtils{
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
    public static char charAt(String target,Integer target2){
        return  target.charAt(target2);
    }
    /**
     * 拼接字符串
     * @param target
     * @param target2
     * @return
     */
    public static String concat(String target,String target2){
        return  target.concat(target2);
    }
    /**
     * 字符串转换为字节数组
     * @param str
     */
    public static byte[] getBytes(String str){
        if (str != null){
            try {
                return str.getBytes(Constants.CHARSET_ENCODING);
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        }else{
            return null;
        }
    }
    /**
     * 转换为字节数组
     */
    public static String toString(byte[] bytes){
        try {
            return new String(bytes, Constants.CHARSET_ENCODING);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
    /**
     * 是否包含字符串
     * @param str 验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inString(String str, String... strs){
        if (str != null){
            for (String s : strs){
                if (str.equals(trim(s))){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 替换掉HTML标签方法
     */
    public static String replaceHtml(String html) {
        if (isBlank(html)){
            return "";
        }
        String regEx = "<.+?>";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(html);
        String s = m.replaceAll("");
        return s;
    }
    /**
     * 替换为手机识别的HTML，去掉样式及属性，保留回车。
     * @param html
     * @return
     */
    public static String replaceMobileHtml(String html){
        if (html == null){
            return "";
        }
        return html.replaceAll("<([a-z]+?)\\s+?.*?>", "<$1>");
    }
    /**
     * 缩略字符串（不区分中英文字符）
     * @param str 目标字符串
     * @param length 截取长度
     * @return
     */
    public static String abbr(String str, int length) {
        if (str == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            int currentLength = 0;
            for (char c : replaceHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray()) {
                currentLength += String.valueOf(c).getBytes("GBK").length;
                if (currentLength <= length - 3) {
                    sb.append(c);
                } else {
                    sb.append("...");
                    break;
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
    /**
     * 转换为Double类型
     */
    public static Double toDouble(Object val){
        if (val == null){
            return 0D;
        }
        try {
            return Double.valueOf(trim(val.toString()));
        } catch (Exception e) {
            return 0D;
        }
    }

    /**
     * 转换为Float类型
     */
    public static Float toFloat(Object val){
        return toDouble(val).floatValue();
    }

    /**
     * 转换为Long类型
     */
    public static Long toLong(Object val){
        return toDouble(val).longValue();
    }

    /**
     * 转换为Integer类型
     */
    public static Integer toInteger(Object val){
        return toLong(val).intValue();
    }

    /**
     * 获得用户远程地址
     */
    public static String getRemoteAddr(HttpServletRequest request){
        String remoteAddr = request.getHeader("X-Real-IP");
        if (isNotBlank(remoteAddr)) {
            remoteAddr = request.getHeader("X-Forwarded-For");
        }else if (isNotBlank(remoteAddr)) {
            remoteAddr = request.getHeader("Proxy-Client-IP");
        }else if (isNotBlank(remoteAddr)) {
            remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
    }

    /**
     * 驼峰命名法工具
     * @return
     * 		toCamelCase("hello_world") == "helloWorld"
     * 		toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * 		toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }

        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == Constants.SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * 驼峰命名法工具
     * @return
     * 		toCamelCase("hello_world") == "helloWorld"
     * 		toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * 		toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCapitalizeCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = toCamelCase(s);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    /**
     * 驼峰命名法工具
     * @return
     * 		toCamelCase("hello_world") == "helloWorld"
     * 		toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * 		toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toUnderScoreCase(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            boolean nextUpperCase = true;

            if (i < (s.length() - 1)) {
                nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
            }

            if ((i > 0) && Character.isUpperCase(c)) {
                if (!upperCase || !nextUpperCase) {
                    sb.append(Constants.SEPARATOR);
                }
                upperCase = true;
            } else {
                upperCase = false;
            }

            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    /**
     * 如果不为空，则设置值
     * @param target
     * @param source
     */
    public static void setValueIfNotBlank(String target, String source) {
        if (isNotBlank(source)){
            target = source;
        }
    }

    /**
     * 转换为JS获取对象值，生成三目运算返回结果
     * @param objectString 对象串
     *   例如：row.user.id
     *   返回：!row?'':!row.user?'':!row.user.id?'':row.user.id
     */
    public static String jsGetVal(String objectString){
        StringBuilder result = new StringBuilder();
        StringBuilder val = new StringBuilder();
        String[] vals = split(objectString, ".");
        for (int i=0; i<vals.length; i++){
            val.append("." + vals[i]);
            result.append("!"+(val.substring(1))+"?'':");
        }
        result.append(val.substring(1));
        return result.toString();
    }

    /**
     * 判断对象为空，返回默认值
     *
     * @param obj
     * @param defaultValue
     * @return
     */
    public static Object getDefaultValue(Object obj, String defaultValue) {
        if(obj == null) {
            return defaultValue;
        } else {
            return obj;
        }
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
        System.out.println("根据类型判断目标是否以条件开头/结尾:"+startOrEndWith("你好啊","你","start"));
        System.out.println("回目标的第N位字符:"+charAt("你好啊",2));
        System.out.println("字符串连接："+concat("你","好"));
        System.out.println("字符串转换成字节数组："+getBytes("你好"));
    }
}
