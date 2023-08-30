package ra.model.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import ra.model.entity.FeedBack;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

import java.util.List;

@Repository
public class FeedBackRepository implements IFeedBackRepository {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;
    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.config.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<FeedBack> findAll() {

        List<FeedBack> list = new ArrayList<>();
        // select * from Person (object)
        String hql = "select f from FeedBack as f order by date desc";
        // sử dụng các phương thức get/set của đối tượng 1 cách tự động
        TypedQuery<FeedBack> typedQuery = entityManager.createQuery(hql, FeedBack.class);
        list= typedQuery.getResultList();
        return list;
    }

    @Override
    public FeedBack findById(Long id) {
        // sử dụng phương thức của đối tượng 1 cách tự động
        TypedQuery<FeedBack> typedQuery = entityManager.createQuery("select f from FeedBack as f where f.id =:id", FeedBack.class);
        typedQuery.setParameter("id",id);
        // lấy về 1 đối tượng
        FeedBack f = typedQuery.getSingleResult();
        return f;
    }

    @Override
    public void save(FeedBack feedback) {
        // khởi tạo các đối tượng để quản lý giao dịch
        Session session = null;
        Transaction transaction = null;
        try {
            // khởi tạo phiên
            session = sessionFactory.openSession();
            // bắt đầu 1 giao dịch
            transaction = session.beginTransaction();
            if(feedback.getId()==null){
                session.save(feedback);
            } else {
                FeedBack old = findById(feedback.getId());
                old.clone(feedback);
                session.saveOrUpdate(old);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.isActive();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    @Override
    public void delete(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(findById(id));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {transaction.isActive();}
        } finally {
            if (session != null) {session.close();}
        }
    }
}