package io.ikka.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author ikka
 * @date: 20.02.2016.
 */
@Entity
public class SysUser {

  @Id
  @SequenceGenerator(name = "seq_gen", sequenceName = "seq_sysuser")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen")
  private Long id;

  @NotNull
  @Size(min = 2, max = 255, message = "Name is required, maximum 255 characters.")
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
