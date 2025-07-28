public class FallThroughExample {
    public static void main(String[] args) {
        int day = 3;
        String dayType;

        switch (day) {
            case 1:
            case 2:
            case 3:
            case 4:
                System.out.println("This is one of the first four weekdays.");
                dayType = "Weekday";
                break;
            case 5:
                dayType = "Weekday";
                break;
            case 6:
            case 7:
                dayType = "Weekend";
                break;
            default:
                dayType = "Invalid day";
                break;
        }
        System.out.println("Day type: " + dayType);
    }
}
