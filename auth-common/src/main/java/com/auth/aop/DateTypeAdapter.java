package com.auth.aop;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateTypeAdapter extends TypeAdapter<Date> {

  public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
      return typeToken.getRawType() == Date.class ? (TypeAdapter<T>) new DateTypeAdapter() : null;
    }
  };
  private final ThreadLocal<DateFormat> enUsFormat = new ThreadLocal<DateFormat>() {
    @Override
    protected DateFormat initialValue() {
      return DateFormat.getDateTimeInstance(2, 2, Locale.US);
    }
  };
  private final ThreadLocal<DateFormat> localFormat = new ThreadLocal<DateFormat>() {
    @Override
    protected DateFormat initialValue() {
      return DateFormat.getDateTimeInstance(2, 2);
    }
  };
  private final ThreadLocal<DateFormat> iso8601Format = new ThreadLocal<DateFormat>() {
    @Override
    protected DateFormat initialValue() {
      return DateTypeAdapter.buildIso8601Format();
    }
  };

  public DateTypeAdapter() {
  }

  private static DateFormat buildIso8601Format() {
    DateFormat iso8601Format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
    iso8601Format.setTimeZone(TimeZone.getTimeZone("UTC"));
    return iso8601Format;
  }

  @Override
  public Date read(JsonReader in) throws IOException {
    if (in.peek() == JsonToken.NULL) {
      in.nextNull();
      return null;
    } else {
      return this.deserializeToDate(in.nextString());
    }
  }

  private Date deserializeToDate(String json) {
    try {
      return ((DateFormat)this.localFormat.get()).parse(json);
    } catch (ParseException var5) {
      try {
        return ((DateFormat)this.enUsFormat.get()).parse(json);
      } catch (ParseException var4) {
        try {
          return ((DateFormat)this.iso8601Format.get()).parse(json);
        } catch (ParseException var3) {
          throw new JsonSyntaxException(json, var3);
        }
      }
    }
  }

  @Override
  public void write(JsonWriter out, Date value) throws IOException {
    if (value == null) {
      out.nullValue();
    } else {
      String dateFormatAsString = ((DateFormat)this.enUsFormat.get()).format(value);
      out.value(dateFormatAsString);
    }
  }
}
