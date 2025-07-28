public class MenuSppaj extends Activity {

    public static final Context context;

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
