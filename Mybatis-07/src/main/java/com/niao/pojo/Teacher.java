package com.niao.pojo;


import lombok.Data;

import java.util.List;

/**
 * @author HuangSir
 * @create 2021-06-25 21:46
 */
@Data
public class Teacher {
   private int id;
   private String name;
   //一个老师底下带着很多个学生
   private List<Student> students;
}
