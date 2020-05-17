package com.demo.lambda.cart;


/**
 * 商品对象
 */
public class Sku {

  private Integer skuId;
  private String skuName;
  private Double skuPrice;
  private Integer totalNum;
  private Double totalPrice;
  private Enum skuCategory;

  /**
   * 构造函数
   *
   * @param skuId       编号
   * @param skuName     商品名称
   * @param skuPrice    单价
   * @param totalNum    购买个数
   * @param totalPrice  总价
   * @param skuCategory 商品类型
   */
  public Sku(Integer skuId, String skuName,
             Double skuPrice, Integer totalNum,
             Double totalPrice, Enum skuCategory) {
    this.skuId = skuId;
    this.skuName = skuName;
    this.skuPrice = skuPrice;
    this.totalNum = totalNum;
    this.totalPrice = totalPrice;
    this.skuCategory = skuCategory;
  }

  public Integer getSkuId() {
    return skuId;
  }

  public String getSkuName() {
    return skuName;
  }

  public Double getSkuPrice() {
    return skuPrice;
  }

  public Integer getTotalNum() {
    return totalNum;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public Enum getSkuCategory() {
    return skuCategory;
  }
}
