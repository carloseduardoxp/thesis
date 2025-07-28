import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class CalculatorService {
    
    @WebMethod
    public double add(double num1, double num2) {
        return num1 + num2;
    }
    
    @WebMethod
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }
}
