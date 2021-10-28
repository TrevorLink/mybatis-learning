package com.niao.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * @author HuangSir
 * @create 2021-06-28 17:24
 */

public class IDUtils {
   /**
    * 使用UUID工具类获取随机的用户ID
    * @return
    */
   public  static  String getId(){
      return UUID.randomUUID().toString().replaceAll("-","");
   }
@Test
   public  void test(){
   System.out.println(IDUtils.getId());
}
}
