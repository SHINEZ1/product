package com.kh.product.web;

import com.kh.product.domain.Product;
import com.kh.product.domain.svc.ProductSVC;
import com.kh.product.web.form.AddForm;
import com.kh.product.web.form.EditForm;
import com.kh.product.web.form.ItemForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductSVC productSVC;

  //등록양식
  @GetMapping("/add")
  public String addForm(){
    return "product/addForm";
  }


  //등록처리

  @PostMapping("/add")
  public String add(@ModelAttribute AddForm addForm){

    //검증
    if(addForm.getCount() > 100){
      return "product/addForm";
    }

    Product product = new Product();
    product.setPname(addForm.getPname());
    product.setCount(addForm.getCount());
    product.setPrice(addForm.getPrice());

    Product addedProduct = productSVC.add(product);

    return "redirect:/products/"+addedProduct.getPid();

  }


  //상세화면
  @GetMapping("/{pid}")
  public String findById(
      @PathVariable("pid")Long pid,
      Model model
  ){

    Product findedProduct = productSVC.findById(pid);

    ItemForm itemForm = new ItemForm();
    itemForm.setPid(findedProduct.getPid());
    itemForm.setPname(findedProduct.getPname());
    itemForm.setCount(findedProduct.getCount());
    itemForm.setPrice(findedProduct.getPrice());

    model.addAttribute("itemForm",itemForm);

    return "product/itemForm";
  }


  //수정양식
  @GetMapping("/{pid}/edit")
  public String editForm(
      @PathVariable("pid") Long pid,
      Model model
  ){

    Product findedProduct = productSVC.findById(pid);


    EditForm editForm = new EditForm();
    editForm.setPid(findedProduct.getPid());
    editForm.setPname(findedProduct.getPname());
    editForm.setCount(findedProduct.getCount());
    editForm.setPrice(findedProduct.getPrice());

    model.addAttribute("editForm",editForm);

    return "product/editForm";
  }


  //수정처리
  @PostMapping("{pid}/edit")
  public String edit(
      @PathVariable("pid") Long pid,
      EditForm editForm
  ){

    Product product = new Product();
    product.setPid(pid);
    product.setPname(editForm.getPname());
    product.setCount(editForm.getCount());
    product.setPrice(editForm.getPrice());

    productSVC.edit(pid, product);

    return "redirect:/products/"+pid;

  }


  //삭제처리
  @GetMapping("{pid}/del")
  public String del(@PathVariable("pid") Long pid){

    productSVC.del(pid);
    return "redirect:/products";
  }


  //전체목록
  @GetMapping
  public String all(Model model){

    List<Product> all = productSVC.all();
    model.addAttribute("list", all);

    return "product/all";

  }

}
