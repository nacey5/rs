import common.utils.Md5Util;
import org.apache.commons.beanutils.BeanUtils;
import pojo.bean.UserPet;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WEIR
 * @description
 * @date 9/10/2021 - 16:09
 */
public class Md5UtilTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
//        System.out.println(Md5Util.getMd5String("123456"));

        Map<String,Integer>map=new HashMap<>();
        map.put("id",1);
        map.put("name",2);
        UserPet userPet=new UserPet();
//        BeanUtils.populate(userPet,map);
        BeanUtils.copyProperties(userPet,map);
        System.out.println(userPet);
    }
}
