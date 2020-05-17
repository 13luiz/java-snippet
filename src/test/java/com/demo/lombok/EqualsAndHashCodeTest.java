package com.demo.lombok;

import lombok.EqualsAndHashCode;


/**
 * @EqualsAndHashCode 注解
 * 生成 Equals 方法和 HashCode 方法
 */
@EqualsAndHashCode(
        exclude = {"field1"}
)
public class EqualsAndHashCodeTest {

  private String field1;

  private String field2;

}
