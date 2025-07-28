
import java.util.*;

public class AccountChangeEvent {
  private int userId;
  private String changeType;
  private Object newValue;

  // constructor, getters and setters
}

interface AccountChangeListener {
  void onAccountChange(AccountChangeEvent event);
}

class Account {
  private int id;
  private String name;
  private List<AccountChangeListener> listeners = new ArrayList<>();

  public void addListener(AccountChangeListener listener) {
      listeners.add(listener);
  }

  public void removeListener(AccountChangeListener listener) {
      listeners.remove(listener);
  }

  public void setName(String name) {
      this.name = name;
      AccountChangeEvent event = new AccountChangeEvent(id, "name", name);
      notifyListeners(event);
  }

  private void notifyListeners(AccountChangeEvent event) {
      for(AccountChangeListener listener : listeners) {
          listener.onAccountChange(event);
      }
  }
}

class Teste {
  public static void main(String[] args) {
    Account account = new Account(1, "John");
    AccountChangeListener listener = new AccountChangeListener() {
        @Override
        public void onAccountChange(AccountChangeEvent event) {
            System.out.println("Account #" + event.getUserId() + " changed " + event.getChangeType() + " to " + event.getNewValue());
        }
    };
    account.addListener(listener);
    account.setName("Jane");

  }
}