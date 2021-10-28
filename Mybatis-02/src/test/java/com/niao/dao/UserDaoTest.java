package com.niao.dao;

import com.niao.pojo.User;
import com.niao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author HuangSir
 * @create 2021-06-22 20:30
 */
public class UserDaoTest {
   @Test
   public  void test(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      List<User> userList = mapper.getUserList();
      for (User user : userList) {
         System.out.println(user);
      }
      sqlSession.close();
   }
}
