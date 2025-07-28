import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyBean {

    @Value("#{'${my.array}'.split(',')}")
    private String[] fruitsArray;

    @Value("#{'${another.array}'.split(',').map(T(Integer).parseInt)}")
    private Integer[] numbersArray;

    @Value("#{'${my.array}'.split(',')}")
    private List<String> fruitsList;

    @Value("#{'${another.array}'.split(',').map(T(Integer).parseInt).toList()}")
    private List<Integer> numbersList;

    public String[] getFruitsArray() {
        return fruitsArray;
    }

    public Integer[] getNumbersArray() {
        return numbersArray;
    }

    public List<String> getFruitsList() {
        return fruitsList;
    }

    public List<Integer> getNumbersList() {
        return numbersList;
    }

    // ... other methods
}
