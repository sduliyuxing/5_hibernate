package bao61to1waijian;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Title junit
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\9\29 0029 16:25
 */
public class junit {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init()
    {
        Configuration configuration=new Configuration().configure();
        ServiceRegistry serviceRegistry=new ServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory=configuration.buildSessionFactory(serviceRegistry);
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
    }

    @After
    public void destory()
    {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testsave()
    {
       manager m=new manager();
       m.setMname("b");
       department d=new department();
       d.setDname("y");
       m.setD(d);
       d.setM(m);
       //建议先保存没有外键列的那个对象. 这样会减少 UPDATE 语句
       session.save(m);
       session.save(d);
    }

    @Test
    public void testget()
    {
        department d= (department) session.get(department.class,1);
        System.out.println(d.getDname());
        //在查询没有外键的实体对象时, 使用的左外连接查询, 一并查询出其关联的对象
        System.out.println(d.getM().getMname());
    }
}
