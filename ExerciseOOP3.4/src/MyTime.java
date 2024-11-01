public class MyTime
{
    private int hour;
    private int minute;
    private int second;

    public MyTime()
    {
        this.hour=0;
        this.minute=0;
        this.second=0;
    }

    public MyTime(int hour, int minute, int second)
    {
        this.hour=hour;
        this.minute=minute;
        this.second=second;
    }

    public void setTime(int hour, int minute, int second)
    {
        this.hour=hour;
        this.minute=minute;
        this.second=second;
    }

    public int getHour()
    {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond()
    {
        return second;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public String toString()
    {
        String s;
        String s1;
        String s2;
        if(this.hour<10)
        {
            s="0"+this.hour;
        }else
        {
            s=this.hour+"";
        }
        if(this.minute<10)
        {
            s1="0"+this.minute;
        }else
        {
            s1=this.minute+"";
        }
        if(this.second<10)
        {
            s2="0"+this.second;
        }else
        {
            s2=this.second+"";
        }
        return s+":"+s1+":"+s2;
    }

    public MyTime nextSecond() {
        second++;
        if (second == 60) {
            second = 0;
            nextMinute();
        }
        return this;
    }

    public MyTime nextMinute() {
        minute++;
        if (minute == 60) {
            minute = 0;
            nextHour();
        }
        return this;
    }

    public MyTime nextHour() {
        hour++;
        if (hour == 24) {
            hour = 0;
        }
        return this;
    }

    public MyTime previousSecond() {
        second--;
        if (second < 0) {
            second = 59;
            previousMinute();
        }
        return this;
    }

    public MyTime previousMinute() {
        minute--;
        if (minute < 0) {
            minute = 59;
            previousHour();
        }
        return this;
    }

    public MyTime previousHour() {
        hour--;
        if (hour < 0) {
            hour = 23;
        }
        return this;
    }
}