package com.nico.student.bean;

import java.math.BigDecimal;

public class Recharge {

    private Integer id;
    private BigDecimal price;
    private Integer sid;
    private String cdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    @Override
    public String toString() {
        return "Recharge{" +
                "id=" + id +
                ", price=" + price +
                ", sid=" + sid +
                ", cdate='" + cdate + '\'' +
                '}';
    }
}
