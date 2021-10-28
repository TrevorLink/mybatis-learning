package com.niao.dao;

import com.niao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author HuangSir
 * @create 2021-06-26 14:55
 */
public class MyTest {
   @Test
   public  void testTeacher(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      sqlSession.getMapper(TeacherMapper.class).getAllTeachers().forEach(System.out::println);
      sqlSession.close();
   }
      @Test
      public  void testTeacherPro(){
         SqlSession sqlSession = MybatisUtils.getSqlSession();
         System.out.println(sqlSession.getMapper(TeacherMapper.class).getTeacherById(1));
         sqlSession.close();
      }
}
