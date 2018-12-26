package bao4;

/**
 * @Title order1
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\9\26 0026 11:31
 */
public class order {
    private Integer oid;
    private String oname;
    private customer c;

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

    public customer getC() {
        return c;
    }

    public void setC(customer c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "order1{" +
                "oid=" + oid +
                ", oname='" + oname + '\'' +
                ", c=" + c +
                '}';
    }
}
