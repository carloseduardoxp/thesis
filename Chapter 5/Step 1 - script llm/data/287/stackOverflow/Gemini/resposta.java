public class Foo {
    private final String param1;
    private final String param2;

    private Foo(Builder builder) {
      this.param1 = builder.param1;
      this.param2 = builder.param2;
    }

    public String getParam1() {
      return param1;
    }

    public String getParam2() {
      return param2;
    }

    public static class Builder {
      private String param1 = "defaultParam1";
      private String param2 = "defaultParam2";

      public Builder param1(String param1) {
        this.param1 = param1;
        return this;
      }

      public Builder param2(String param2) {
        this.param2 = param2;
        return this;
      }

      public Foo build() {
        return new Foo(this);
      }
    }
  }
