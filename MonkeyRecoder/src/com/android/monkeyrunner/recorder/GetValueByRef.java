package com.android.monkeyrunner.recorder;


import java.lang.reflect.InvocationTargetException;

import java.lang.reflect.Method;

 



 

public class GetValueByRef {

     

    /**

     * �÷����ȡ �ֶε�ֵ
10
     * @param srcObj ���ö���
11
     * @param fieldName �ֶ�����
12
     * @return
13
     */

     

    public static Object getValueByRef(Object srcObj, String fieldName){

        Object value = null;

        Class objClass = srcObj.getClass();

        fieldName =fieldName.replaceFirst(fieldName.substring(0, 1), fieldName.substring(0, 1).toUpperCase());

        String getMethodName = "get"+fieldName;

        try {

            Method method = objClass.getMethod(getMethodName);//��һ������Ϊ���õķ��������ڶ���Ϊ�����ķ���ֵ:����  

            value = method.invoke(srcObj);///��һ��������ʾҪ���õĶ��󣬺���Ϊ������������Ĳ���  

        }  catch (IllegalAccessException e) {

            e.printStackTrace();

        } catch (IllegalArgumentException e) {

            e.printStackTrace();

        } catch (InvocationTargetException e) {

            e.printStackTrace();

        }catch (NoSuchMethodException e) {

            e.printStackTrace();

        } catch (SecurityException e) {

            e.printStackTrace();

        }

        return value;

    }

}

