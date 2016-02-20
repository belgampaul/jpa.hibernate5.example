package io.ikka;

import io.ikka.jpa.core.PersistenceManager;
import io.ikka.jpa.entities.SysUser;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class App {
  public static void main(String[] args) {
    System.out.println("Application running");


    SysUser user = new SysUser();
    user.setUsername("i");

    EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

    try {
      em.getTransaction().begin();
      Validator validator;
      final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
      validator = factory.getValidator();
      Set<ConstraintViolation<SysUser>> violations = validator.validate(user);
      for (ConstraintViolation<SysUser> violation : violations) {
        System.out.println(violation.getMessage());
      }


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
