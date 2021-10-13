package pojo.bean;

import org.apache.ibatis.type.Alias;

/**
 * @author DAHUANG
 * @description 图片
 * @date 11/10/2021 20:05
 */
@Alias("pic")
public class Pictures {
    Integer id;
    String picture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Pictures{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                '}';
    }
}
