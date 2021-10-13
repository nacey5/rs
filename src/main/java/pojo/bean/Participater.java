package pojo.bean;

import org.apache.ibatis.type.Alias;

/**
 * @author DAHUANG
 * @description 参赛者
 * @date 05/10/2021 13:07
 */
@Alias("participater")
public class Participater {
    Integer id;
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
