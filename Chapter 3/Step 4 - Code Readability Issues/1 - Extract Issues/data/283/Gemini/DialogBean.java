import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

@Named
@ViewScoped
public class DialogBean implements Serializable {

    private String param1;
    private String param2;

    @PostConstruct
    public void init() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        param1 = params.get("param1");
        param2 = params.get("param2");
        System.out.println("Received param1: " + param1);
        System.out.println("Received param2: " + param2);
    }

    // Getters and setters for param1, param2
    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }
}
