package pojo.bean;

import org.apache.ibatis.type.Alias;

@Alias("pInfo")
public class PactInfo {
    private Integer id;
    private String name;
    private String num;
    private String phone;
    private String collage;
    private String major;

    public PactInfo(Integer id, String name, String num, String phone, String collage, String major) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.phone = phone;
        this.collage = collage;
        this.major = major;
    }

    public PactInfo() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "PactInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", phone='" + phone + '\'' +
                ", collage='" + collage + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
