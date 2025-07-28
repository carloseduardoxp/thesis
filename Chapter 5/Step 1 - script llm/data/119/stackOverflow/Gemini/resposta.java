public class MenuSppaj extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //TODO write your onCreate code
    }

    public void onRefreshList() {
        model.requery();
        list_terbaru.setAdapter(new Adapter_Spaj_Terbaru(this, model));
    }
}
