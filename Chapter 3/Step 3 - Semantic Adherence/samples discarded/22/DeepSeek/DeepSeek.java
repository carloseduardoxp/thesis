@Entity
public class Parent {
    @OneToMany(fetch = FetchType.LAZY)
    private List<ChildA> childrenA;
    
    @OneToMany(fetch = FetchType.LAZY)
    private List<ChildB> childrenB;
}
