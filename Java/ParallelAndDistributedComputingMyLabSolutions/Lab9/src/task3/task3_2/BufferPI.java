package task3.task3_2;

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
            return storedValues.get(key);
        else
            return -1;
    }

    public synchronized void storeValue(String key, double value)
    {
        storedValues.put(key, value);
    }
}
