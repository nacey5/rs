package pojo.bean;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author DAHUANG
 * @description 昵称
 * @date 9/10/2021 22:45
 */
@Alias("pet")
public class UserPet implements Serializable {
    private static final long serialVersionUID=7844154663215456L;
    //昵称id->数据库
    int id;
    //昵称
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
