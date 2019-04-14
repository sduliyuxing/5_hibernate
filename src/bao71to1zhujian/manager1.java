package bao71to1zhujian;

/**
 * @Title manager1
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\9\29 0029 16:10
 */
public class manager1 {
    private Integer mid;
    private String mname;
    private department1 d;

    @Override
    public String toString() {
        return "manager1{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                ", d=" + d +
                '}';
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public department1 getD() {
        return d;
    }

    public void setD(department1 d) {
        this.d = d;
    }
}
