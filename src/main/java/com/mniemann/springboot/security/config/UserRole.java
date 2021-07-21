package com.mniemann.springboot.security.config;

import static com.mniemann.springboot.security.config.UserPermission.COURSE_READ;
import static com.mniemann.springboot.security.config.UserPermission.COURSE_WRITE;
import static com.mniemann.springboot.security.config.UserPermission.STUDENT_READ;
import static com.mniemann.springboot.security.config.UserPermission.STUDENT_WRITE;

import com.google.common.collect.Sets;
import java.util.Set;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserRole {
  STUDENT(Sets.newHashSet()),
  ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE)),
  ADMINTRAINEE(Sets.newHashSet(COURSE_READ, STUDENT_READ));

  private final Set<UserPermission> permissions;

  public Set<UserPermission> getPermissions() {
    return permissions;
  }
}
