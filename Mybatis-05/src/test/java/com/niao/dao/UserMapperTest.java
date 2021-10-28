package com.niao.dao;

import com.niao.pojo.User;
import com.niao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author HuangSir
 * @create 2021-06-24 19:55
 */
public class UserMapperTest {
   @Test
   public  void testQueryUsers(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      List<User> users = mapper.queryAllUsers();
      users.forEach(System.out::println);
      sqlSession.close();
   }
   @Test
   public  void testQueryUserById(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      User user = mapper.queryUserById(1);
      System.out.println(user);
      sqlSession.close();
   }
   @Test
   public  void  testAddUser(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      mapper.addUser(new User(5,"彬彬","544588"));
      sqlSession.close();
   }
   @Test
   public  void  testUpdateUser(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      mapper.updateUser(new User(5,"彬彬pro","544588"));
      sqlSession.close();
   }
   @Test
   public void  testDeleteUser(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      mapper.deleteUser(5);
      sqlSession.close();
   }
}
