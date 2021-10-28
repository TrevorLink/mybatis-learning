package com.niao.dao;

import com.niao.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author HuangSir
 * @create 2021-06-28 17:21
 */
public interface BlogMapper {
   /**
    * 添加博客
    * @param blog
    * @return
    */
   int addBlog(Blog blog);

   /**
    * 使用IF动态选择查询博客
    * 如果我传了title，就查询指定标题的博客，如果传了作者，就查指定作者的博客，否则全部查询
    * 虽然也是可以使用方法的重载，但是我这样提升了sql的复用性
    * @param map
    * @return
    */
   List<Blog> queryBlogIf(Map map);

   /**
    * 使用choose动态Sql标签查询博客信息
    * 这里的choose相当于switch-case语句，只要走一个剩下的就不会再走了
    * @param map
    * @return
    */
   List<Blog> queryBlogChoose(Map map);

   /**
    * 使用set标签修改博客的内容
    * @param map
    * @return
    */
   int updateBlog(Map map);

   /**
    * 使用Foreach查询满足用户要提供范围内的博客
    * （这波我们模拟一个业务，查询id=1,2或者是3的博客）
    * @return
    */
   List<Blog> queryBlogForeach(Map map);
}
