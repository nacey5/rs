package common.factory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import static common.utils.SqlUtil.getSqlSessionFactory;

/**
 * @author WEIR
 * @description dao对象工厂
 * @date 19/10/2021 - 00:42
 */
public class DaoFactory {
    /**
     *获取对应的dao对象
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> Object getDao(Class<T> tClass) {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        return openSession.getMapper(tClass);
    }
}
