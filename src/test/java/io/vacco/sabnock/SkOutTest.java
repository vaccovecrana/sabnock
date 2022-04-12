package io.vacco.sabnock;

import com.google.gson.GsonBuilder;
import j8spec.junit.J8SpecRunner;
import org.junit.runner.RunWith;

import java.io.FileWriter;

import static j8spec.J8Spec.*;
import static io.vacco.sabnock.SkJson.*;

@RunWith(J8SpecRunner.class)
public class SkOutTest {
  static {
    it("Builds and serializes a JSON object", () -> {
      var o = obj(
          kv("name", "molten-json"),
          kv("version", "0.1.0"),
          kv("description", "A fluent Java 8 DSL for working with JSON."),
          kv("repository", obj(
              kv("type", "git"),
              kv("url", "https://github.com/helpermethod/molten-json")
          )),
          kv("keywords", new String[] { "json", "java8", "fluent", "dsl" }),
          kv("author", "helpermethod"),
          kv("license", "Apache 2"),
          kv("bugs", obj(
              kv("url", "https://github.com/helpermethod/molten-json/issues")
          ))
      );

      var g = new GsonBuilder().setPrettyPrinting().create();
      var out = (SkOut.SkString) g::toJson;
      var fOut = (SkOut.SkAppendable) g::toJson;
      var fw = new FileWriter("./build/out.json");

      System.out.println(out.toJson(o));
      fOut.toJson(o, fw);
      fw.close();

      new SkOut();
      new SkJson();
    });
  }
}
