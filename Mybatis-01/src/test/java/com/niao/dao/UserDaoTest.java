package com.niao.dao;

import com.niao.pojo.User;
import com.niao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HuangSir
 * @create 2021-06-22 10:37
 */
public class UserDaoTest {
   @Test
   public  void testGetUserList(){
      //1.使用工具类获取SQLSession对象
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      //2.要想执行sql就要获取Dao的Mapper（实现类），这后面其实是多态
      //而Mapper和Dao都有这个查询数据库方法，Mapper重写了，面向接口编程，我们只需要拿到接口就行了，使用接口GetMapper
      //方式一：getMapper
      UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
      List<User> userList = userMapper.getUserList();
      for (User user : userList) {
         System.out.println(user);
      }
      //关闭SqlSession
      sqlSession.close();
   }
   @Test
   public  void   testGetUserLike(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      List<User> userLike = mapper.getUserLike("%杰%");
      for (User user : userLike) {
         System.out.println(user);
      }
      sqlSession.close();
   }
   @Test
   public  void  testQueryUserById(){
      //使用工具类获取SqlSession
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      //调用底层反射的getMapper方法，拿着接口得到以往的实现类（多态形式）
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      //调用实现类的方法
      User user = mapper.queryUserById(1);
      System.out.println(user);
      //记得一定要关SqlSession
      sqlSession.close();
   }
   @Test
   public  void testQueryUserByIdWithMap(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      //我们这里自己创建了一个HashMap
      Map<String,Object> map= new HashMap<>();
      //Map中存放的key要是和Mapper文件里一样的
      //但是和对象不同的地方在于，用对象sql语句需要一一对应属性，而map的键是可以自己定义的
      map.put("mapId",1);
      User user = mapper.queryUserByIdWithMap(map);
      System.out.println(user);
      sqlSession.close();
   }
   @Test
   //增删改需要提交事务！！
   public  void testAddUser(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      int num = mapper.addUser(new User(4, "杰弟", "123456"));
      if (num>0){
         System.out.println("添加用户成功！");
         //增删改操作必须要提交事务！不然就卡捉了
         sqlSession.commit();
      }
      sqlSession.close();
   }
   @Test
   public  void testUpdateUser(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      int num = mapper.updateUser(new User(4, "彬彬", "123456"));
      if(num>0){
         System.out.println("修改成功");
         //增删改记得一定要提交事务
         sqlSession.commit();
      }
      sqlSession.close();
   }
   @Test
   public  void testDeleteUser(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      int num = mapper.deleteUser(4);
      if(num>0){
         System.out.println("删除成功!");
         //增删改记得一定要提交事务！
         sqlSession.commit();
      }
      sqlSession.close();
   }
}
