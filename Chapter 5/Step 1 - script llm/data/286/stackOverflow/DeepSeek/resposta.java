public class Immutable {
  private final int val;
  public Immutable(int val) {
    this.val = val;
  }

  public int getVal() {
    return val;
  }
}

class FakeImmutable extends Immutable {
  private int val2;
  public FakeImmutable(int val) {
    super(val);
  }

  @Override
  public int getVal() {
    return val2;
  }

  public void setVal(int val2) {
    this.val2 = val2;
  }
}
