package pojo.bean;
import org.apache.ibatis.type.Alias;

@Alias("user")
public class User {
    String username;
    Integer id;
    Integer count;
    String major;
    String gender;
    String password;
    String phone;
    String email;
    String collage;
    User_pet pet;

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

    public User_pet getPet() {
        return pet;
    }

    public void setPet(User_pet pet) {
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
}

