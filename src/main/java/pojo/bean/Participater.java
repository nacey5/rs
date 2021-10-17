package pojo.bean;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author DAHUANG
 * @description 参赛者
 * @date 05/10/2021 13:07
 */
@Alias("participater")
public class Participater implements Serializable {
    private static final long serialVersionUID=15841112455255456L;
    //对应的活动id
    Integer id;
    //学生学号
    Integer studentCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }

    @Override
    public String toString() {
        return "participater{" +
                "id=" + id +
                ", studentCount=" + studentCount +
                '}';
    }


}
