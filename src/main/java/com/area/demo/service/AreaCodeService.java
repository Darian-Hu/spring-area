package com.area.demo.service;

import com.area.demo.model.AreaCode;
import com.area.demo.model.AreaNode;

import java.util.List;

public interface AreaCodeService {

    /**
     * 获取区划代码数据
     * @author kai.hu
     * @date 2019/12/3
     */
    void getAreaCode();

    void insertAreaCode(AreaCode areaCode);
}
