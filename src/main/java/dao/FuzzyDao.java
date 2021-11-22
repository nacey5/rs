package dao;

import org.apache.ibatis.annotations.Param;
import pojo.bean.ActivityUser;
import pojo.bean.Organizer;

import java.util.List;

/**
 * @author DAHUANG
 * @date 2021/11/22
 * 进行一系列模糊查询的方法
 */
public interface FuzzyDao {
    /**
     * 根据组织名称查询组织对象-----(模糊查询)
     *
     * @param name 组织名
     * @return 返回名称中含有name的组织
     */
    List<Organizer> queryOrgsByName(@Param("name") String name);
    /**
     * 模糊查询组织
     *
     * @param name
     * @return
     */
    List<Organizer> getOrgSearch(@Param("nameSer") String name);
    /**
     * 模糊查询活动
     *
     * @param name
     * @return
     */
    List<ActivityUser> getActSearch(@Param("nameSer") String name);
    /**
     * 模糊查找用户的名字
     * @param keyWord
     * @return
     */
    List<String> selectUserName(@Param("keyWord") String keyWord);

    /**
     * 模糊查找活动的名字
     * @param keyWord
     * @return
     */
    List<String> selectActName(@Param("keyWord") String keyWord);

    /**
     * 模糊查找组织的名字
     * @param keyWord
     * @return
     */
    List<String> selectOrgName(@Param("keyWord") String keyWord);
}
