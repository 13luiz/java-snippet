package com.demo.lambda.cart;


/**
 * 商品类型枚举
 */
public enum SkuCategoryEnum {

  CLOTHING(10, "服装类"),
  ELECTRONICS(20, "数码类"),
  SPORTS(30, "运动类"),
  BOOKS(40, "图书类");

  private Integer code;
  private String name;

  /**
   * 构造函数
   *
   * @param code 商品类型的编号
   * @param name 商品类型的名称
   */
  SkuCategoryEnum(Integer code, String name) {
    this.code = code;
    this.name = name;
  }
}
