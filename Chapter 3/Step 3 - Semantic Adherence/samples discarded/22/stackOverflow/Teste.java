import java.util.Scanner;

class newClass {
    
    @OneToMany(mappedBy="parent", fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Child> childs;
}