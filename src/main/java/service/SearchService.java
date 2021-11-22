package service;

import org.apache.ibatis.annotations.Param;
import pojo.bean.ActivityUser;
import pojo.bean.Organizer;

import java.util.List;

/**
 * @author WEIR
 * @description
 * @date 22/11/2021 - 20:09
 */
public interface SearchService {
    /**
     * 通过活动名称查询活动
     * @param searchText
     * @return
     */
    List<ActivityUser> searchActivityByName(String searchText);
    /**
     * 根据组织名称查询组织对象-----(模糊查询)
     * @param name 组织名
     * @return 返回名称中含有name的组织
     */
    List<Organizer> queryOrgsByName(String name);    /**
     * 模糊查找
     * @param keyWord
     * @return
     */
    List<String> searchByKeyWords(@Param("keyWord") String keyWord);
}
