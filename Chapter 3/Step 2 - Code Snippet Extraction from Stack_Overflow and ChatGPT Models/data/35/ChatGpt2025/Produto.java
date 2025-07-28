
import java.util.List;

@Entity
public class Produto {
    @Id
    @GeneratedValue
    private Long id;

    @ElementCollection
    private List<String> tags; // ou String[] tags;

    // getters e setters
}
