package com.niao.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * sqlSessionFactory---制造SqlSession
 * @author HuangSir
 * @create 2021-06-21 10:55
 */
public class MybatisUtils {
   private  static  SqlSessionFactory sqlSessionFactory;
   static{
      String resource= "mybatis-config.xml";
      try {
         //获取SqlSessionFactory对象
         InputStream inputStream = Resources.getResourceAsStream(resource);
          sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   /**
    * 有了SqlSessionFactory我们就可以用工厂设计模式造SqlSession
    * SqlSession相当于JDBC的Connection对象
    * @return
    */
   public  static SqlSession  getSqlSession(){
      return  sqlSessionFactory.openSession();
   }
}
