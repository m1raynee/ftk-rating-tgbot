package com.m1raynee.telegram;

import com.m1raynee.db.HibernateConfiguration;
import com.m1raynee.db.entity.Student;

public class Main {
	public static void main(String[] args) {
		var sessionFactory = HibernateConfiguration.getSessionFactory();

		sessionFactory.inTransaction(session -> {
			session.persist(new Student("Даричев Егор"));
			session.createSelectionQuery("from Student", Student.class)
					.getResultList().forEach(
							student -> System.err.println("Student (" + student.getName() + ")"));
		});

		sessionFactory.inTransaction(session -> {
			int updatedEntries = session.createMutationQuery(
					"update Student set name = :newName where name = :oldName")
					.setParameter("oldName", "Даричев Егор")
					.setParameter("newName", "Бильченко Александр")
					.executeUpdate();

			System.out.println(updatedEntries);
		});
	}
}
