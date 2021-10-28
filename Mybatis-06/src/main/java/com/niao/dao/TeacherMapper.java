package com.niao.dao;

import com.niao.pojo.Teacher;

/**
 * @author HuangSir
 * @create 2021-06-26 9:29
 */
public interface TeacherMapper {
   /**
    * 根据指定id查找老师
    * @param id
    * @return
    */
   Teacher queryTeacherById(int id);
}
