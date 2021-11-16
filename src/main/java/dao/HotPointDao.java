package dao;

import org.apache.ibatis.annotations.Param;
import pojo.bean.ActivityUser;

import java.util.List;

/**
 * 有关活动点击量的操作方法
 * @author DAHUANG
 * @date 16/11/2021
 */
public interface HotPointDao {
    /**
     * 获得活动的点击量
     * @param id
     * @return
     */
    Integer getHotPoint(@Param("id") Integer id);

    /**
     * 更新活动的点击量+1
     * @param id
     */
    void updateHotPoint(@Param("id") Integer id);

    /**
     * 获得点击量最高的活动
     * @return
     */
    ActivityUser getHeightHotPoint();

    /**
     * 获得点击量最前10的活动
     * @return
     */
    List<ActivityUser> getHotPointAscTen();
}
