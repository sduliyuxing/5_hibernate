package bao1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

/**
 * @Title junit
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\9\25 0025 15:16
 */
public class junit {

    @Test
    public void test()
    {
        System.out.println("test...");

        //1. 创建一个 SessionFactory 对象
        SessionFactory sessionFactory=null;

        //1). 创建 Configuration 对象: 对应 hibernate 的基本配置信息和 对象关系映射信息
        Configuration configuration=new Configuration().configure();

        // 创建一个 ServiceRegistry 对象,hibernate 的任何配置和服务都需要在该对象中注册后才能有效.
        ServiceRegistry serviceRegistry=new ServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).buildServiceRegistry();

        sessionFactory=configuration.buildSessionFactory(serviceRegistry);

        Session session=sessionFactory.openSession();
        //创建事务
        Transaction transaction=session.beginTransaction();

        news1 n= (news1) session.get(news1.class,1);
        System.out.println(n);
        //保存
        session.save(n);
        //提交事务
        transaction.commit();

        session.close();
        sessionFactory.close();
    }

}
