package com.demo.lambda.cart;


/**
 * Sku 总价是否超出 2000 的判断标准
 */
public class SkuTotalPricePredicate implements SkuPredicate {

  @Override
  public boolean test(Sku sku) {
    return sku.getTotalPrice() > 2000;
  }

}
