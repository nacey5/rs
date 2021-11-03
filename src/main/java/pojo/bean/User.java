package pojo.bean;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author DAHUANG
 * @description 用户
 * @date 7/10/2021 18:45
 */
@Alias("user")
public class User implements Serializable {
    private static final long serialVersionUID=8452144756218456L;
    public static final String BASE_NAME="findmore";
    //用户名
    String username;
    //用户id
    Integer id;
    //用户学号
    Integer count;
    //用户专业
    String major;
    //用户性别
    String gender;
    //用户密码
    String password;
    //用户手机电话
    String phone;
    //用户邮箱
    String email;
    //用户学院
    String collage;
    //用户昵称类
    UserPet pet;
    //参赛信息
    Participater pars;
    //头像
    String headPortrait;
    Integer level;

    /**
     * 注册所用的构造方法
     * @param count
     * @param password
     * @param phone
     */
    public User(Integer count, String password, String phone ){
        this.count = count;
        this.password = password;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", count=" + count +
                ", major='" + major + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", collage='" + collage + '\'' +
                ", pet=" + pet +
                ", pars=" + pars +
                ", headPortrait='" + headPortrait + '\'' +
                ", level=" + level +
                '}';
    }

    public User() {
    }

    public User(String username, Integer count, String major, String gender, String password, String phone, String email, String collage) {
        this.username = username;
        this.count = count;
        this.major = major;
        this.gender = gender;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.collage = collage;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public UserPet getPet() {
        return pet;
    }

    public void setPet(UserPet pet) {
        this.pet = pet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public Participater getPars() {
        return pars;
    }

    public void setPars(Participater pars) {
        this.pars = pars;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }
}

