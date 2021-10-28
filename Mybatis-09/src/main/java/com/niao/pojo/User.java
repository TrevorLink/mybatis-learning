package com.niao.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author HuangSir
 * @create 2021-06-29 19:46
 */
@Data
public class User implements Serializable {
   private  int id;
   private String name;
   private  String pwd;
}
