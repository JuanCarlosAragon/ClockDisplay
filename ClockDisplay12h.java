/**
* The ClockDisplay class implements a digital clock display for a
* European-style 24 hour clock. The clock shows hours and minutes. The
* range of the clock is 00:00 (midnight) to 23:59 (one minute before
* midnight).
*
* The clock display receives "ticks" (via the timeTick method) every minute
* and reacts by incrementing the display. This is done in the usual clock
* fashion: the hour increments when the minutes roll over to zero.
*/
public class ClockDisplay12h
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private NumberDisplay years;
    private NumberDisplay month;
    private NumberDisplay day;
    private String displayString; // simulates the actual display
    private boolean estate;
    private String estateDisplay;
    /**
    * Constructor for ClockDisplay objects. This constructor
    * creates a new clock set at 00:00.
    */
   public ClockDisplay12h()
   {
       hours = new NumberDisplay(13);
       minutes = new NumberDisplay(60);
       years = new NumberDisplay(100);
       month = new NumberDisplay(13);
       day = new NumberDisplay(31);
       estate = true;
       setTime(12,0,14,11,21);
    }
 
    /**
    * Constructor for ClockDisplay objects. This constructor
    * creates a new clock set at the time specified by the
    * parameters.
    */
   public ClockDisplay12h(int hour, int minute, int nYear1, int nMonth1, int nDay1)
   {
       hours = new NumberDisplay(13);
       minutes = new NumberDisplay(60);
       years = new NumberDisplay(100);
       month = new NumberDisplay(13);
       day = new NumberDisplay(31);
       
       estate = true;
       setTime(hour, minute, nYear1, nMonth1, nDay1);
    }
 
    /**
    * This method should get called once every minute - it makes
    * the clock display go one minute forward.
    */
   public void timeTick()
   {
       minutes.increment();
       if(minutes.getValue() == 0) { // it just rolled over!
           hours.increment();
           if (hours.getValue() == 0){
               hours.setValue(1);
            }
            if (hours.getValue() == 12){
                estate = !estate;
                if (estate = true){
                    changeDay();
                }
            }

        }
       
       
        updateDisplay();
    }
    //Metodo que hace correr la fecha un día
    private void changeDay(){
        day.increment();
        if (day.getValue() == 0){
            day.setValue(1);
        }
        if(day.getValue() == 1){
            month.increment();
            if(month.getValue() == 0){
                month.setValue(1);
            }
            if(month.getValue() == 1){
                years.increment();
            }
        }
    }
 
    /**
    * Set the time of the display to the specified hour and
    * minute.
    */
   public void setTime(int hour, int minute, int nYear, int nMonth, int nDay)
   {
       hours.setValue(numericControl(hour));
       minutes.setValue(minute);
       years.setValue(nYear);
       month.setValue(nMonth);
       day.setValue(nDay);
       updateDisplay();
    }
 
    /**
    * Return the current time of this display in the format HH:MM.
    */
   public String getTime()
   {
       return displayString;
    }
    /**
    * Update the internal string that represents the display.
    */
   private void updateDisplay()
   {
        if (estate == true){
            estateDisplay = " a.m.";
        }
        else{
            estateDisplay = " p.m.";
        }
        
       displayString = hours.getDisplayValue() + ":" +
       minutes.getDisplayValue() + estateDisplay + " " + day.getDisplayValue() + "/" + month.getDisplayValue() + "/" + "20" + years.getDisplayValue();
    }
    private int numericControl(int n1){
        if (n1>12){
            n1 = n1 - 12;
            estate = false;
        }
        return n1;
    }
} 