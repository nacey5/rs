package dao;

import pojo.bean.User;
import pojo.bean.User_pet;
import org.apache.ibatis.annotations.Param;

/**
 * @author WEIR
 * @description
 * @date 8/10/2021 - 15:37
 */
public interface UserDao {
    public User SelectInfoByPhone(@Param("phone") String phone, @Param("password") String password);
    public void addUser( User user);
    public void addPetName(@Param("id") int id,@Param("petName") String pet_name);
    public User_pet selectPetNameById(@Param("id") Integer id);
    public User SelectInfoById(@Param("id")Integer id);
}
