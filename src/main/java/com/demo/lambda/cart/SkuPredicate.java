package com.demo.lambda.cart;


/**
 * Sku 选择谓词接口
 */
public interface SkuPredicate {

  /**
   * 选择判断标准
   *
   * @param sku Sku 对象
   */
  boolean test(Sku sku);

}
