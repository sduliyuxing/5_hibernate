package bao2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;


/**
 * @Title junit
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\9\25 0025 17:58
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
    public void testcache()
    {
        news2 n= (news2) session.get(news2.class,1);
        System.out.println(n);
        news2 n1= (news2) session.get(news2.class,1);
        System.out.println(n1);
    }

    /**
     * flush: 使数据表中的记录和 Session 缓存中的对象的状态保持一致. 为了保持一致, 则可能会发送对应的 SQL 语句.
     * 1. 在 Transaction 的 commit() 方法中: 先调用 session 的 flush 方法, 再提交事务
     * 2. flush() 方法会可能会发送 SQL 语句, 但不会提交事务.
     * 3. 注意: 在未提交事务或显式的调用 session.flush() 方法之前, 也有可能会进行 flush() 操作.
     * 1). 执行 HQL 或 QBC 查询, 会先进行 flush() 操作, 以得到数据表的最新的记录
     * 2). 若记录的 ID 是由底层数据库使用自增的方式生成的, 则在调用 save() 方法时, 就会立即发送 INSERT 语句.
     * 因为 save 方法后, 必须保证对象的 ID 是存在的!
     */
//     使数据库中记录与缓存中的一致
    @Test
    public void testflush()
    {
        news2 n= (news2) session.get(news2.class,1);
        n.setName("aaa");
        session.flush();
        System.out.println(n);
    }
    @Test
    public void testflush2()
    {
        news2 n= new news2("qaz",new Date());
        session.save(n);
        System.out.println(n);
    }

    //refresh(): 会强制发送 SELECT 语句, 以使 Session 缓存中对象的状态和数据表中对应的记录保持一致
    @Test
    public void testrefresh() throws InterruptedException {
        news2 n= (news2) session.get(news2.class,1);
        System.out.println(n);
        Thread.sleep(10000);
        session.refresh(n);
        System.out.println(n);
    }

    @Test
    public void testclear()
    {
        news2 n= (news2) session.get(news2.class,1);
        System.out.println(n);
//        清除缓存
        session.clear();
        news2 n1= (news2) session.get(news2.class,1);
        System.out.println(n1);
    }

    /**
     * 1. save() 方法
     * 1). 使一个临时对象变为持久化对象
     * 2). 为对象分配 ID.
     * 3). 在 flush 缓存时会发送一条 INSERT 语句.
     * 4). 在 save 方法之前的 id 是无效的
     * 5). 持久化对象的 ID 是不能被修改的!
     */
    @Test
    public void testsave()
    {
        news2 n=new news2();
        n.setName("kmn");
        n.setDate(new Date());
        n.setId(30);
        System.out.println(n);
        session.save(n);
        System.out.println(n);
    }

    //      persist(): 也会执行 INSERT 操作            和 save() 的区别 :
//      在调用 persist 方法之前, 若对象已经有 id 了, 则不会执行 INSERT, 而抛出异常
    @Test
    public void testpersist()
    {
        news2 n=new news2();
        n.setName("kmn");
        n.setDate(new Date());
        n.setId(30);
        session.persist(n);
        System.out.println(n);
    }

    //    get 是 立即检索, load 是延迟检索,若数据表中没有对应的记录,get返回null，load抛异常
    @Test
    public void testload()
    {
        news2 n= (news2) session.load(news2.class,19);
        System.out.println(n.getClass().getName());
        System.out.println(n);
    }


    //    若更新一个持久化对象, 不需要显示的调用 update 方法. 因为在调用 Transaction的
//                commit() 方法时,会先执行 session 的 flush 方法.
//    更新一个游离对象, 需要显式的调用 session 的 update 方法. 可以把一个游离对象变为持久化对象
//    若数据表中没有对应的记录, 但还调用了 update 方法, 会抛出异常
//    当 update() 方法关联一个游离对象时,如果在 Session 的缓存中已经存在相同 OID 的持久化对象,
//                会抛出异常. 因为在 Session 缓存中不能有两个 OID 相同的对象!
    @Test
    public void testupdate()
    {
        news2 n= (news2) session.get(news2.class,1);
        n.setName("iop");
//        transaction.commit();
        System.out.println(n);
    }

    @Test
    public void testsaveorupdate()
    {
        news2 n=new news2("qwe",new Date());
        session.saveOrUpdate(n);
        n= (news2) session.get(news2.class,1);
        n.setDate(new Date());
        session.saveOrUpdate(n);
    }

//    可以通过设置 hibernate 配置文件 hibernate.use_identifier_rollback 为 true,
//    使删除对象后, 把其 OID 置为  null
    @Test
    public void tesetdelete()
    {
        news2 n= (news2) session.get(news2.class,14);
        session.delete(n);
        System.out.println(n);
    }

//    evict: 从 session 缓存中把指定的持久化对象移除
    @Test
    public void testevict()
    {
        news2 n= (news2) session.get(news2.class,1);
        news2 n1= (news2) session.get(news2.class,2);
        n.setDate(new Date());
        n1.setDate(new Date());
        session.evict(n);
    }
}
