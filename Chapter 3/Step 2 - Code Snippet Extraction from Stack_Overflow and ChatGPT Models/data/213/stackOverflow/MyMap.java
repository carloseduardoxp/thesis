
import java.io.Serializable;
import java.util.LinkedHashMap;

public class MyMap extends LinkedHashMap<String, Serializable>
{
    @Override
    public Serializable get(Object key)
    {
        return null;
    }
}
