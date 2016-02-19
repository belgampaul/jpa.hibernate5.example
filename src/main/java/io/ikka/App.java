package io.ikka;

import io.ikka.jpa.core.PersistenceManager;
import io.ikka.jpa.entities.SysUser;

import javax.persistence.EntityManager;

public class App {
  public static void main(String[] args) {
    System.out.println("Application running");


    SysUser user = new SysUser();
    user.setUsername("ikka");

    EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

    try {
      em.getTransaction().begin();
      em.persist(user);
      em.getTransaction().commit();

      em.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      PersistenceManager.INSTANCE.close();
    }
    System.out.println("Application stopped");
  }
}
