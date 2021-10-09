package pojo.bean;

import org.apache.ibatis.type.Alias;

/**
 * @author DAHUANG
 */
@Alias("pet")
public class UserPet {

    int id;
    String name;

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
        return "User_pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
