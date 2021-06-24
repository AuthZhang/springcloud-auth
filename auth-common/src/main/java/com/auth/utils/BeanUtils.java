package com.auth.utils;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 * Created by zhangyu on 2018/4/13.
 */

public class BeanUtils {
    /**
     * 复制bean
     * 如果源bean中的变量为null则不赋值
     * @author zhangyu
     * @date 2018/4/13
     */
    public static void copyExcludeNull(Object source,Object target) throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, ParseException {
        if(source == null || target == null) return;

        Class<?> tClazz = Class.forName(target.getClass().getName());
        Class<?> sClazz = Class.forName(source.getClass().getName());
        Field[] tFields = tClazz.getDeclaredFields();
        Field[] sFields = sClazz.getDeclaredFields();

        if(tFields == null || tFields.length == 0 || sFields == null || sFields.length == 0) return;

        for(Field tField:tFields){
            tField.setAccessible(true);
            for(Field sField:sFields){
                if(tField.getName().equals(sField.getName())){
                    sField.setAccessible(true);
                    setValue(tClazz,target,tField.getName(),sField.get(source));
                }
            }
        }

        tClazz = tClazz.getSuperclass();
        tFields = tClazz.getDeclaredFields();
        for(Field tField:tFields){
            tField.setAccessible(true);
            for(Field sField:sFields){
                if(tField.getName().equals(sField.getName())){
                    sField.setAccessible(true);
                    setValue(tClazz,target,tField.getName(),sField.get(source));
                }
            }
        }
    }
    private static void setValue(Class<?> clazz,Object obj,String fieldName,Object val) throws NoSuchFieldException, IllegalAccessException, ParseException {

        String value = "";
        if(val != null) value = val.toString();

        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);

        if(val == null){
//            field.set(obj, null);
            return;
        }

        Class<?> type = field.getType();
        if(StringUtils.isNotBlank(value)){
            if(type.equals(Integer.class))
                field.set(obj, Integer.valueOf(value));
            else if(type.equals(Double.class))
                field.set(obj, Double.valueOf(value));
            else if(type.equals(Float.class))
                field.set(obj, Float.valueOf(value));
            else if(type.equals(Character.class))
                field.set(obj, Character.valueOf(value.charAt(0)));
            else if(type.equals(Date.class)){
                if(value!=null && !value.equals("")){
                    String format = value.length()==10?"yyyy-MM-dd":"yyyy-MM-dd HH:mm:ss";
                    SimpleDateFormat sdf = new SimpleDateFormat(format);
                    field.set(obj,sdf.parse(value));
                }
            }else if(type.equals(String.class))
                field.set(obj, value);
            else if(type.equals(Long.class))
                field.set(obj, Long.valueOf(value));
            else if(type.equals(Boolean.class))
                field.set(obj, (Boolean)val);
//            else
//                throw new GaiayException("===========request参数类型绑定错误!");
        }else{
            if(type.equals(String.class))
                field.set(obj, value);
        }
    }

    /**
     * 获取对象obj中的所有属性
     * @param obj
     * @return
     * @throws ClassNotFoundException
     */
    public static List<String> getProperties(Object obj) throws ClassNotFoundException{
        Class<?> clazz = Class.forName(obj.getClass().getName());
        Field[] fields = clazz.getDeclaredFields();
        List<String> list = new ArrayList<String>();
        for(Field f:fields){
            list.add(f.getName());
        }
        return list;
    }
    /**
     * 获取对象obj中name属性的值
     * @param obj
     * @param name
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    @SuppressWarnings("unchecked")
    public static <T> T getValue(Object obj,String name) throws Exception{
        Class<?> clazz = Class.forName(obj.getClass().getName());
        Field[] fields = clazz.getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            if(field.getName().equals(name))
                return (T) field.get(obj);
        }
        /**如果字段不存在，则根据get方法获取**/
        String firstLetter = name.substring(0,1).toUpperCase();
        String getMethodName = "get"+firstLetter+name.substring(1);

        Method getMethod = clazz.getMethod(getMethodName, new Class[] {});
        return (T) getMethod.invoke(obj, new Object[] {});
    }

    /**
     * 给对象obj中的filedName字段赋值
     * @param obj
     * @param fieldName
     * @param filedValue
     * @throws Exception
     */
    public static void setValue(Object obj,String fieldName,Object filedValue) throws Exception{
        Class<?> clazz = Class.forName(obj.getClass().getName());
        try{
            setValue(clazz,obj,fieldName,filedValue);
        }catch(NoSuchFieldException e){
            setValue(clazz.getSuperclass(),obj,fieldName,filedValue);
        }
    }

    /**
     * 获取对象obj中所有属性及其值
     * @param obj
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static Map<String,Object> getPropertiesAndValues(Object obj) throws ClassNotFoundException,IllegalArgumentException,IllegalAccessException{
        Class<?> clazz = Class.forName(obj.getClass().getName());
        Field[] fields = clazz.getDeclaredFields();
        Map<String,Object> map = new HashMap<String,Object>();
        for(Field f:fields){
            f.setAccessible(true);
            map.put(f.getName(), f.get(obj));
        }
        return map;
    }
}
