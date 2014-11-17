
/**
 * Write a description of class ClockDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClockDisplay
{
   private NumberDisplay hour;
   private NumberDisplay minute;
   private String tipe;
   private String seeHour;
   
   public ClockDisplay(String nTipe)
   {
       tipe = nTipe;
       if(nTipe == "simple"){
            hour = new NumberDisplay(23);
            minute = new NumberDisplay(59);
        }
        else if (nTipe == "medio")
        {
             hour = new NumberDisplay(11);
             minute = new NumberDisplay(59);
            }
   }
   public ClockDisplay (int nHour, int nMinute, String nTipe)
   {
       tipe = nTipe;
       if(nTipe == "simple"){
            hour = new NumberDisplay(23);
            minute = new NumberDisplay(59);
            hour.setValue(nHour);
            minute.setValue(nMinute);
        }
        else if (nTipe == "medio")
        {
             hour = new NumberDisplay(11);
             minute = new NumberDisplay(59);
             hour.setValue(nHour);
             minute.setValue(nMinute);
            }
        }
       
   
   public void setTime (int nHour, int nMinute)
   {
           if (tipe == "simple")
           {
               hour.setValue(nHour);
               minute.setValue(nMinute);
               
            }
            else
            {
                if (nHour>=12)
               {
                   hour.setValue(nHour - 12);
                   minute.setValue(nMinute);
                }
                else
                {
                    hour.setValue(nHour);
                    minute.setValue(nMinute);
                }
            }
       
    }
   public void timeTick()
   {
       if (minute.getValue() == minute.getLimit())
       {
           hour.increment();
           minute.increment();
        }
        else
        {
            minute.increment();
        }
    }
    public String getTime()
    {
        String time;
        if ((hour.getValue() < 10) & (minute.getValue() < 10))
        {
            time = "0" + hour.getValue() + ":0" + minute.getValue();
        }
        else
        {
            if ((hour.getValue() < 10) & (minute.getValue() > 10))
            {
                time = "0" + hour.getValue() + ":" + minute.getValue();
            }
            else
            {
                if ((hour.getValue() > 10) & (minute.getValue() < 10))
                {
                    time = hour.getValue() + ":0" + minute.getValue();
                }
                else
                {
                    time = "" + hour.getValue() + ":" + minute.getValue();
                }
            }
        }
        seeHour = time;
        return time;
    }
    public String setTipe()
    {
        return tipe;
    }
    public int setHourLimit()
    {
        return hour.getLimit();
    }
}
