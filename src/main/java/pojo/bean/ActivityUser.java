package pojo.bean;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author DAHUANG
 * @description 活动的基本信息，不包括活动的具体内容
 * @date 8/10/2021 22:13
 */
@Alias("activityUser")
public class ActivityUser implements Serializable {
    private static final long serialVersionUID=116012455255456L;
    Integer id;
    String name;
    /**
     * 学生学号
     */
    Integer organizer;
    String time;
    String adress;
    String joinWay;
    Integer level;
    User user;
    //内容
    String info;
    String status;

    public ActivityUser(String name, Integer organizer, String time, String adress, String joinWay, Integer level) {
        this.name = name;
        this.organizer = organizer;
        this.time = time;
        this.adress = adress;
        this.joinWay = joinWay;
        this.level = level;
    }

    public ActivityUser() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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

    public Integer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Integer organizer) {
        this.organizer = organizer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getJoinWay() {
        return joinWay;
    }

    public void setJoinWay(String joinWay) {
        this.joinWay = joinWay;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ActivityUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", organizer=" + organizer +
                ", time='" + time + '\'' +
                ", adress='" + adress + '\'' +
                ", joinWay='" + joinWay + '\'' +
                ", level=" + level +
                ", user=" + user +
                ", info='" + info + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
