package com.auth.json.utils;

import com.alibaba.fastjson.util.ParameterizedTypeImpl;

import java.lang.reflect.Type;

/**
 * @description:
 * @author: zhangyu
 * @Date: 2021/6/10 3:05 下午
 */
public class JsonParseUtil {

    /**
     * @description:
     *
     * 使用示例：
     * Result<List<SearchConditionvo>> resultA = JSON.parseObject(s, buildType(Result.class,List.class,SearchConditionvo.class));
     *
     * 原理：
     *     private static <T> ResponseEntity<Result<List<T>>> parseListResult(String json, Class<T> clazz) {
     *         ParameterizedTypeImpl inner = new ParameterizedTypeImpl(new Type[]{clazz}, null, List.class);
     *         ParameterizedTypeImpl outer = new ParameterizedTypeImpl(new Type[]{inner}, null, Result.class);
     *         ParameterizedTypeImpl outer1 = new ParameterizedTypeImpl(new Type[]{outer}, null, ResponseEntity.class);
     *         return JSON.parseObject(json, outer1);
     *     }
     * @author: zhangyu122
     * @date: 2021/6/10 3:07 下午
     */
    public static Type buildType(Type... types) {
        ParameterizedTypeImpl beforeType = null;
        if (types == null || types.length <= 0) {
            return null;
        }
        for (int i = types.length - 1; i > 0; i--) {
            beforeType = new ParameterizedTypeImpl(new Type[]{beforeType == null ? types[i] : beforeType}, null, types[i - 1]);
        }
        return beforeType;
    }

}
