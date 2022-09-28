package com.quintrix.jepsen.erik.ninth.model;

import java.util.UUID;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "departments")
public class Department {
  @Builder.Default
  private UUID deptId = UUID.randomUUID();
  private String name;

}
