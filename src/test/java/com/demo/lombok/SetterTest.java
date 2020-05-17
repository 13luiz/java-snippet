package com.demo.lombok;

import lombok.AccessLevel;
import lombok.Setter;

import javax.validation.constraints.NotNull;


/**
 * @Setter 注解
 * 为属性生成 set 方法
 */
public class SetterTest {

  @Setter
  private String field1;

  // onParam_ 参数增加其他注解
  @Setter(
          value = AccessLevel.PRIVATE,
          onParam_ = {@NotNull}
  )
  private String field2;

}
