import com.wyx.dao.DeptDao;
import com.wyx.op.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.Alias;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 王院祥
 * @create 2020-10-01-9:33
 */

public class Test1 {

    private InputStream is;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private   DeptDao dd;
    @Before
    public void  before() throws IOException {
        //1.加载mybatis 的配置文件
         is= Resources.getResourceAsStream("mybatis-config.xml");
        // 2.创建sqlSessionFactory工厂
         sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        //3.生产sqlSession 数据库会话对象
         sqlSession = sqlSessionFactory.openSession(true);
        dd = sqlSession.getMapper(DeptDao.class);
    }
    @Test
    public void testSelectAll(){
        List<Dept> list = dd.selectAll();
        for (Dept dept : list) {
            System.out.println("dept = " + dept);
        }
    }
    @Test
    public void testSelectOne(){

        Dept dept = dd.selectOnt(2);
        System.out.println("dept = " + dept);

    }
@Test
    public  void testInsert(){
    int i = dd.insert(new Dept("添加部"));
    System.out.println("i = " + i);
}
@Test

    public  void  testUpdate(){
    int update = dd.update(new Dept(7, "修改部"));
    System.out.println("update = " + update);
}
@Test
    public  void  testDelete(){
    int delete = dd.delete(7);
    System.out.println("delete = " + delete);
}
}
