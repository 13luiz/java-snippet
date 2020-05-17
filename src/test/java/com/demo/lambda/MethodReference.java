package com.demo.lambda;

import java.util.function.Consumer;


/**
 * 三种方法引用
 */
public class MethodReference {

  /**
   * 指向静态方法的方法引用
   * (args) -> ClassName.staticMethod(args);
   * ClassName::staticMethod;
   */
  public void test1() {
    Consumer<String> consumer1 = (String number) -> Integer.parseInt(number);
    Consumer<String> consumer2 = Integer::parseInt;
  }

  /**
   * 指向任意类型实例方法的方法引用
   * (args) -> args.instanceMethod();
   * ClassName::instanceMethod;
   */
  public void test2() {
    Consumer<String> consumer1 = (String str) -> str.length();
    Consumer<String> consumer2 = String::length;
  }

  /**
   * 指向现有对象实例方法的方法引用
   * (args) -> object.instanceMethod(args);
   * object::instanceMethod;
   */
  public void test3() {
    StringBuilder stringBuilder = new StringBuilder();

    Consumer<String> consumer1 = (String str) -> stringBuilder.append(str);
    Consumer<String> consumer2 = stringBuilder::append;
  }

}
