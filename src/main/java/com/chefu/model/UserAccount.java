package com.chefu.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.vz.mongodb.jackson.Id;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by tanvirushabh on 7/26/14.
 */
@JsonFormat
public class UserAccount {

    @Id
    String emailAddress;

    @NotEmpty
    String password ;

  public UserAccount() {
  }

  @JsonProperty
  public String getEmailAddress() {
        return emailAddress;
    }

  public void setEmailAddress(String emailAddress) {
      this.emailAddress = emailAddress;
  }

  @JsonProperty
  public String getPassword() {
      return password;
  }

  public void setPassword(String password) {
      this.password = password;
  }
}
