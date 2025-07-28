
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
import java.util.Map;

@Named
@RequestScoped
public class DialogBean {

    private String param1;
    private String param2;

    @PostConstruct
    public void init() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        param1 = params.get("param1");
        param2 = params.get("param2");
    }

    // getters and setters
}
