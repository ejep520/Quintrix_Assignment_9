package com.quintrix.jepsen.erik.ninth.model;

import java.util.List;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "persons")
public class Person {
  @Id
  @Builder.Default
  private UUID personId = UUID.randomUUID();
  @Builder.Default
  private UUID deptId = null;
  private String fName;
  private String lName;
  private List<String> skills;

  public UUID getDeptId() {
    return deptId;
  }

  public void setDeptId(UUID deptId) {
    this.deptId = deptId;
  }

  public String getfName() {
    return fName;
  }

  public void setfName(String fName) {
    this.fName = fName;
  }

  public String getlName() {
    return lName;
  }

  public void setlName(String lName) {
    this.lName = lName;
  }

  public List<String> getSkills() {
    return skills;
  }

  public void setSkills(List<String> skills) {
    this.skills = skills;
  }

  public UUID getPersonId() {
    return personId;
  }
}
