package pojo.bean;

import org.apache.ibatis.type.Alias;

@Alias("pet")
public class User_pet {

    int id;
    String name;

    public User_pet(String name) {
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
