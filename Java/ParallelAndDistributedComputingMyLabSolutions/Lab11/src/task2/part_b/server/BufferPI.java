package task2.part_b.server;

import java.util.HashMap;
import java.util.Map;

public class BufferPI
{
    private Map<String, Double> storedValues;

    public BufferPI()
    {
        storedValues = new HashMap<String, Double>();
    }

    public synchronized double searchValue(String key)
    {
        Double value = storedValues.get(key);

        if (value != null)
            return value;
        else
            return -1;
    }

    public synchronized void storeValue(String key, double value)
    {
        storedValues.put(key, value);
    }
}
