package com.niao.dao;

import com.niao.pojo.Student;
import com.niao.pojo.Teacher;
import com.niao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author HuangSir
 * @create 2021-06-26 9:34
 */
public class MyTest {
   @Test
   public  void testQueryTeacherById(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
      Teacher teacher = mapper.queryTeacherById(1);
      System.out.println(teacher);
      sqlSession.close();
   }
   @Test
   public  void   testStudent(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
      List<Student> studentList = mapper.getStudent();
      studentList.forEach(System.out::println);
      sqlSession.close();
   }
   @Test
   public  void testStudent2(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
      List<Student> studentList = mapper.getStudent2();
      studentList.forEach(System.out::println);
      sqlSession.close();
   }
}
