package bao8nton;

import java.util.HashSet;
import java.util.Set;

/**
 * @Title kecheng
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\9\29 0029 18:10
 */
public class kecheng {
    private Integer keid;
    private String kename;
    private Set<xuesheng> xueshengSet=new HashSet<>();

    public Integer getKeid() {
        return keid;
    }

    public void setKeid(Integer keid) {
        this.keid = keid;
    }

    public String getKename() {
        return kename;
    }

    public void setKename(String kename) {
        this.kename = kename;
    }

    public Set<xuesheng> getXueshengSet() {
        return xueshengSet;
    }

    public void setXueshengSet(Set<xuesheng> xueshengSet) {
        this.xueshengSet = xueshengSet;
    }

    @Override
    public String toString() {
        return "kecheng{" +
                "keid=" + keid +
                ", kename='" + kename + '\'' +
                ", xueshengSet=" + xueshengSet +
                '}';
    }
}
