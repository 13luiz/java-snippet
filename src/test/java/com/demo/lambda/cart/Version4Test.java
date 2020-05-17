package com.demo.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;


public class Version4Test {

  @Test
  public void filterSkus1() {
    List<Sku> cartSkuList = CartService.getCartSkuList();

    // 过滤商品总价大于 2000 的商品
    List<Sku> result = CartService.filterSkus(cartSkuList, new SkuTotalPricePredicate());
    System.out.println(JSON.toJSONString(result, true));
  }

  @Test
  public void filterSkus2() {
    List<Sku> cartSkuList = CartService.getCartSkuList();
    // 传入匿名类，过滤商品单价大于 1000 的商品
    List<Sku> result = CartService.filterSkus(
            cartSkuList, new SkuPredicate() {
              @Override
              public boolean test(Sku sku) {
                return sku.getSkuPrice() > 1000;
              }
            });
    System.out.println(JSON.toJSONString(result, true));
  }

  @Test
  public void filterSkus3() {
    List<Sku> cartSkuList = CartService.getCartSkuList();
    // 过滤商品单价大于1000的商品
    List<Sku> result = CartService.filterSkus(cartSkuList,
            (Sku sku) -> sku.getSkuPrice() > 1000);
    System.out.println(JSON.toJSONString(result, true));
  }

}
