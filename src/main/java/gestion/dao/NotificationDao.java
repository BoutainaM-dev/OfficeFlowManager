package gestion.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gestion.model.Notification;
import gestion.model.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class NotificationDao{

    @PersistenceContext
    private EntityManager entityManager;

    public Notification save(Notification notification) {
        entityManager.persist(notification);
        return notification;
    }

    public Notification findByUser(Utilisateur user) {
        Query query = entityManager.createQuery("SELECT n FROM Notification n WHERE n.user = :user");
        query.setParameter("user", user);
        return (Notification) query.getSingleResult();
    }

    public List<Notification> findByUser(Utilisateur user, int limit) {
        Query query = entityManager.createQuery("SELECT n FROM Notification n WHERE n.user = :user");
        query.setParameter("user", user);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public Notification findByUserAndNotificationId(Utilisateur user, Integer notificationId) {
        Query query = entityManager.createQuery("SELECT n FROM Notification n WHERE n.user = :user AND n.notificationId = :notificationId");
        query.setParameter("user", user);
        query.setParameter("notificationId", notificationId);
        return (Notification) query.getSingleResult();
    }
}

