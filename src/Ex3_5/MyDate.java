package Ex3_5;
import java.util.Calendar;
public class MyDate {
        public static final String[] MONTHS = {
                "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        };

        public static final String[] DAYS = {
                "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
        };

        public static final int[] DAYS_IN_MONTH = {
                31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        private int year;
        private int month;
        private int day;

        public MyDate(int year, int month, int day) {
            setDate(year, month, day);
        }

        public static boolean isLeapYear(int year) {
            return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
        }

        public static boolean isValidDate(int year, int month, int day) {
            if (year < 1 || year > 9999 || month < 1 || month > 12) return false;
            int maxDays = DAYS_IN_MONTH[month - 1];
            if (month == 2 && isLeapYear(year)) maxDays = 29;
            return day >= 1 && day <= maxDays;
        }

        public static int getDayOfWeek(int year, int month, int day) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month - 1, day);
            return calendar.get(Calendar.DAY_OF_WEEK) - 1;
        }

        public void setDate(int year, int month, int day) {
            if (!isValidDate(year, month, day)) {
                throw new IllegalArgumentException("Invalid year, month, or day!");
            }
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public void setYear(int year) {
            if (year < 1 || year > 9999) {
                throw new IllegalArgumentException("Invalid year!");
            }
            this.year = year;
        }

        public void setMonth(int month) {
            if (month < 1 || month > 12) {
                throw new IllegalArgumentException("Invalid month!");
            }
            this.month = month;
        }

        public void setDay(int day) {
            int maxDays = DAYS_IN_MONTH[this.month - 1];
            if (this.month == 2 && isLeapYear(this.year)) maxDays = 29;
            if (day < 1 || day > maxDays) {
                throw new IllegalArgumentException("Invalid day!");
            }
            this.day = day;
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

        @Override
        public String toString() {
            int dayOfWeek = getDayOfWeek(year, month, day);
            return DAYS[dayOfWeek] + " " + day + " " + MONTHS[month - 1] + " " + year;
        }

        public MyDate nextDay() {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month - 1, day);
            calendar.add(Calendar.DATE, 1);
            return new MyDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
        }

        public MyDate nextMonth() {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month - 1, day);
            calendar.add(Calendar.MONTH, 1);
            return new MyDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
        }

        public MyDate nextYear() {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month - 1, day);
            calendar.add(Calendar.YEAR, 1);
            return new MyDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
        }

        public MyDate previousDay() {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month - 1, day);
            calendar.add(Calendar.DATE, -1);
            return new MyDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
        }

        public MyDate previousMonth() {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month - 1, day);
            calendar.add(Calendar.MONTH, -1);
            return new MyDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
        }

        public MyDate previousYear() {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month - 1, day);
            calendar.add(Calendar.YEAR, -1);
            return new MyDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
        }
}
