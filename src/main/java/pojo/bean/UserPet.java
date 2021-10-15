package pojo.bean;

import org.apache.ibatis.type.Alias;

/**
 * @author DAHUANG
 * @description 昵称
 * @date 9/10/2021 22:45
 */
@Alias("pet")
public class UserPet {

    int id;
    String name;

    public UserPet() {
    }

    public UserPet(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserPet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
