public class FallThroughExample {
    public static void main(String[] args) {
        int day = 3;
        String dayType;

        switch (day) {
            case 1:
            case 2:
            case 3:
                System.out.println("This will execute for day 1, 2, 3, and 4 if day is 3");
                dayType = "Another Weekday";
                break;
            case 4:
                System.out.println("This will execute for day 1, 2, 3, and 4 if day is 3");
                dayType = "Another Weekday";
                break;
            case 5:
                dayType = "Another Weekday";
                break;
            case 6:
            case 7:
                dayType = "Weekend";
                break;
            default:
                dayType = "Invalid day";
        }
        System.out.println("Day type: " + dayType);
    }
}