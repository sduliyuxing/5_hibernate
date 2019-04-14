package bao9;

/**
 * @Title people
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\10\9 0009 17:45
 */
public class people {
    private Integer pid;
    private String pname;
    private school s;

    @Override
    public String toString() {
        return "people{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", s=" + s +
                '}';
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public school getS() {
        return s;
    }

    public void setS(school s) {
        this.s = s;
    }
}
