package bao5duotoduo ;

import bao5duotoduo.customer1;
import bao5duotoduo.order1;
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
 * @Create 2018\9\27 0027 11:08
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
    public void test()
    {
        customer1 c1=new customer1();
        c1.setCname("aaa");
        order1 o1=new order1();
        o1.setOname("p");
        o1.setC(c1);
        order1 o2=new order1();
        o2.setOname("l");
        o2.setC(c1);
        c1.getOrders().add(o1);
        c1.getOrders().add(o2);
        session.save(c1);
        session.save(o1);
        session.save(o2);
    }

    @Test
    public void testget()
    {
        order1 o= (order1) session.get(order1.class,1);
        System.out.println(o.getClass());
        System.out.println(o.getC().getClass().getName());
    }

    @Test
    public void testupdate()
    {
        order1 order= (order1) session.get(order1.class,1);
        order.getC().setCname("abc");
    }

    @Test
    public void testupdate1()
    {
        customer1 customer= (customer1) session.get(customer1.class,1);
        customer.getOrders().iterator().next().setOname("xyz");
    }

    @Test
    public void testdelete()
    {
        //在不设定级联关系的情况下, 且 1 这一端的对象有 n 的对象在引用, 不能直接删除 1 这一端的对象
        customer1 customer= (customer1) session.get(customer1.class,1);
        session.delete(customer);
    }
}
