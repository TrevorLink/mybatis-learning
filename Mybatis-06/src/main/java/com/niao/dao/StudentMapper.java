package com.niao.dao;

import com.niao.pojo.Student;

import java.util.List;

/**
 * @author HuangSir
 * @create 2021-06-26 9:29
 */
public interface StudentMapper {
//查询所有的学生信息已经学生所对应的老师的信息
   //按照查询嵌套处理
   List<Student> getStudent();
   //按照结果嵌套处理
   List<Student> getStudent2();
}
