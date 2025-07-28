import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class MyController {

    @Value("${myArray}")
    private String[] myArray;

    private final Environment environment;

    public MyController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/myarray")
    @ResponseBody
    public String getMyArray() {
        // use the myArray field directly
        return Arrays.toString(myArray);
    }

    @GetMapping("/myarray2")
    @ResponseBody
    public String getMyArray2() {
        // use the environment object to get the property value as a String
        String myArrayStr = environment.getProperty("myArray");
        String[] myArrayFromEnv = myArrayStr.split(",");
        return Arrays.toString(myArrayFromEnv);
    }
}
