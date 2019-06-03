package com.nico.student.bean;

import java.math.BigDecimal;

public class Bill {

    private Integer id;
    private Integer sid;
    private Integer fid;
    private String fileName;
    private String cdate;
    private BigDecimal price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", sid=" + sid +
                ", fid=" + fid +
                ", fileName='" + fileName + '\'' +
                ", cdate='" + cdate + '\'' +
                ", price=" + price +
                '}';
    }

}
