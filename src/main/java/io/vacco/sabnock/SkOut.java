package io.vacco.sabnock;

public class SkOut {

  public interface SkString {
    String toJson(Object src);
  }

  public interface SkAppendable {
    void toJson(Object src, Appendable w);
  }

}
