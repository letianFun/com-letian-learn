package com.letian.learn.javase.design.pattern.behavioral.template;

/**
 * @author :  lihao
 * @date : 2020/7/3 14:21
 */
public abstract class Game {


    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模板
    public final void play(){

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
