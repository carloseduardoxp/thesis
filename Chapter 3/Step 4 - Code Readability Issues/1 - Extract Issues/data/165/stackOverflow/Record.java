interface Value<T> {
    T getRawValue();
}

public class Record<T> {

    private Value<T> value;     

    T getRecordRawValue() {
        return value.getRawValue();
    }

}

