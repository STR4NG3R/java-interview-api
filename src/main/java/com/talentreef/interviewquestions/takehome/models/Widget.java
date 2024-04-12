package com.talentreef.interviewquestions.takehome.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder(toBuilder=true)
public class Widget {

  @Size(min = 3, message = "minimum length it's 3")
  @Size(max = 100, message = "max length it's 3")
  private String name;

  @Size(min=5, message = "minimum length it's 5")
  @Size(max=1000, message = "max length it's 1000")
  private String description;


  @Digits(integer = 20_000, fraction = 2, message = "number must has 2 point float")
  @Min(value = 1, message = "number must be greater than 0")
  @Max(value = 20_000, message = "number must be less than 20,000")
  private Double price;


}
