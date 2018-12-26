package bao4;

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
 * @Create 2018\9\26 0026 19:44
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
    public void test1()
    {
       customer c=new customer();
       c.setCname("a");
       customer c2=new customer();
       c2.setCname("b");
       order o1=new order();
       order o2=new order();
       order o3=new order();
       o1.setOname("aaa");
       o2.setOname("bbb");
       o3.setOname("ccc");
       o1.setC(c);
       o2.setC(c);
       o3.setC(c2);
       session.save(c);
       session.save(c2);
       session.save(o1);
       session.save(o2);
       session.save(o3);
    }

    @Test
    public void test2()
    {
        order c= (order) session.get(order.class,1);
        System.out.println(c.getClass());
        System.out.println(c);
    }
}
