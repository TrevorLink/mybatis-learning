package com.niao.dao;

import com.niao.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HuangSir
 * @create 2021-06-26 9:29
 */
public interface TeacherMapper {
   /**
    * 获取所有的老师
    * @return
    */
   List<Teacher> getAllTeachers();

   /**
    * 根据指定id查询老师以及他下面的所有学生
    * @return
    */
   //注意这里的注解很关键，就是我方法参数传给mapper.xml的名称
   Teacher getTeacherById(@Param("tid") int id);
}
