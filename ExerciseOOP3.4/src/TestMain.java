public class TestMain
{
    public static void main(String[] args) {
        MyTime time = new MyTime(23, 59, 59);
        System.out.println("Current Time: " + time);
        System.out.println("Next Second: " + time.nextSecond());
        System.out.println("Next Minute: " + time.nextMinute());
        System.out.println("Next Hour: " + time.nextHour());

        System.out.println("Previous Second: " + time.previousSecond());
        System.out.println("Previous Minute: " + time.previousMinute());
        System.out.println("Previous Hour: " + time.previousHour());
    }
}
