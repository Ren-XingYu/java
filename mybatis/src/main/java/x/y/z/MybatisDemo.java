package x.y.z;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import x.y.z.dao.UserDao;
import x.y.z.model.po.UserPo;

import java.io.InputStream;
import java.util.List;

public class MybatisDemo {
    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 配置文件方式
        List<UserPo> userPos = sqlSession.selectList("user.selectAll");
        System.out.println(userPos);

        // mapper代理方式
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<UserPo> users = userDao.selectAll();
        System.out.println(users);

        sqlSession.close();
    }
}
