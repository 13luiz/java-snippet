package com.demo.lombok;

import lombok.val;

import java.util.ArrayList;


/**
 * @val 注解
 * 弱语言变量
 */
public class ValTest {

  public ValTest() {
    val field = "zhangxiaoxi";

    val list = new ArrayList<String>();
    list.add("zhangxiaoxi");
  }

}
