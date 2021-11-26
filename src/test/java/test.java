import common.utils.SqlUtil;
import dao.ActivityDao;
import dao.FuzzyDao;
import dao.OrganizatorDao;
import dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import pojo.bean.ActivityUser;
import pojo.bean.PactInfo;
import pojo.bean.User;

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
            ActivityDao mapper = openSession.getMapper(ActivityDao.class);
            mapper.fillInUserInfo(new PactInfo(7,"大黄","201543220","13012344321","互联网金融与信息工程学院","计算机科学与技术"));
            openSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            openSession.close();
        }
    }

    @Test
    public void test4(){
        SqlSession openSession = SqlUtil.getOpeningSession();
        try{
            UserDao mapper = openSession.getMapper(UserDao.class);
            User user=new User("findmore8",26, 201543239, "计算机科学与技术","男","1234", "13010081008","13010081008@phone.cn","互联网金融与信息工程学院" );
            mapper.addInfo(user);
            openSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            openSession.close();
        }
    }
    @Test
    public void test05(){
        SqlSession openSession = SqlUtil.getOpeningSession();
        try{
            UserDao mapper = openSession.getMapper(UserDao.class);
            mapper.participateAct(26,201543219);
            openSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            openSession.close();
        }
    }
}
