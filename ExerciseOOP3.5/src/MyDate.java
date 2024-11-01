public class MyDate
{
    private int year, month, day;
    public static final String[] MONTHS = {"Jan", "Feb", "Mar","Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public static final int[] DAYS_IN_MONTHS= {31, 28, 31, 30, 31,30, 31, 31, 30, 31,30, 31};

    public MyDate(int year, int month, int day) {
        if (isValidDate(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            System.out.println("Invalid date.");
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean isValidDate(int year, int month, int day) {
        if (year < 1 || month < 1 || month > 12 || day < 1) {
            return false;
        }
        int maxDays = DAYS_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) {
            maxDays = 29;
        }
        return day <= maxDays;
    }

    public static int getDayOfWeek(int year, int month, int day) {
        if (month < 3) {
            month += 12;
            year -= 1;
        }
        int k = year % 100;
        int j = year / 100;
        int h = (day + (13 * (month + 1)) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;
        return (h + 6) % 7;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        if (isValidDate(year, month, day)) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid date.");
        }
    }

    public void setMonth(int month) {
        if (isValidDate(year, month, day)) {
            this.month = month;
        } else {
            System.out.println("Invalid date.");
        }
    }

    public void setDay(int day) {
        if (isValidDate(year, month, day)) {
            this.day = day;
        } else {
            System.out.println("Invalid date.");
        }
    }

    public void setDate(int year, int month, int day) {
        if (isValidDate(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            System.out.println("Invalid date.");
        }
    }

    public MyDate nextDay() {
        if (isValidDate(year, month, day + 1)) {
            day++;
        } else if (month < 12) {
            month++;
            day = 1;
        } else {
            year++;
            month = 1;
            day = 1;
        }
        return this;
    }

    public MyDate nextMonth() {
        if (month < 12) {
            month++;
            if (day > DAYS_IN_MONTHS[month - 1]) {
                day = DAYS_IN_MONTHS[month - 1];
            }
        } else {
            year++;
            month = 1;
        }
        return this;
    }

    public MyDate nextYear() {
        year++;
        if (month == 2 && day == 29 && !isLeapYear(year)) {
            day = 28;
        }
        return this;
    }

    public MyDate previousDay() {
        if (day > 1) {
            day--;
        } else if (month > 1) {
            month--;
            day = DAYS_IN_MONTHS[month - 1];
            if (month == 2 && isLeapYear(year)) {
                day = 29;
            }
        } else {
            year--;
            month = 12;
            day = 31;
        }
        return this;
    }

    public MyDate previousMonth() {
        if (month > 1) {
            month--;
            if (day > DAYS_IN_MONTHS[month - 1]) {
                day = DAYS_IN_MONTHS[month - 1];
            }
        } else {
            year--;
            month = 12;
        }
        return this;
    }

    public MyDate previousYear() {
        year--;
        if (month == 2 && day == 29 && !isLeapYear(year)) {
            day = 28;
        }
        return this;
    }

    @Override
    public String toString() {
        int dayOfWeek = getDayOfWeek(year, month, day);
        return String.format("%s %d %s %d", DAYS[dayOfWeek], day, MONTHS[month-1], year);
    }
}