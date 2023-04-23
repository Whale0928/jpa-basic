package helloJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello JPA");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
		EntityManager em = entityManagerFactory.createEntityManager();

		//코드 영역 시작

		//코드 영역 끝

		em.clear();
		entityManagerFactory.close();
	}
}
