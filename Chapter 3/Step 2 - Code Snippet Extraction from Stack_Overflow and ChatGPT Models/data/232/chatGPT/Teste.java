public class Teste {
  public void main() {
    Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    T instance = clazz.newInstance();

    Constructor<T> constructor = clazz.getDeclaredConstructor();
    T instance = constructor.newInstance();

  }

  public static <T> MyGenericClass<T> createInstance(Class<T> clazz) throws InstantiationException, IllegalAccessException {
    T instance = clazz.newInstance();
    return new MyGenericClass<T>(instance);
  }

}
