package bao9;

import java.util.HashSet;
import java.util.Set;

/**
 * @Title school
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\10\9 0009 17:44
 */
public class school {
    private Integer sid;
    private String  sname;
    private Set<people> sets=new HashSet<>();

    @Override
    public String toString() {
        return "school{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sets=" + sets +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Set<people> getSets() {
        return sets;
    }

    public void setSets(Set<people> sets) {
        this.sets = sets;
    }
}
