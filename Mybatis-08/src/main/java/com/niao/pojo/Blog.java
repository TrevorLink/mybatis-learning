package com.niao.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author HuangSir
 * @create 2021-06-27 11:33
 */
@Data
public class Blog {
   private  String id;
   private  String title;
   private  String author;
   //一般用date类使用util下的而不是sql下的
   //这里属性名和字段名又不一致了
   private Date createTime;
   private  int views;
}
