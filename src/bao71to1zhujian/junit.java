package bao71to1zhujian;

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
 * @Create 2018\9\29 0029 17:05
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
       manager1 m=new manager1();
       m.setMname("a");
       department1 d=new department1();
       d.setDname("x");
       d.setM(m);
       m.setD(d);
       session.save(d);
       session.save(m);
    }

    @Test
    public void testget(){
        department1 d= (department1) session.get(department1.class,1);
        System.out.println(d.getDname());
        System.out.println(d.getM().getMname());
    }

    @Test
    public void testGetDepartment() {
        department1 d = (department1) session.get(department1.class, 1);
        System.out.println(d.getDname());
    }
}
