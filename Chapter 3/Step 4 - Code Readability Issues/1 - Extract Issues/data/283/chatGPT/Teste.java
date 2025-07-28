
public class Teste {

    public static void main(String[] args) {
        String url = "dialog.xhtml?param1=value1&param2=value2";
        String windowOptions = "height=200,width=200";
        String windowFeatures = "resizable=yes,scrollbars=yes";

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("param1", "value1");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("param2", "value2");
        PrimeFaces.current().executeScript("window.open('" + url + "', '', '" + windowOptions + "', '" + windowFeatures + "');");

        FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("param1");

    }
}
