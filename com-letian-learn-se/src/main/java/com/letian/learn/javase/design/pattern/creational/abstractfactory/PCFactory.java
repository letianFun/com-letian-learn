package com.letian.learn.javase.design.pattern.creational.abstractfactory;

import com.letian.learn.javase.design.pattern.creational.abstractfactory.keyboard.Keyboard;
import com.letian.learn.javase.design.pattern.creational.factory.Mouse;

/**
 * @author :  lihao
 * @date : 2020/6/10 13:55
 * @description :
 */
public interface PCFactory {

    /*** 生产鼠标
     *
     * @author lihao
     * @date 2020/6/10 14:24
     * @return  鼠标
     */
     Mouse createMouse();

    /*** 生产键盘
     *
     * @author lihao
     * @date 2020/6/10 14:26
     * @return 键盘
     */
     Keyboard createKeyboard();

     /*** 新茶品功能
      *
      * @author lihao
      * @date 2020/6/10 14:33
      */
     default void newProduct(){
         System.out.println("新产品");
     };
}
