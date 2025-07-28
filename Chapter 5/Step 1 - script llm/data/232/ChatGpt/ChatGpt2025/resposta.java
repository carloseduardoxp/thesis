public class Teste {
  public void main() {
    Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    Constructor<T> constructor = clazz.getDeclaredConstructor();
    constructor.newInstance();
  }

  public static <T> MyGenericClass<T> createInstance(Class<T> clazz) throws InstantiationException, IllegalAccessException {
    return new MyGenericClass<>(clazz.newInstance());
  }
}