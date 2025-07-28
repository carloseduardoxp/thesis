public class Foo {

    private Foo(Builder builder) {
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