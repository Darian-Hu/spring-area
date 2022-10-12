package com.area.demo.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 编码相关工具
 * @author kai.hu
 * @date 2019/12/2
 */
public class CodingUtil {

    /**
     * 获取字符串编码
     * @author kai.hu
     * @date 2019/12/3
     */
    public static String getEncoding(String str) {
        try {
            String encode = "GB2312";
            if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是GB2312
                return encode;
            }

            encode = "ISO-8859-1";
            if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是ISO-8859-1
                return encode;
            }

            encode = "UTF-8";
            if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是UTF-8
                return encode;
            }

            encode = "GBK";
            if (str.equals(new String(str.getBytes(encode), encode))) { //判断是不是GBK
                return encode;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 字符串转码（GB2312转UTR-8）
     * @author kai.hu
     * @date 2019/12/3
     */
    public static String gb2312ToUtf8(String str) {
        String urlEncode = "";
        try {
            urlEncode = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return urlEncode;
    }
    /**
     * 字符串转码（UTR-8G转GB2312）
     * @author kai.hu
     * @date 2019/12/3
     */
    public static String utf8ToGb2312(String str) {
        String urlEncode = "";
        try {
            urlEncode = URLEncoder.encode(str, "GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return urlEncode;
    }
}