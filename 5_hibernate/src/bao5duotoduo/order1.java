package bao5duotoduo;

/**
 * @Title order1
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\9\27 0027 10:42
 */
public class order1 {
    private Integer oid;
    private String oname;
    private bao5duotoduo.customer1 c;

    @Override
    public String toString() {
        return "order1{" +
                "oid=" + oid +
                ", oname='" + oname + '\'' +
                ", c=" + c +
                '}';
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public customer1 getC() {
        return c;
    }

    public void setC(customer1 c) {
        this.c = c;
    }
}
