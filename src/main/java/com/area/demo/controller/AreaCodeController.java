package com.area.demo.controller;

import com.area.demo.model.AreaCode;
import com.area.demo.model.AreaNode;
import com.area.demo.service.AreaCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 区划代码
 * @author kai.hu
 * @date 2019/12/3
 */
@RestController
public class AreaCodeController {

    @Autowired
    AreaCodeService areaCodeService;

    /**
     * 获取全国区划代码
     * @author kai.hu
     * @date 2019/12/3
     */
    public void getAreaCode() {
        areaCodeService.getAreaCode();
    }
}
