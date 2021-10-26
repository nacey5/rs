package pojo.bean;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("org")
public class Organizer implements Serializable {
    private static final long serialVersionUID=54564123124215468L;
    Integer id;
    String name;
    Integer level;
    //管理者学号
    Integer mangerCount;
    String phone;
    String password;
    String collage;
    //头像
    String headPortrait;

    String info;

    public Organizer(String name, Integer level, Integer mangerCount, String phone, String password, String collage, String headPortrait, String info) {
        this.name = name;
        this.level = level;
        this.mangerCount = mangerCount;
        this.phone = phone;
        this.password = password;
        this.collage = collage;
        this.headPortrait = headPortrait;
        this.info = info;
    }

    public Organizer() {
    }



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getMangerCount() {
        return mangerCount;
    }

    public void setMangerCount(Integer mangerCount) {
        this.mangerCount = mangerCount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        headPortrait = headPortrait;
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", mangerCount=" + mangerCount +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", collage='" + collage + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", info='" + info + '\'' +
                '}';
    }


}
