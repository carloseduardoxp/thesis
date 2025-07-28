public class StringSwitchExample {

    public static void main(String[] args) {

        String dayOfWeek = "Wednesday"; // The string to switch on

        switch (dayOfWeek) {
            case "Monday":
                System.out.println("It's the start of the work week.");
                break;
            case "Tuesday":
                System.out.println("Second day, still going strong.");
                break;
            case "Wednesday":
                System.out.println("Hump day! Almost there.");
                break;
            case "Thursday":
                System.out.println("Getting closer to the weekend.");
                break;
            case "Friday":
                System.out.println("TGIF! Weekend is here.");
                break;
            case "Saturday":
            case "Sunday":
                System.out.println("It's the weekend! Relax and enjoy.");
                break;
            default:
                System.out.println("That's not a valid day of the week.");
                break;
        }

        System.out.println("\nAnother example with different string values:");

        String command = "DELETE";

        switch (command) {
            case "CREATE":
                System.out.println("Executing CREATE operation.");
                break;
            case "READ":
                System.out.println("Executing READ operation.");
                break;
            case "UPDATE":
                System.out.println("Executing UPDATE operation.");
                break;
            case "DELETE":
                System.out.println("Executing DELETE operation.");
                break;
            default:
                System.out.println("Unknown command.");
                break;
        }
    }
}
