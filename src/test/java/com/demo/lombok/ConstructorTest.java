package com.demo.lombok;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;


/**
 * @AllArgsConstructor 全参
 * @NoArgsConstructor 无参
 * @RequiredArgsConstructor 必要参数
 */
@RequiredArgsConstructor
public class ConstructorTest {

  private final String field1;

  @NonNull
  private String field2;

  private String field3;

}
