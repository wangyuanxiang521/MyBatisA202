import com.wyx.dao.DeptDao;
import com.wyx.op.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 王院祥
 * @create 2020-10-01-9:02
 */

public class test {
    @org.junit.Test
    public void test() throws IOException {
        //1.加载mybatis 的配置文件
        InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
        // 2.创建sqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        //3.生产sqlSession 数据库会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        DeptDao dd = sqlSession.getMapper(DeptDao.class);
        List<Dept> list = dd.selectAll();
        for (Dept dept : list) {
            System.out.println("dept = " + dept);
        }
    }
}
