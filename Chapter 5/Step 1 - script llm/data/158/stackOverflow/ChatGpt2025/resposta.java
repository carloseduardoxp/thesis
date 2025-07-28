import java.util.Base64;

import javax.naming.Context;

public class Teste {

    public static void main(String[] args) {  
        Intent intent = new Intent(new Intent(new String(Base64.decode("Y29tLmFuZHJvaWQudmVuZGluZy5saWNlbnNpbmcuSUxpY2Vuc2luZ1NlcnZpY2U="))));
        intent.setPackage("com.android.vending");
        mContext.bindService(
                intent,
                this, // ServiceConnection.
                Context.BIND_AUTO_CREATE);
    }
}