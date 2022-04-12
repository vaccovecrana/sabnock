package io.vacco.sabnock;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class SkJson {

  public static <K, V> Map.Entry<K, V> kv(K key, V value) {
    return new AbstractMap.SimpleEntry<>(key, value);
  }

  public static <K, V> Map<K, V> mapOn(Stream<Map.Entry<K, V>> entries) {
    var m = new LinkedHashMap<K, V>();
    entries.forEach(e -> m.put(e.getKey(), e.getValue()));
    return m;
  }

  @SafeVarargs
  @SuppressWarnings("varargs")
  public static <K, V> Map<K, V> obj(Map.Entry<K, V> ... entries) {
    return mapOn(Arrays.stream(entries));
  }

}
