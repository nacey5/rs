import dao.ActivityDao;
import dao.OragnizatorDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import pojo.bean.ActivityUser;

import java.io.IOException;
import java.io.InputStream;

import static common.utils.SqlUtil.getSqlSessionFactory;


public class test {



    @Test
    public void test1(){
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            OragnizatorDao mapper = openSession.getMapper(OragnizatorDao.class);
            String s = mapper.selectInfo(12);
            System.out.println(s);
        }finally {
            openSession.close();
        }
    }


    @Test
    public void test2(){
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            ActivityDao mapper = openSession.getMapper(ActivityDao.class);
            ActivityUser activityUser = mapper.selectInfoById(8);
            System.out.println(activityUser);
        }finally {
            openSession.close();
        }
    }
}
