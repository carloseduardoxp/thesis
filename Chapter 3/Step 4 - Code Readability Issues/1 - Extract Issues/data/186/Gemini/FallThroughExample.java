public class FallThroughExample {
    public static void main(String[] args) {
        int day = 3;
        String dayType;

        switch (day) {
            case 1:
            case 2:
            case 3:
                dayType = "Weekday"; // No break here!
            case 4:
                System.out.println("This will execute for day 1, 2, 3, and 4 if day is 3");
            case 5:
                dayType = "Another Weekday"; // This will be assigned if day is 3 or 4
                break; // This break will stop execution here if day is 3, 4, or 5
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
