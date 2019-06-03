package com.nico.student.bean;

import java.math.BigDecimal;

public class File {

//    private Integer id;
    //1.比如我现在把类型改为了string，接下来改他的set get方法
    private String id;
    private String data;
    private String prefix;
    private BigDecimal price;
    private Integer sale_number;
    private String cdate;
    private String desc;
    private Integer type_id;
    //当前登录用户购买标志（1为购买）
    private Integer billFlag;

    //用来承接课件类别名称
    private String name;

    //预览图数量
    private Integer imageNum;
    //图片地址（传递向前台）
    private String imagePath;

    //2.改他的set get方法，然后去相应的mapper.xml文件看哪些有用到这个id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSale_number() {
        return sale_number;
    }

    public void setSale_number(Integer sale_number) {
        this.sale_number = sale_number;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public Integer getBillFlag() {
        return billFlag;
    }

    public void setBillFlag(Integer billFlag) {
        this.billFlag = billFlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImageNum() {
        return imageNum;
    }

    public void setImageNum(Integer imageNum) {
        this.imageNum = imageNum;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", prefix='" + prefix + '\'' +
                ", price=" + price +
                ", sale_number=" + sale_number +
                ", cdate='" + cdate + '\'' +
                ", desc='" + desc + '\'' +
                ", type_id=" + type_id +
                ", billFlag=" + billFlag +
                ", name='" + name + '\'' +
                ", imageNum=" + imageNum +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
