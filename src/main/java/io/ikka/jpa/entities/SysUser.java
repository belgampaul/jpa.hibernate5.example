package io.ikka.jpa.entities;

import javax.persistence.*;

/**
 * @author ikka
 * @date: 20.02.2016.
 */
@Entity
public class SysUser {

@Id
  @SequenceGenerator(name = "seq_gen", sequenceName = "seq_sysuser")
  @GeneratedValue(strategy = GenerationType.AUTO, generator="seq_gen")
  private Long id;

  private String username;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
