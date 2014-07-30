package com.chefu.view;

import com.chefu.model.UserAccount;
import io.dropwizard.views.View;

public class LoginView extends View {
  private final UserAccount userAccount;

  public LoginView(String templateName, UserAccount userAccount) {
    super(templateName);
    this.userAccount = userAccount;
  }

  public UserAccount getUserAccount() {
    return userAccount;
  }
}
