# sabnock

[sabnock](https://en.wikipedia.org/wiki/List_of_demons_in_the_Ars_Goetia) is a minimal DSL for building JSON documents.

Available in Maven Central:

```
dependencies {
  implementation("io.vacco.sabnock:sabnock:<VERSION>")
}
```

## Example

```java
public class Example {
  public static void main() {
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

    System.out.println(out.toJson(o));
  }
}
```

Output:

```
{
  "name": "molten-json",
  "version": "0.1.0",
  "description": "A fluent Java 8 DSL for working with JSON.",
  "repository": {
    "type": "git",
    "url": "https://github.com/helpermethod/molten-json"
  },
  "keywords": [
    "json",
    "java8",
    "fluent",
    "dsl"
  ],
  "author": "helpermethod",
  "license": "Apache 2",
  "bugs": {
    "url": "https://github.com/helpermethod/molten-json/issues"
  }
}
```
