package com.xuechuan.myapplication.function;

import android.content.Context;
import android.text.TextUtils;

import java.util.HashMap;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: demo
 * @Package com.xuechuan.myapplication.function
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/9/10 9:32
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class FunctionManger {
    private static FunctionManger mFunctionManger;
    private HashMap<String, FunctionNPNR> mFunctionNPNR;
    private HashMap<String, FunctionWPOnly> mFunctionWPonly;
    private HashMap<String, FunctionWROnly> mFunctionWRonly;
    private HashMap<String, FunctionPAndR> mFunctionPAR;

    private FunctionManger() {
        mFunctionNPNR = new HashMap<>();
        mFunctionWPonly = new HashMap<>();
        mFunctionWRonly = new HashMap<>();
        mFunctionPAR = new HashMap<>();
    }

    private static FunctionManger service;

    public static FunctionManger getInstance() {
        if (service == null) {
            service = new FunctionManger();
        }
        return service;
    }

    public void invokefunction(String functionName) {
        if (TextUtils.isEmpty(functionName))
            return;
        if (mFunctionNPNR != null) {
            FunctionNPNR f = mFunctionNPNR.get(functionName);

            if (f != null) {
                f.funciton();

            } else {
                try {
                    throw new FunctionException(" has no this funcion" + functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    public <Parame> void invokefunction(String functionName, Parame parame) {
        if (TextUtils.isEmpty(functionName))
            return;
        if (mFunctionWPonly != null) {
            FunctionWPOnly f = mFunctionWPonly.get(functionName);

            if (f != null) {
                f.function(parame);
            } else {
                try {
                    throw new FunctionException(" has no this funcion" + functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    public <Result> Result invokefunction(String functionName, Class<Result> c) {
        if (TextUtils.isEmpty(functionName))
            return null;
        if (mFunctionWRonly != null) {
            FunctionWROnly f = mFunctionWRonly.get(functionName);
            if (f != null) {
                if (c != null) {
                    return c.cast(f.function());
                } else {
                    return (Result) f.function();
                }
            } else {
                try {
                    throw new FunctionException(" has no this funcion" + functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    public <Result ,Parame> Result invokefunction(String functionName,Parame parame, Class<Result> c) {
        if (TextUtils.isEmpty(functionName)||parame ==null)
            return null;
        if (mFunctionPAR != null) {
            FunctionPAndR f = mFunctionPAR.get(functionName);
            if (f != null) {
                if (c != null) {
                    return c.cast(f.funciton(parame));
                } else {
                    return (Result) f.funciton(parame);
                }
            } else {
                try {
                    throw new FunctionException(" has no this funcion" + functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public FunctionManger addFucntion(FunctionNPNR npnr) {
        mFunctionNPNR.put(npnr.mFunctionName, npnr);
        return this;
    }


    public FunctionManger addFucntion(FunctionPAndR npnr) {
        mFunctionPAR.put(npnr.mFunctionName, npnr);
        return this;
    }

    public FunctionManger addFucntion(FunctionWROnly npnr) {
        mFunctionWRonly.put(npnr.mFunctionName, npnr);
        return this;
    }

    public FunctionManger addFucntion(FunctionWPOnly npnr) {
        mFunctionWPonly.put(npnr.mFunctionName, npnr);
        return this;
    }


}
