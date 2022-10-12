package com.area.demo.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * http相关工具
 * @author kai.hu
 * @date 2019/12/2
 */
public class HttpUtil {

    /**
     * 获取网页内容
     * @author kai.hu
     * @date 2019/12/2
     */
    public static String getContent(String strUrl, String chrSet) {
        String webInfo = "";
        try {
            // 获取网页数据
            URL url = new URL(strUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(30000);
            connection.setReadTimeout(30000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), chrSet));

            // 读取数据
            StringBuilder builder = new StringBuilder("");
            String str = "";
            while ((str = reader.readLine()) != null) {
                builder.append(str);
            }
            reader.close();
            webInfo = builder.toString();
            System.out.println(builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return webInfo;
    }

    /**
     * 设置代理
     * @author kai.hu
     * @date 2019/12/3
     */
    public void initProxy(String host, String port) {
        System.setProperty("http.proxyType", "4");
        System.setProperty("http.proxyPort", port);
        System.setProperty("http.proxyHost", host);
        System.setProperty("http.proxySet", "true");
    }
}
