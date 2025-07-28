public class Teste {

    public static void main(String[] args) {        
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE); 

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("password", ""); //put when you got your password here.....
        editor.commit();

        // Removed unused and useless assignment to local variable "password"
        // If you need to use the password, assign it to a variable and use it accordingly
        // String password = sharedPref.getString("password", "noPass");
    }
}