package com.kh.product.web.form;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ItemForm {
  private Long pid;
  private String pname;
  private Integer count;
  private Integer price;
}
