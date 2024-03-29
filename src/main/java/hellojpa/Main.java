package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
		EntityManager em = entityManagerFactory.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			Order order = new Order();
			order.addOrder(new OrderItem());
			em.persist(order);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		entityManagerFactory.close();
	}
}
