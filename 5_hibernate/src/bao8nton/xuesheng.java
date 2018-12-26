package bao8nton;

import java.util.HashSet;
import java.util.Set;

/**
 * @Title xuesheng
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\9\29 0029 18:11
 */
public class xuesheng {
    private Integer xueid;
    private String xuename;
    private Set<kecheng> kechengSet=new HashSet<>();

    @Override
    public String toString() {
        return "xuesheng{" +
                "xueid=" + xueid +
                ", xuename='" + xuename + '\'' +
                ", kechengSet=" + kechengSet +
                '}';
    }

    public Integer getXueid() {
        return xueid;
    }

    public void setXueid(Integer xueid) {
        this.xueid = xueid;
    }

    public String getXuename() {
        return xuename;
    }

    public void setXuename(String xuename) {
        this.xuename = xuename;
    }

    public Set<kecheng> getKechengSet() {
        return kechengSet;
    }

    public void setKechengSet(Set<kecheng> kechengSet) {
        this.kechengSet = kechengSet;
    }
}
