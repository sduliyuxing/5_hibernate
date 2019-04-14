package bao3;

/**
 * @Title worker
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\9\26 0026 9:55
 */
public class worker {
    private Integer id;
    private String name;
    private pay p;

    public worker(String name, pay p) {
        this.name = name;
        this.p = p;
    }

    public worker() {

    }

    @Override
    public String toString() {
        return "worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public pay getP() {
        return p;
    }

    public void setP(pay p) {
        this.p = p;
    }
}
