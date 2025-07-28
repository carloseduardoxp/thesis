import javax.naming.Context;
import javax.swing.Box;

public class Teste {

    @Override
    public void onAsyncOperationCompleted(AsyncOperation operation) {
        if (operation.getType() == LoadAll) {
            itemsList = BoxRepository.getAllBoxes(getApplicationContext());
        }
    }
}

class BoxRepository {

    public static void getAllBoxes(AsyncOperationListener listener) {
        AsyncSession asyncSession = App.getInstance().daoSession.startAsyncSession();
        asyncSession.setListener(listener);
        asyncSession.loadAll(Box.class);
    }

}