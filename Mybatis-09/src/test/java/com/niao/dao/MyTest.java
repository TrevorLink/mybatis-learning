package com.niao.dao;

import com.niao.pojo.User;
import com.niao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author HuangSir
 * @create 2021-06-29 19:59
 */
public class MyTest {
   @Test
   public  void test(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      SqlSession sqlSession1 = MybatisUtils.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      User user = mapper.queryUserById(1);
      System.out.println(user);
      sqlSession.close();
      System.out.println("=================================");
      UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
      User user1 = mapper1.queryUserById(1);
      System.out.println(user1);
      System.out.println(user==user1);
      sqlSession1.close();
   }
}
