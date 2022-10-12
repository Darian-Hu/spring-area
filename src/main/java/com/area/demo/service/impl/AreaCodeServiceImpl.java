package com.area.demo.service.impl;

import cn.hutool.http.HttpUtil;
import com.area.demo.dao.AreaCodeMapper;
import com.area.demo.model.AreaCode;
import com.area.demo.model.AreaNode;
import com.area.demo.service.AreaCodeService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.*;

@Service
public class AreaCodeServiceImpl implements AreaCodeService {

    @Autowired
    AreaCodeMapper areaCodeMapper;

    // 网页地址
    private static final String baseUrl = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2018/";

    // 编码格式
    private static final Charset charSet = Charset.forName("GB2312");


    @Override
    public void getAreaCode() {
        this.getProvice();
    }

    @Override
    public void insertAreaCode(AreaCode areaCode) {
        areaCodeMapper.insertSelective(areaCode);
    }

    /**
     * 获取省级数据
     * @author kai.hu
     * @date 2019/12/3
     */
    private void getProvice() {
        String htmlStr = HttpUtil.get(baseUrl, charSet);
        Document document = Jsoup.parse(htmlStr);

        // 获取 class='provincetr' 元素
        Elements elements = document.getElementsByClass("provincetr");
        for (Element element : elements) {
            // 获取 elements 下的 href 元素
            Elements links = element.getElementsByAttribute("href");
            for (Element link : links) {
                String provinceName = link.text();
                String href = link.attr("href");
                String provinceCode = href.substring(0, 2) + "0000000000";

                if (provinceCode.equals("360000000000")) {// 北京
                    AreaCode areaCode = new AreaCode();
                    areaCode.setCode(Long.parseLong(provinceCode));
                    areaCode.setName(provinceName);
                    areaCode.setParentId(0L);
                    areaCode.setProvinceId(Long.parseLong(provinceCode));
                    areaCode.setFullName(provinceName);
                    areaCode.setAreaLevel(1);
                    areaCode.setDataUrl(baseUrl);
                    // 获取市级数据
                    getCity(baseUrl + href, areaCode);
                }
            }
        }
    }

    /**
     * 获取市级数据
     * @author kai.hu
     * @date 2019/12/3
     */
    private void getCity(String url, AreaCode provinceCode) {
        // 省级数据存入数据库
        areaCodeMapper.insertSelective(provinceCode);

        String htmlStr = HttpUtil.get(url, charSet);
        Document document = Jsoup.parse(htmlStr);
        Elements trs = document.getElementsByClass("citytr");
        for (Element tr : trs) {
            Elements links = tr.getElementsByTag("a");
            String href = links.get(0).attr("href");
            String cityCode = links.get(0).text().substring(0, 4) + "00000000";
            String cityName = links.get(1).text();

            AreaCode areaCode = new AreaCode();
            areaCode.setCode(Long.parseLong(cityCode));
            areaCode.setName(cityName);
            areaCode.setParentId(provinceCode.getCode());
            areaCode.setProvinceId(provinceCode.getProvinceId());
            areaCode.setCityId(Long.parseLong(cityCode));
            areaCode.setFullName(provinceCode.getFullName() + " " + cityName);
            areaCode.setAreaLevel(2);
            areaCode.setDataUrl(url);
            // 获取县区级数据
            getCounty(baseUrl + href, areaCode);
        }
    }

