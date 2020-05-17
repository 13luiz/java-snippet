package com.demo.lambda.cart;

import java.util.ArrayList;
import java.util.List;


/**
 * 购物车-服务类
 */
public class CartService {

  /**
   * 构造购物车的商品列表
   */
  private static List<Sku> cartSkuList =
          new ArrayList<Sku>() {
            {
              add(new Sku(654032, "无人机",
                      4999.00, 1,
                      4999.00, SkuCategoryEnum.ELECTRONICS));

              add(new Sku(642934, "VR一体机",
                      2299.00, 1,
                      2299.00, SkuCategoryEnum.ELECTRONICS));

              add(new Sku(645321, "纯色衬衫",
                      409.00, 3,
                      1227.00, SkuCategoryEnum.CLOTHING));

              add(new Sku(654327, "牛仔裤",
                      528.00, 1,
                      528.00, SkuCategoryEnum.CLOTHING));

              add(new Sku(675489, "跑步机",
                      2699.00, 1,
                      2699.00, SkuCategoryEnum.SPORTS));

              add(new Sku(644564, "Java编程思想",
                      79.80, 1,
                      79.80, SkuCategoryEnum.BOOKS));

              add(new Sku(678678, "Java核心技术",
                      149.00, 1,
                      149.00, SkuCategoryEnum.BOOKS));

              add(new Sku(697894, "算法",
                      78.20, 1,
                      78.20, SkuCategoryEnum.BOOKS));

              add(new Sku(696968, "TensorFlow进阶指南",
                      85.10, 1,
                      85.10, SkuCategoryEnum.BOOKS));
            }
          };

  public static List<Sku> getCartSkuList() {
    return cartSkuList;
  }

  /**
   * Version 4.0.0
   * 根据不同的 Sku 判断标准，对 Sku 列表进行过滤
   *
   * @param predicate - Sku 判断标准策略
   */
  public static List<Sku> filterSkus(List<Sku> cartSkuList,
                                     SkuPredicate predicate) {
    List<Sku> result = new ArrayList<Sku>();
    for (Sku sku : cartSkuList) {
      // 根据不同的 Sku 判断标准策略，对 Sku 进行判断
      if (predicate.test(sku)) {
        result.add(sku);
      }
    }
    return result;
  }

  /**
   * Version 1.0.0
   * 需求一：找出购物车中所有电子产品
   */
  @Deprecated
  public static List<Sku> filterElectronicsSkus(List<Sku> cartSkuList) {
    List<Sku> result = new ArrayList<Sku>();
    for (Sku sku : cartSkuList) {
      if (SkuCategoryEnum.ELECTRONICS.equals(sku.getSkuCategory())) {
        result.add(sku);
      }
    }
    return result;
  }

  /**
   * Version 2.0.0
   * 需求二：根据传入商品类型找出购物车中同种商品类型的商品列表
   */
  @Deprecated
  public static List<Sku> filterSkusByCategory(List<Sku> cartSkuList,
                                               SkuCategoryEnum category) {
    List<Sku> result = new ArrayList<Sku>();
    for (Sku sku : cartSkuList) {
      if (category.equals(sku.getSkuCategory())) {
        result.add(sku);
      }
    }
    return result;
  }

  /**
   * Version 3.0.0
   * 需求三：支持通过商品类型或总价来过滤商品
   *
   * @param categoryOrPrice - true: 根据商品类型，false: 根据商品总价
   */
  @Deprecated
  public static List<Sku> filterSkus(List<Sku> cartSkuList,
                                     SkuCategoryEnum category,
                                     Double totalPrice,
                                     Boolean categoryOrPrice) {
    List<Sku> result = new ArrayList<Sku>();
    for (Sku sku : cartSkuList) {
      // 如果根据商品类型判断，sku 类型与输入类型比较
      // 如果根据商品总价判断，sku 总价与输入总价比较
      if ((categoryOrPrice && category.equals(sku.getSkuCategory()) ||
              (!categoryOrPrice && sku.getTotalPrice() > totalPrice))) {
        result.add(sku);
      }
    }
    return result;
  }
}
