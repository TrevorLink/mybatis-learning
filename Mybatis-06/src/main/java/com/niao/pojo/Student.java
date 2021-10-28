package com.niao.pojo;

/**
 * @author HuangSir
 * @create 2021-06-25 21:46
 */
public class Student {
   private int id;
   private String name;
   //数据库中表的外键对应一个老师的引用
   private Teacher teacher;
   public Student() {
   }

   public Student(int id, String name, Teacher teacher) {
      this.id = id;
      this.name = name;
      this.teacher = teacher;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Teacher getTeacher() {
      return teacher;
   }

   public void setTeacher(Teacher teacher) {
      this.teacher = teacher;
   }

   @Override
   public String toString() {
      return "Student{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", teacher=" + teacher +
              '}';
   }
}
