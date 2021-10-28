import com.niao.dao.UserMapper;
import com.niao.pojo.User;
import com.niao.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @author HuangSir
 * @create 2021-06-23 14:54
 */
public class UserTest {
   //通过Logger类的静态方法getLogger创建日志对象，并且参数是当前要使用日志对象的类（反射）
  static Logger LOGGER= Logger.getLogger(UserTest.class);
   private static long CYCLE = 102;
   @Test
   public  void test(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      User user = mapper.queryUserById(1);
      System.out.println(user);
      sqlSession.close();
   }
   @Test
   public void  testLog4j(){
      long startTime = System.currentTimeMillis();

      for(int i=0;i<CYCLE;i++){
         if(i<100){
            try{
               LOGGER.info(new Person("godtrue",100/i,'M'));//打印对象的信息
            }catch(Exception e){
               LOGGER.error(i+"岁的小孩还不存在嘛！");//打印对象的信息
            }finally{
               LOGGER.warn("现在大部分人的年龄都在0到100岁之间的!");//打印对象的信息
            }
         }else{
            LOGGER.info("我是一棵树，我今年活了"+i+"岁!哈哈，我厉害吧！");//打印对象的信息
         }
      }
      LOGGER.debug("此程序的运行时间是："+(System.currentTimeMillis()-startTime));//打印程序运行的时间
   }
   @Test
   public  void testQueryUserByLimit(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      HashMap<String, Integer> map = new HashMap<>();
      map.put("startIndex",0);
      map.put("pageSize",2);
      List<User> users = mapper.queryUserByLimit(map);
      users.forEach(System.out::println);
      sqlSession.close();
   }
   @Test
   public  void testQueryUserByRowBounds(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      //这次我们的重心放在了java代码层面去进行分页而不是sql语句
      RowBounds rowBounds= new RowBounds(1,2);
      //使用官方不推荐的方式进行查询
      List<User> userList = sqlSession.selectList("com.com.niao.dao.UserMapper.queryUserByRowBounds", null, rowBounds);
      userList.forEach(System.out::println);
      sqlSession.close();
   }

}
