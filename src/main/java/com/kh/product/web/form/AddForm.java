package com.kh.product.web.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Positive;

@Data
@ToString
@AllArgsConstructor
public class AddForm {

  private String pname;

  @Positive
  private Integer count;
  @Positive
  private Integer price;
}


