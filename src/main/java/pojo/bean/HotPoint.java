package pojo.bean;

/**
 * @author DAHUANG
 * @date 16/11/2021
 */
public class HotPoint {

    private static final long serialVersionUID=116045421456785644L;
    Integer id;
    Integer hotPoint;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHotPoint() {
        return hotPoint;
    }

    public void setHotPoint(Integer hotPoint) {
        this.hotPoint = hotPoint;
    }

    @Override
    public String toString() {
        return "HotPoint{" +
                "id=" + id +
                ", hotPoint=" + hotPoint +
                '}';
    }


}
