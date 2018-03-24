package com.adeng.mybatis.dao.data;

import com.adeng.mybatis.dao.ContractMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;

import javax.sql.DataSource;

/**
 * 用Java命令使用Mybatis
 *
 * 这种方式注册Mapper，因为没有了XML中的SQL，所以必须在Mapper接口上增加SQL。
 *
 * @Select("select * from t_contract where id = #{id}")
 * Contract selectByPrimaryKey(Integer id);
 *
 * @author
 * @create 2018-03-25 上午1:17
 */
public class UserJavaConfigTest {


    @Test
    public void test() {

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://192.168.160.130:3306/db_gupao?useUnicode=true&amp;characterEncoding=utf-8&amp;useSSL=false&amp;useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC";
        String username = "root";
        String password = "123456";

        DataSource dataSource = new PooledDataSource(driver,url,username,password);

        TransactionFactory transactionFactory = new JdbcTransactionFactory();

        Environment environment = new Environment("development", transactionFactory, dataSource);

        Configuration configuration = new Configuration(environment);

        configuration.addMapper(ContractMapper.class);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        ContractMapper mapper = sqlSession.getMapper(ContractMapper.class);
        System.out.println(   mapper.selectByPrimaryKey(1));

    }
}
