package com.aju.fit.ajufit.statics;

public enum UserType {
  S("S"),
  P("P");

  private final String type;

  UserType(String type) {
    this.type = type;
  }

  public static boolean isProfessor(UserType type) {
    return type.equals(P);
  }

  public static boolean isStudent(UserType type) {
    return type.equals(S);
  }
}
