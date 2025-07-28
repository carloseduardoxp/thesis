public class Teste {
  public void main() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    Constructor<T> constructor = clazz.getDeclaredConstructor();
    T instance = constructor.newInstance();
  }

  public static <T> MyGenericClass<T> createInstance(Class<T> clazz) throws InstantiationException, IllegalAccessException {
    T instance = clazz.newInstance();
    return new MyGenericClass<>(instance);
  }
}
