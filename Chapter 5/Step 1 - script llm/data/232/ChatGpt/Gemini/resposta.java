import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;

public class Teste<T> {
  public void main() {
    Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    Constructor<T> constructor = clazz.getDeclaredConstructor();
  }

  public static <T> MyGenericClass<T> createInstance(Class<T> clazz) throws InstantiationException, IllegalAccessException {
    T instance = clazz.newInstance();
    return new MyGenericClass<>(instance);
  }

}
