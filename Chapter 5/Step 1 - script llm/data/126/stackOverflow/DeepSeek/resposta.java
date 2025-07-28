public class Teste {

    public static void main(String[] args) {        
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE); 

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("password", ""); //put when you got your password here.....
        editor.commit();

        sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        sharedPref.getString("password", "noPass");
    }
}
