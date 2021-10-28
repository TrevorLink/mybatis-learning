package com.niao.pojo;

import lombok.Data;

/**
 * @author HuangSir
 * @create 2021-06-25 21:46
 */
@Data
public class Student {
   private int id;
   private String name;
   //每个学生都有其对应的唯一一个老师
   private int tid;
}
