
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
   private String Range;
   
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
             Range = " A.M.";
             DisplayValue();
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
             if (nHour>12){
                 Range = " P.M";
                }
                else{
                    Range = " A.M";
                }
             minute = new NumberDisplay(59);
             hour.setValue(nHour);
             minute.setValue(nMinute);
            }
        }
       
   /*
    * Creamos un método que nos permite cambiar la hora del reloj y la rectifica al format
    * correcto si el formato de reloj seleccionado es "medio"(12horas)
    */
   public void setTime (int nHour, int nMinute)
   {
           if (tipe == "simple")
           {
               hour.setValue(nHour);
               minute.setValue(nMinute);
               DisplayValue();
            }
            else
            {
                if (nHour>=12)
               {
                   hour.setValue(nHour - 12);
                   minute.setValue(nMinute);
                   Range = " P.M.";
                   DisplayValue();
                }
                else
                {
                    hour.setValue(nHour);
                    minute.setValue(nMinute);
                    Range = " A.M.";
                    DisplayValue();
                }
            }
       
    }
    /*
     * Creamos el metodo que hace pasar la hora un minuto de tal forma que si el 
     * modo de reloj seleccionado es simple la hora llegue a las 23:59 y pase a 
     * 00:00 y si el modo del reloj es "Medio" (formato 12h) cuando las horas llegan
     * a 12 el rango entre AM y PM cambia si no, el funcionamiento del reloj es normal
     */
   public void timeTick()
   {
      if (tipe == "simple"){
          if (minute.getValue() == minute.getLimit())
          {
              hour.increment();
              minute.increment();
              DisplayValue();
            }
            else
            {
                minute.increment();
                DisplayValue();
            }
        }
        else{
            if (minute.getValue() == minute.getLimit()){
                if (hour.getValue() == hour.getLimit()){
                    if (Range == "A.M."){
                        hour.increment();
                        minute.increment();
                        Range = " P.M.";
                        DisplayValue();
                    }
                    else{
                        hour.increment();
                        minute.increment();
                        Range = " A.M.";
                        DisplayValue();
                    }
                }
                else{
                    hour.increment();
                    minute.increment();
                    DisplayValue();
                }
            }
            else{
                minute.increment();
                DisplayValue();
            }
                
        }
    }
    /*
     * Metodo que devuelve la hora actual dependiendo del formato, en caso de ser 
     * formato "medio" añade el rango adecuado al final (AM o PM)
     */
    public String getTime()
    {
        if (tipe == "simple"){     
            DisplayValue();
            return seeHour;
        }
        else{
            String TotalDisplay;
            TotalDisplay = seeHour + Range;
            return TotalDisplay;
        }
    }
    
    /*
     * 
     */
    private void DisplayValue()
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
    }
}
