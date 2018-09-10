package com.xuechuan.myapplication.function;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: demo
 * @Package com.xuechuan.myapplication.function
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/9/10 9:19
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public abstract class FunctionWPOnly<Parame> extends Function {

    public FunctionWPOnly(String functionName) {
        super(functionName);
    }
    public  abstract void function(Parame parame);
}
