package com.lucifer.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * Created with IntelliJ IDEA.
 * User: ifun
 * Date: 13-4-19
 * Time: 下午2:46
 * To change this template use File | Settings | File Templates.
 */
public class ReflectionHelper {

    /**
     * 取对象的变量的值
     * 通过反射对象的 getter方法
     * @param obj
     * @param att
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    public static Object getPropertyByGeterMethod(Object obj,String att) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method met = obj.getClass().getMethod("get" + initStr(att));
        Object target = met.invoke(obj);
        return target;
    }

    public static String initStr(String old){   // 将单词的首字母大写
        String str =null;
        if(old.length()>1){
            str= old.substring(0,1).toUpperCase() + old.substring(1) ;
        }  else{
            str= old.substring(0,1).toUpperCase();
        }

        return str ;
    }
}
