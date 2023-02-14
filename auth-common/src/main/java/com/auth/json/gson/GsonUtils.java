package com.auth.json.gson;

import com.auth.aop.DateTypeAdapter;
import com.google.common.reflect.TypeToken;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;

/**
 * @author
 */
public class GsonUtils {

  private static final ThreadLocal<Gson> GSON_TL = ThreadLocal.withInitial(
      () -> (new GsonBuilder()).registerTypeAdapterFactory(DateTypeAdapter.FACTORY).create()
  );

  private static final ThreadLocal<Gson> GSON_UN_LINE = ThreadLocal.withInitial(
      () -> (new GsonBuilder()).setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
  );

  public static Object toObject(String json, Class clazz) {
    return GSON_TL.get().fromJson(json, clazz);
  }

  public static Object toObject(Object json) {
    return GSON_TL.get().fromJson(json.toString(), new TypeToken<List<?>>() {
    }.getType());
  }

  public static String toJson(Object object) {
    return ((Gson) GSON_TL.get()).toJson(object);
  }

  public static String toJsonUnLine(Object object) {
    return GSON_UN_LINE.get().toJson(object);
  }

  public static List<?> toJsonList(String json, TypeToken typeToken) {
    return new GsonBuilder().create().fromJson(json, typeToken.getType());
  }
}
