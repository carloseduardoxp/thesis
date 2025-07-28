my.array=apple,banana,cherry,orange
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    @Value("${my.array}")
    private String[] myArray;

    public void printArray() {
        for (String item : myArray) {
            System.out.println(item);
        }
    }
}

@Controller
class MyController {

    @Autowired
    private MyBean myBean;

    @RequestMapping("/showArray")
    public String showArray() {
        myBean.printArray();
        return "arrayView"; // A view to render the result
    }
}
