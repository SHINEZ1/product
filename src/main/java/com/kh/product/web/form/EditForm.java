package com.kh.product.web.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Positive;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EditForm {
  private Long pid;
  private String pname;

  @Positive
  private Integer count;
  @Positive
  private Integer price;
}
