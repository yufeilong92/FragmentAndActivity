# FragmentAndActivity
```
//定义事件
public abstract class Function {
    public String mFunctionName;
    public Function(String mFunctionName) {
        this.mFunctionName = mFunctionName;
    }
}
//定义错误
public class FunctionException extends Exception {
    public FunctionException(String message) {
        super(message);
    }
}
//初始化管理器
public class FunctionManger {
    private static FunctionManger mFunctionManger;
    private HashMap<String, FunctionNPNR> mFunctionNPNR;
    private HashMap<String, FunctionWRWP> mFunctionWPWR;
    private HashMap<String, FunctionOnlyParamt> mFunctionWP;
    private HashMap<String, FunctionOnlyResult> mFuncitonWR;

    public FunctionManger() {
        mFuncitonWR = new HashMap<>();
        mFunctionWP = new HashMap<>();
        mFunctionWPWR = new HashMap<>();
        mFunctionNPNR = new HashMap<>();
    }

    private volatile static FunctionManger _instance;

    public static FunctionManger get_Instance() {
        if (_instance == null) {
            synchronized (FunctionManger.class) {
                if (_instance == null) {
                    _instance = new FunctionManger();
                }
            }
        }
        return _instance;
    }

    /**
     * 无参无结果
     *
     * @param functionName
     */
    public void invokefunction(String functionName) {
        if (StringUtil.isEmpty(functionName)) return;
        if (mFunctionNPNR != null) {
            FunctionNPNR npnr = mFunctionNPNR.get(functionName);
            if (npnr != null) {
                npnr.funciton();
            } else {
                try {
                    throw new FunctionException("Has no this Function" + functionName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 无结果
     *
     * @param functionName
     */
    public <Parame> void invokefunction(String functionName, Parame parame) {
        if (StringUtil.isEmpty(functionName)) return;
        if (mFunctionWP != null) {
            FunctionOnlyParamt onlyParamt = mFunctionWP.get(functionName);
            if (onlyParamt != null) {
                onlyParamt.function(parame);
            } else {
                try {
                    throw new FunctionException("Has no this Function" + functionName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 无参数有结果
     *
     * @param functionName
     */
    public <Result> Result invokefunction(String functionName, Class<Result> result) {
        if (StringUtil.isEmpty(functionName)) return null;
        if (mFuncitonWR != null) {
            FunctionOnlyResult onlyResult = mFuncitonWR.get(functionName);
            if (onlyResult != null) {
                if (result != null) {
                    return result.cast(onlyResult.function());
                } else {
                    return (Result) onlyResult.function();
                }
            } else {
                try {
                    throw new FunctionException("Has no this Function" + functionName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 有参数有结果
     *
     * @param functionName
     */
    public <Parame, Result> Result invokefunction(String functionName, Parame parame, Class<Result> result) {
        if (StringUtil.isEmpty(functionName)) return null;
        if (mFunctionWPWR != null) {
            FunctionWRWP wrwp = mFunctionWPWR.get(functionName);
            if (wrwp != null) {
                if (result != null) {
                    return result.cast(wrwp.function(parame));
                } else {
                    return (Result) wrwp.function(parame);
                }
            } else {
                try {
                    throw new FunctionException("Has no this Function" + functionName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public FunctionManger addFunction(FunctionWRWP wrwp) {
        mFunctionWPWR.put(wrwp.mFunctionName, wrwp);
        return this;
    }

    public FunctionManger addFunction(FunctionNPNR npnr) {
        mFunctionNPNR.put(npnr.mFunctionName, npnr);
        return this;
    }
    public FunctionManger addFunction(FunctionOnlyParamt onlyParamt) {
        mFunctionWP.put(onlyParamt.mFunctionName, onlyParamt);
        return this;
    }
    public FunctionManger addFunction(FunctionOnlyResult onlyResult) {
        mFuncitonWR.put(onlyResult.mFunctionName, onlyResult);
        return this;
    }
}
//无参无结果类
public abstract class FunctionNPNR extends Function {
    public FunctionNPNR(String mFunctionName) {
        super(mFunctionName);
    }
    public abstract void funciton();
}
//有参数类
public abstract class FunctionOnlyParamt<Parame> extends Function {
    public FunctionOnlyParamt(String mFunctionName) {
        super(mFunctionName);
    }
    public abstract void function(Parame parame);

}
//有结果类
public abstract class FunctionOnlyResult<Result> extends Function {
    public FunctionOnlyResult(String mFunctionName) {
        super(mFunctionName);
    }
    public abstract Result function();
}
//有参数有结果类
public abstract class FunctionWRWP<Parame, Result> extends Function {
    public FunctionWRWP(String mFunctionName) {
        super(mFunctionName);
    }

    public abstract Result function(Parame parame);

}
//fragment基类
public abstract class NBaseFragment extends Fragment {
    private static String TAG = "【" + NBaseFragment.class + "】==";
    protected FunctionManger mFunctionManger;

    public void setmFunctionManger(FunctionManger manger) {
        this.mFunctionManger = manger;
    }
    public abstract String INIERFACE();

    public abstract Context c();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (c()==context){
            BaseActivity mBaseActivity= (BaseActivity) context;
        }
    }

}
//activity 基类
public abstract class BaseActivity extends AppCompatActivity {
    public void setFunctionManger(String tag, String npr, String wp, String wr, String pandr) {
        FragmentManager f = getSupportFragmentManager();
        BaseFragment fragment = (BaseFragment) f.findFragmentByTag(tag);
        FunctionManger functionManger = FunctionManger.getInstance();
        fragment.setFunctionManger(functionManger.addFucntion(new FunctionNPNR(npr) {
            @Override
            public void funciton() {

                NParamNResultMethod();
            }
        })
                .addFucntion(new FunctionWPOnly(wp) {

                    @Override
                    public void function(Object s) {
                        WParamNResultMethod(s);
                    }
                })
                .addFucntion(new FunctionWROnly(wr) {
                    @Override
                    public Object function() {
                        return NParamWResultMethod();
                    }
                })
                .addFucntion(new FunctionPAndR(pandr) {
                    @Override
                    public Object funciton(Object msg) {
                        return ParamAndResultMethod(msg);
                    }
                }));

    }

    public abstract void NParamNResultMethod();

    public abstract <Parame> void WParamNResultMethod(Parame parame);

    public abstract <Result> Result NParamWResultMethod();

    public abstract <Result, Paramet> Result ParamAndResultMethod(Paramet paramet);


}



```
