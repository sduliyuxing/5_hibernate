package bao8nton;

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
 * @Create 2018\9\29 0029 18:32
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
    public void testsave() {
        kecheng kecheng1=new kecheng();
        kecheng1.setKename("music");
        kecheng kecheng2=new kecheng();
        kecheng2.setKename("english");
        xuesheng xuesheng1=new xuesheng();
        xuesheng1.setXuename("ccc");
        xuesheng xuesheng2=new xuesheng();
        xuesheng2.setXuename("ddd");

        xuesheng1.getKechengSet().add(kecheng1);
        xuesheng1.getKechengSet().add(kecheng2);
        xuesheng2.getKechengSet().add(kecheng1);
        xuesheng2.getKechengSet().add(kecheng2);
        kecheng1.getXueshengSet().add(xuesheng1);
        kecheng1.getXueshengSet().add(xuesheng2);
        kecheng2.getXueshengSet().add(xuesheng1);
        kecheng2.getXueshengSet().add(xuesheng2);
        session.save(xuesheng1);
        session.save(xuesheng2);
        session.save(kecheng1);
        session.save(kecheng2);
    }
}
