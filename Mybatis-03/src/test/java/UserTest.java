import com.niao.dao.UserMapper;
import com.niao.pojo.User;
import com.niao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author HuangSir
 * @create 2021-06-23 14:54
 */
public class UserTest {
   @Test
   public  void test(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      User user = mapper.queryUserById(1);
      System.out.println(user);
      sqlSession.close();
   }
}
