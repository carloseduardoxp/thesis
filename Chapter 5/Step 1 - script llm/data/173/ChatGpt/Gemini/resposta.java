import java.util.ArrayList;
import java.util.List;

public class AccountChangeEvent {
  private final int userId;
  private final String changeType;
  private final Object newValue;

  public AccountChangeEvent(int userId, String changeType, Object newValue) {
    this.userId = userId;
    this.changeType = changeType;
    this.newValue = newValue;
  }

  public int getUserId() {
    return userId;
  }

  public String getChangeType() {
    return changeType;
  }

  public Object getNewValue() {
    return newValue;
  }
}

interface AccountChangeListener {
  void onAccountChange(AccountChangeEvent event);
}

class Account {
  private final int id;
  private final List<AccountChangeListener> listeners = new ArrayList<>();

  public Account(int id) {
    this.id = id;
  }

  public void addListener(AccountChangeListener listener) {
    listeners.add(listener);
  }

  public void removeListener(AccountChangeListener listener) {
    listeners.remove(listener);
  }

  public void setName(String name) {
    AccountChangeEvent event = new AccountChangeEvent(id, "name", name);
    notifyListeners(event);
  }

  private void notifyListeners(AccountChangeEvent event) {
    for (AccountChangeListener listener : listeners) {
      listener.onAccountChange(event);
    }
  }
}

class Teste {
  public static void main(String[] args) {
    Account account = new Account(1);
    AccountChangeListener listener = event -> System.out.println(
        "Account #" + event.getUserId() + " changed " + event.getChangeType() + " to "
            + event.getNewValue());
    account.addListener(listener);
    account.setName("Jane");
  }
}