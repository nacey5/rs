import common.utils.SqlUtil;
import dao.ActivityDao;
import dao.FuzzyDao;
import dao.OrganizatorDao;
import dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import pojo.bean.ActivityUser;

import java.util.List;

public class test {
    @Test
    public void test1(){
        SqlSession openSession = SqlUtil.getOpeningSession();
        try{
            OrganizatorDao mapper = openSession.getMapper(OrganizatorDao.class);
            String s = mapper.selectInfo(12);
            System.out.println(s);
        }finally {
            openSession.close();
        }
    }


    @Test
    public void test2(){
        SqlSession openSession = SqlUtil.getOpeningSession();
        try{
            UserDao mapper = openSession.getMapper(UserDao.class);
            List<ActivityUser> activityUsers = mapper.selectActListByUserId(1);
            for (ActivityUser activityUser : activityUsers) {
                System.out.println(activityUser);
            }

        }finally {
            openSession.close();
        }
    }
    @Test
    public void test3(){
        SqlSession openSession = SqlUtil.getOpeningSession();
        try{
            FuzzyDao mapper = openSession.getMapper(FuzzyDao.class);
            List<String> strings = mapper.selectOrgName("协会");
            for (String string : strings) {
                System.out.println(string);
            }
        }finally {
            openSession.close();
        }
    }
}
