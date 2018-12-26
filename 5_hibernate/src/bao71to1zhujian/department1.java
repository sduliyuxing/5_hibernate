package bao71to1zhujian;

/**
 * @Title department1
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\9\29 0029 16:12
 */
public class department1 {
    private Integer did;
    private String dname;
    private manager1 m;

    @Override
    public String toString() {
        return "department1{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", m=" + m +
                '}';
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public manager1 getM() {
        return m;
    }

    public void setM(manager1 m) {
        this.m = m;
    }
}
