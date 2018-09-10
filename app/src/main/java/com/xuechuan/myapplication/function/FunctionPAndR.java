package com.xuechuan.myapplication.function;

import javax.xml.transform.Result;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: demo
 * @Package com.xuechuan.myapplication.function
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/9/10 9:22
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public abstract class FunctionPAndR< Parame,Result> extends Function {

    public FunctionPAndR(String functionName) {
        super(functionName);
    }
    public abstract Result funciton(Parame parame);
}
