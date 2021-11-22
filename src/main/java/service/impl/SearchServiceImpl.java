package service.impl;

import common.utils.SqlUtil;
import dao.FuzzyDao;
import org.apache.ibatis.session.SqlSession;
import pojo.bean.ActivityUser;
import pojo.bean.Organizer;
import service.SearchService;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WEIR
 * @description
 * @date 22/11/2021 - 20:10
 */
public class SearchServiceImpl implements SearchService {
    private static SqlSession openSession = SqlUtil.getOpeningSession();
    private static FuzzyDao fuzzyDao= openSession.getMapper(FuzzyDao.class);
    @Override
    public List<String> searchByKeyWords(String keyWord) {
        List<String> acts = fuzzyDao.selectActName(keyWord);
        List<String> orgs = fuzzyDao.selectOrgName(keyWord);
        List<String> users = fuzzyDao.selectUserName(keyWord);
        List<String> strings = new ArrayList<>();
        strings.addAll(orgs);
        strings.addAll(acts);
        strings.addAll(users);
        return strings;
    }

    @Override
    public List<ActivityUser> searchActivityByName(String searchText) {
        return fuzzyDao.getActSearch(searchText);
    }
    @Override
    public List<Organizer> queryOrgsByName(String name) {
        return fuzzyDao.queryOrgsByName(name);
    }
}
