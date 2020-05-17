package com.demo.lombok;

import lombok.AccessLevel;
import lombok.Getter;

import javax.validation.constraints.NotNull;


/**
 * @Getter 注解
 * 为属性生成 get 方法
 */
public class GetterTest {

  // lazy 作用在 final 字段
  @Getter(
          lazy = true
  )
  private final String field1 = "zhangxiaoxi";

  // onMethod_ 方法增加其他注解
  @Getter(
          value = AccessLevel.PRIVATE,
          onMethod_ = {@NotNull}
  )
  private String field2;

}
