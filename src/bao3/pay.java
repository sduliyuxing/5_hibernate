package bao3;

/**
 * @Title pay
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\9\26 0026 9:53
 */
public class pay {
    private Integer year;
    private Integer month;
    private Integer day;
    private  worker w;

    public worker getW() {
        return w;
    }

    public void setW(worker w) {
        this.w = w;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public pay(Integer month, Integer day) {
        this.month = month;
        this.day = day;
    }

    public pay() {
    }

    @Override
    public String toString() {
        return "pay{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", w=" + w +
                '}';
    }
}
