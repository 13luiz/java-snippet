package com.demo.stream;

import com.alibaba.fastjson.JSON;
import com.demo.lambda.cart.CartService;
import com.demo.lambda.cart.Sku;
import com.demo.lambda.cart.SkuCategoryEnum;
import org.junit.Before;
import org.junit.Test;

import java.util.*;


/**
 * 演示流的各种操作
 */
public class StreamOperator {

  List<Sku> list;

  @Before
  public void init() {
    list = CartService.getCartSkuList();
  }

  /**
   * filter：过滤掉不符合断言判断的数据
   */
  @Test
  public void filterTest() {
    list.stream()
            .filter(sku -> SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
            .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
  }

  /**
   * map：将一个元素转换成另一个元素
   */
  @Test
  public void mapTest() {
    list.stream()
            .map(sku -> sku.getSkuName())
            .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
  }

  /**
   * flatMap：将一个对象转换成流
   */
  @Test
  public void flatMapTest() {
    list.stream()
            .flatMap(sku -> Arrays.stream(sku.getSkuName().split("")))
            .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
  }

  /**
   * peek：对流中元素进行遍历操作，与 forEach 类似，但不会销毁流元素
   */
  @Test
  public void peek() {
    list.stream()
            .peek(sku -> System.out.println(sku.getSkuName()))
            .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
  }

  /**
   * sort：对流中元素进行排序，可选则自然排序或指定排序规则。有状态操作
   */
  @Test
  public void sortTest() {
    list.stream()
            .peek(sku -> System.out.println(sku.getSkuName()))
            .sorted(Comparator.comparing(Sku::getTotalPrice))
            .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
  }

  /**
   * distinct：对流元素进行去重。有状态操作
   */
  @Test
  public void distinctTest() {
    list.stream()
            .map(sku -> sku.getSkuCategory())
            .distinct()
            .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
  }

  /**
   * skip：跳过前 N 条记录。有状态操作
   */
  @Test
  public void skipTest() {
    list.stream()
            .sorted(Comparator.comparing(Sku::getTotalPrice))
            .skip(3)
            .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
  }

  /**
   * limit：截断前 N 条记录。有状态操作
   */
  @Test
  public void limitTest() {
    list.stream()
            .sorted(Comparator.comparing(Sku::getTotalPrice))
            .skip(2 * 3)
            .limit(3)
            .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
  }

  /**
   * allMatch：终端操作，短路操作。所有元素匹配，返回 true
   */
  @Test
  public void allMatchTest() {
    boolean match = list.stream()
            .peek(sku -> System.out.println(sku.getSkuName()))
            .allMatch(sku -> sku.getTotalPrice() > 100);
    System.out.println(match);
  }

  /**
   * anyMatch：任何元素匹配，返回 true
   */
  @Test
  public void anyMatchTest() {
    boolean match = list.stream()
            .peek(sku -> System.out.println(sku.getSkuName()))
            .anyMatch(sku -> sku.getTotalPrice() > 100);
    System.out.println(match);
  }

  /**
   * noneMatch：任何元素都不匹配，返回 true
   */
  @Test
  public void noneMatchTest() {
    boolean match = list.stream()
            .peek(sku -> System.out.println(sku.getSkuName()))
            .noneMatch(sku -> sku.getTotalPrice() > 10_000);
    System.out.println(match);
  }

  /**
   * 找到第一个
   */
  @Test
  public void findFirstTest() {
    Optional<Sku> optional = list.stream()
            .peek(sku -> System.out.println(sku.getSkuName()))
            .findFirst();
    System.out.println(JSON.toJSONString(optional.get(), true));
  }

  /**
   * 找任意一个
   */
  @Test
  public void findAnyTest() {
    Optional<Sku> optional = list.stream()
            .peek(sku -> System.out.println(sku.getSkuName()))
            .findAny();
    System.out.println(JSON.toJSONString(optional.get(), true));
  }

  /**
   * max
   */
  @Test
  public void maxTest() {
    OptionalDouble optionalDouble = list.stream()
            .mapToDouble(Sku::getTotalPrice)
            .max();
    System.out.println(optionalDouble.getAsDouble());
  }

  /**
   * min
   */
  @Test
  public void minTest() {
    OptionalDouble optionalDouble = list.stream()
            .mapToDouble(Sku::getTotalPrice)
            .min();
    System.out.println(optionalDouble.getAsDouble());
  }

  /**
   * count
   */
  @Test
  public void countTest() {
    long count = list.stream()
            .count();
    System.out.println(count);
  }

}
