public class Teste {
    
    @ManagedBean
    @RequestScoped
    public class TestBean {
    
      @ManagedProperty(value = "#{param.id}")
      private String id;

    }
}