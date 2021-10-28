package com.niao.dao;

import com.niao.pojo.Blog;
import com.niao.utils.IDUtils;
import com.niao.utils.MybatisUtils;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

/**
 * @author HuangSir
 * @create 2021-06-28 20:04
 */
public class BlogTest {
   @Test
   public void testAddBlog() {
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

      Blog blog = new Blog();

      blog.setId(IDUtils.getId());
      blog.setTitle("Mybatis好难");
      blog.setAuthor("Niaotendo");
      blog.setCreateTime(new Date());
      blog.setViews(999);
      mapper.addBlog(blog);

      blog.setId(IDUtils.getId());
      blog.setTitle("Spring也好难");
      mapper.addBlog(blog);

      blog.setId(IDUtils.getId());
      blog.setTitle("我的然然带我走吧");
      mapper.addBlog(blog);

      sqlSession.close();
   }

   @Test
   public void testQueryBlogIf() {
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
      Map<String, Object> map = new HashMap<>();
      //Sql语句没有发生变化，只是用户传入的参数发生了变化
//      map.put("title","我的然然带我走吧");
      map.put("author", "Niaotendo");
      List<Blog> blogs = mapper.queryBlogIf(map);
      blogs.forEach(System.out::println);
      sqlSession.close();
   }

   @Test
   public void testQueryChoose() {
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
      Map<String, Object> map = new HashMap<>();
      map.put("title", "Spring也好难");
      map.put("author", "Niaotendo");
      map.put("views", 999);
      mapper.queryBlogChoose(map).forEach(System.out::println);
      sqlSession.close();
   }

   @Test
   public void testUpdateBlog() {
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
      Map<String, Object> map = new HashMap<>();
      map.put("title", "闸瓦好难1");
      map.put("id", "75fa67b662e24471916270afa93afb71");
      mapper.updateBlog(map);
      sqlSession.close();
   }

   @Test
   public void testQueryBlogForeach() {
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
      HashMap<String, Object> map = new HashMap();
      //用户根据他自己想要查什么，在数组ids里面放置即可，我们Sql的代码不用去改动
      ArrayList<Integer> ids = new ArrayList<>();

      ids.add(1);
      ids.add(2);
      map.put("ids", ids);
      mapper.queryBlogForeach(map);
      sqlSession.close();
   }
}
