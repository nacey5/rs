package dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author DAHUANG
 * @date 2021/11/22
 * 进行一系列模糊查询的方法
 */
public interface FuzzyDao {
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
