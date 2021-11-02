package pojo.bean;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author DAHUANG
 * @description 活动组织者的活动图片
 * @date 11/10/2021 20:05
 */
@Alias("pic")
public class Pictures implements Serializable {

    private static final long serialVersionUID=11572199855255456L;
    Integer id;
    String picture;

    public Pictures(Integer id, String picture) {
        this.id = id;
        this.picture = picture;
    }

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
