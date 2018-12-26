package bao5duotoduo;

import bao5duotoduo.order1;

import java.util.HashSet;
import java.util.Set;

/**
 * @Title customer1
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\9\27 0027 10:41
 */
public class customer1 {
    private Integer cid;
    private String cname;
    private Set<order1> orders=new HashSet<>();

    @Override
    public String toString() {
        return "customer1{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", orders=" + orders +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Set<order1> getOrders() {
        return orders;
    }

    public void setOrders(Set<order1> orders) {
        this.orders = orders;
    }
}
