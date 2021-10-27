import common.utils.SqlUtil;
import dao.ActivityDao;
import dao.OrganizatorDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
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
            ActivityDao mapper = openSession.getMapper(ActivityDao.class);
//            ActivityUser activityUser = mapper.selectInfoById(8);
            mapper.addActivityPicture(0,"666666666666666");
            System.out.println(mapper.selectPicturesById(1));
        }finally {
            openSession.close();
        }
    }
}
