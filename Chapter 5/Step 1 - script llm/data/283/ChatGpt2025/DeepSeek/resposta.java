import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
import java.util.Map;

@Named
@RequestScoped
public class DialogBean {

    @PostConstruct
    public void init() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String param1 = params.get("param1");
        String param2 = params.get("param2");
    }
}
