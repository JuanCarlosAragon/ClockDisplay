
/**
 * Write a description of class NumberDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NumberDisplay
{
    private int value;
    private int limit;
    
    public NumberDisplay (int nlimit)
    {
        value = 0;
        limit = nlimit;
    }
    
    public void setValue(int newValue)
    {
        if (newValue >= 0 & newValue <= limit)
        {
            value = newValue;
        }
        else
        {
            value = value;
        }
    }
   
    public int getValue()
    {
        return value;
    }
    public int getLimit()
    {
        return limit;
    }
    public void increment()
    {
        if (value < limit)
        {
            value = value + 1;
        }
        else
        {
            value = 0;
        }
    }
}
