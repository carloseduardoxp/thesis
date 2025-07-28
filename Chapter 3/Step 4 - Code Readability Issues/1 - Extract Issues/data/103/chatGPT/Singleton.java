public class Singleton {
    private static volatile Singleton instance;
    
    private Singleton() {
      // Private constructor to prevent instantiation from outside the class
    }
    
    public static Singleton getInstance() {
      if (instance == null) {
        synchronized (Singleton.class) {
          if (instance == null) {
            instance = new Singleton();
          }
        }
      }
      return instance;
    }
  }
  