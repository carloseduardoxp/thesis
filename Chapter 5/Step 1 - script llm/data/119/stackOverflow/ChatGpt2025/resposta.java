public class MenuSppaj extends Activity {

    public static final Context CONTEXT = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //TODO write your onCreate code
        // CONTEXT cannot be assigned here as it is final and initialized to null
    }

    public static void onRefreshList() {
        model.requery();
        list_terbaru.setAdapter(new Adapter_Spaj_Terbaru(((Activity) CONTEXT), model));
    }
}