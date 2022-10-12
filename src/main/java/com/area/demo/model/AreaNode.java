package com.area.demo.model;

import java.util.List;

/**
 * 区划节点
 * @author kai.hu
 * @date 2019/12/3
 */
public class AreaNode {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDataFromUrl() {
        return dataFromUrl;
    }

    public void setDataFromUrl(String dataFromUrl) {
        this.dataFromUrl = dataFromUrl;
    }

    public List<AreaNode> getAreaNodes() {
        return AreaNodes;
    }

    public void setAreaNodes(List<AreaNode> areaNodes) {
        AreaNodes = areaNodes;
    }

    // 区划名称
    private String name;

    // 区划代码
    private String code;

    // 数据来源
    private String dataFromUrl;

    // 子节点
    private List<AreaNode> AreaNodes;
}
