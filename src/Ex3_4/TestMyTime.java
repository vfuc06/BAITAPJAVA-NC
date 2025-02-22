package Ex3_4;
public class TestMyTime {
    public static void main(String[] args) {
        MyTime time = new MyTime(14, 1, 9);
        System.out.println("Current time: " + time);

        time.nextSecond();
        System.out.println("Next second: " + time);
        time.nextMinute();
        System.out.println("Next minute: " + time);

        time.nextHour();
        System.out.println("Next hour: " + time);
        time.previousSecond();
        System.out.println("Previous second: " + time);
        time.previousMinute();
        System.out.println("Previous minute: " + time);
        time.previousHour();
        System.out.println("Previous hour: " + time);
        time.setTime(23, 59, 59);
        System.out.println("Time set to: " + time);
    }
}
