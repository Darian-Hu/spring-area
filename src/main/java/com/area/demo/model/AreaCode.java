package com.area.demo.model;

public class AreaCode {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 区划代码
     */
    private Long code;

    /**
     * 区划名称
     */
    private String name;

    /**
     * 上级行政区划ID
     */
    private Long parentId;

    /**
     * 所属省份的行政区划ID
     */
    private Long provinceId;

    /**
     * 所属城市的行政区划ID
     */
    private Long cityId;

    /**
     * 所属县区级行政区划ID
     */
    private Long countyId;

    /**
     * 所属乡镇级行政区划ID
     */
    private Long townId;

    /**
     * 所属村社区级行政区划ID
     */
    private Long villageId;

    /**
     * 完整限定的区划名称
     */
    private String fullName;

    /**
     * 当前行政区划级别（省：1，市：2，县区：3，乡镇：4，村：5）
     */
    private Integer areaLevel;

    /**
     * 数据来源
     */
    private String dataUrl;

    /**
     * 邮编
     */
    private String zipCode;

    /**
     * 主键id
     * @return id 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键id
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 区划代码
     * @return code 区划代码
     */
    public Long getCode() {
        return code;
    }

    /**
     * 区划代码
     * @param code 区划代码
     */
    public void setCode(Long code) {
        this.code = code;
    }

    /**
     * 区划名称
     * @return name 区划名称
     */
    public String getName() {
        return name;
    }

    /**
     * 区划名称
     * @param name 区划名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 上级行政区划ID
     * @return parent_id 上级行政区划ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 上级行政区划ID
     * @param parentId 上级行政区划ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 所属省份的行政区划ID
     * @return province_id 所属省份的行政区划ID
     */
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * 所属省份的行政区划ID
     * @param provinceId 所属省份的行政区划ID
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * 所属城市的行政区划ID
     * @return city_id 所属城市的行政区划ID
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * 所属城市的行政区划ID
     * @param cityId 所属城市的行政区划ID
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * 所属县区级行政区划ID
     * @return county_id 所属县区级行政区划ID
     */
    public Long getCountyId() {
        return countyId;
    }

    /**
     * 所属县区级行政区划ID
     * @param countyId 所属县区级行政区划ID
     */
    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    /**
     * 所属乡镇级行政区划ID
     * @return town_id 所属乡镇级行政区划ID
     */
    public Long getTownId() {
        return townId;
    }

    /**
     * 所属乡镇级行政区划ID
     * @param townId 所属乡镇级行政区划ID
     */
    public void setTownId(Long townId) {
        this.townId = townId;
    }

    /**
     * 所属村社区级行政区划ID
     * @return village_id 所属村社区级行政区划ID
     */
    public Long getVillageId() {
        return villageId;
    }

    /**
     * 所属村社区级行政区划ID
     * @param villageId 所属村社区级行政区划ID
     */
    public void setVillageId(Long villageId) {
        this.villageId = villageId;
    }

    /**
     * 完整限定的区划名称
     * @return full_name 完整限定的区划名称
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 完整限定的区划名称
     * @param fullName 完整限定的区划名称
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * 当前行政区划级别（省：1，市：2，县区：3，乡镇：4，村：5）
     * @return area_level 当前行政区划级别（省：1，市：2，县区：3，乡镇：4，村：5）
     */
    public Integer getAreaLevel() {
        return areaLevel;
    }

    /**
     * 当前行政区划级别（省：1，市：2，县区：3，乡镇：4，村：5）
     * @param areaLevel 当前行政区划级别（省：1，市：2，县区：3，乡镇：4，村：5）
     */
    public void setAreaLevel(Integer areaLevel) {
        this.areaLevel = areaLevel;
    }

    /**
     * 数据来源
     * @return data_url 数据来源
     */
    public String getDataUrl() {
        return dataUrl;
    }

    /**
     * 数据来源
     * @param dataUrl 数据来源
     */
    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

    /**
     * 邮编
     * @return zip_code 邮编
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 邮编
     * @param zipCode 邮编
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AreaCode other = (AreaCode) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getProvinceId() == null ? other.getProvinceId() == null : this.getProvinceId().equals(other.getProvinceId()))
            && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.getCountyId() == null ? other.getCountyId() == null : this.getCountyId().equals(other.getCountyId()))
            && (this.getTownId() == null ? other.getTownId() == null : this.getTownId().equals(other.getTownId()))
            && (this.getVillageId() == null ? other.getVillageId() == null : this.getVillageId().equals(other.getVillageId()))
            && (this.getFullName() == null ? other.getFullName() == null : this.getFullName().equals(other.getFullName()))
            && (this.getAreaLevel() == null ? other.getAreaLevel() == null : this.getAreaLevel().equals(other.getAreaLevel()))
            && (this.getDataUrl() == null ? other.getDataUrl() == null : this.getDataUrl().equals(other.getDataUrl()))
            && (this.getZipCode() == null ? other.getZipCode() == null : this.getZipCode().equals(other.getZipCode()));
    }

    /**
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getProvinceId() == null) ? 0 : getProvinceId().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getCountyId() == null) ? 0 : getCountyId().hashCode());
        result = prime * result + ((getTownId() == null) ? 0 : getTownId().hashCode());
        result = prime * result + ((getVillageId() == null) ? 0 : getVillageId().hashCode());
        result = prime * result + ((getFullName() == null) ? 0 : getFullName().hashCode());
        result = prime * result + ((getAreaLevel() == null) ? 0 : getAreaLevel().hashCode());
        result = prime * result + ((getDataUrl() == null) ? 0 : getDataUrl().hashCode());
        result = prime * result + ((getZipCode() == null) ? 0 : getZipCode().hashCode());
        return result;
    }
}