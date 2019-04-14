package bao9;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @Title junit
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\10\9 0009 18:02
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
    public void testhql()
    {
        String hql="from people e where e.id>? and e.pname like ?";
        Query query=session.createQuery(hql);
        query.setInteger(0,1)
             .setString(1,"%a%");
        List<people> list=query.list();
        System.out.println(list.size());
        for(people p:list)
        {
            System.out.println(p.getPid()+" "+p.getPname()+" "+p.getS().getSname());
        }
    }

    @Test
    public void testhql2()
    {
        String hql="from people e where e.s=?";
//        String hql="from people e where e.s=:school";
        Query query=session.createQuery(hql);
        school s=new school();
        s.setSid(1);
//        query.setEntity("school",s);
        query.setEntity(0,s);
        List<people> list=query.list();
        for(people p:list)
        {
            System.out.println(p.getPid()+" "+p.getPname());
        }
    }

    @Test
    public void testqbc()
    {
        Criteria criteria=session.createCriteria(people.class);
        criteria.add(Restrictions.like("pname","%a%"));
        people p= (people) criteria.uniqueResult();
        System.out.println(p.getPname());
        List<people> list1=criteria.list();
        for(people p1:list1)
        {
            System.out.println(p.getPid()+" "+p.getPname());
        }
        for(people p1:list1)
        {
            System.out.println(p.getPid()+" "+p.getPname());
        }
    }
}