    /**
     * 获取县区级数据
     * @author kai.hu
     * @date 2019/12/3
     */
    private void getCounty(String url, AreaCode cityCode) {
        // 市级数据存入数据库
        areaCodeMapper.insertSelective(cityCode);

        String htmlStr = HttpUtil.get(url, charSet);
        Document document = Jsoup.parse(htmlStr);
        Elements trs = document.getElementsByClass("countytr");
        List<AreaNode> countyList = new LinkedList<>();
        for (Element tr : trs) {
            Elements links = tr.getElementsByTag("a");
            if (links == null || links.size() != 2) {
                continue;
            }
            String href = links.get(0).attr("href");
            String countyCode = links.get(0).text().substring(0, 6) + "000000";
            String countyName = links.get(1).text();

            AreaCode areaCode = new AreaCode();
            areaCode.setCode(Long.parseLong(countyCode));
            areaCode.setName(countyName);
            areaCode.setParentId(cityCode.getCode());
            areaCode.setProvinceId(cityCode.getProvinceId());
            areaCode.setCityId(cityCode.getCityId());
            areaCode.setCountyId(Long.parseLong(countyCode));
            areaCode.setFullName(cityCode.getFullName() + " " + countyName);
            areaCode.setAreaLevel(3);
            areaCode.setDataUrl(url);
            // 获取乡镇级数据
            getTown(baseUrl + href.subSequence(2, 5).toString() + "/" + href, areaCode);
        }
    }

    /**
     * 获取乡镇级数据
     * @author kai.hu
     * @date 2019/12/3
     */
    private void getTown(String url, AreaCode countyCode) {
        // 县区级数据存入数据库
        areaCodeMapper.insertSelective(countyCode);

        String htmlStr = HttpUtil.get(url, charSet);
        Document document = Jsoup.parse(htmlStr);
        Elements trs = document.getElementsByClass("towntr");

        List<AreaNode> townList = new LinkedList<>();
        for (Element tr : trs) {
            Elements links = tr.getElementsByTag("a");
            if (links == null || links.size() != 2) {
                continue;
            }
            String href = links.get(0).attr("href");
            String townCode = links.get(0).text().substring(0, 9) + "000";
            String townName = links.get(1).text();

            AreaCode areaCode = new AreaCode();
            areaCode.setCode(Long.parseLong(townCode));
            areaCode.setName(townName);
            areaCode.setParentId(countyCode.getCode());
            areaCode.setProvinceId(countyCode.getProvinceId());
            areaCode.setCityId(countyCode.getCityId());
            areaCode.setCountyId(countyCode.getCountyId());
            areaCode.setTownId(Long.parseLong(townCode));
            areaCode.setFullName(countyCode.getFullName() + " " + townName);
            areaCode.setAreaLevel(4);
            areaCode.setDataUrl(url);
            // 获取村社区级数据
            getVillage(baseUrl + href.subSequence(2, 5).toString() + "/" + href.substring(5, 7) + "/" + href, areaCode);
        }
    }

    /**
     * 获取村社区级数据
     * @author kai.hu
     * @date 2019/12/3
     */
    private void getVillage(String url, AreaCode townCode) {
        // 乡镇级数据存入数据库
        areaCodeMapper.insertSelective(townCode);

        String htmlStr = HttpUtil.get(url, charSet);
        Document document = Jsoup.parse(htmlStr);
        Elements trs = document.getElementsByClass("villagetr");

        List<AreaNode> villageList = new LinkedList<>();
        for (Element tr : trs) {
            Elements tds = tr.getElementsByTag("td");
            if (tds == null || tds.size() != 3) {
                continue;
            }
            String villageCode = tds.get(0).text();
            String villageName = tds.get(2).text();

            AreaCode areaCode = new AreaCode();
            areaCode.setCode(Long.parseLong(villageCode));
            areaCode.setName(villageName);
            areaCode.setParentId(townCode.getCode());
            areaCode.setProvinceId(townCode.getProvinceId());
            areaCode.setCityId(townCode.getCityId());
            areaCode.setCountyId(townCode.getCountyId());
            areaCode.setTownId(townCode.getTownId());
            areaCode.setVillageId(Long.parseLong(villageCode));
            areaCode.setFullName(townCode.getFullName() + " " + villageName);
            areaCode.setAreaLevel(5);
            areaCode.setDataUrl(url);
            // 村社区级数据存入数据库
            areaCodeMapper.insertSelective(areaCode);
        }
    }
}
