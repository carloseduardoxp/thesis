
public class Menu_SPPAJ extends Activity {

    public static Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //TODO write your onCreate code
        context = this;
    }

    public static void onRefreshList() {
        model.requery();
        list_terbaru.setAdapter(new Adapter_Spaj_Terbaru(((Activity) context), model));
    }
}
