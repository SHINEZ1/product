package com.kh.product.domain.svc;

import com.kh.product.domain.Product;
import com.kh.product.domain.dao.ProductDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductSVCImpl implements ProductSVC {

  private final ProductDAO productDAO;

  /**
   * 등록
   *
   * @param product 상품정보
   * @return 등록된 상품
   */
  @Override
  public Product add(Product product) {
    return productDAO.add(product);
  }

  /**
   * 조회
   *
   * @param pid 상품아이디
   * @return 상품
   */
  @Override
  public Product findById(Long pid) {
    return productDAO.findById(pid);
  }

  /**
   * 수정
   *
   * @param pid
   * @param product 수정할 상품정보
   */
  @Override
  public void edit(Long pid, Product product) {
    productDAO.edit(pid,product);
  }

  /**
   * 삭제
   *
   * @param pid 상품아이디
   */
  @Override
  public void del(Long pid) {
    productDAO.del(pid);
  }

  /**
   * 목록
   *
   * @return 상품전체
   */
  @Override
  public List<Product> all() {
    return productDAO.all();
  }
}
