
public class DeepSeek {

    public static void main(String[] args) {

        String day = "Monday";

        switch (day) {
            case "Monday":
                System.out.println("Start of the work week");
                break;
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
                System.out.println("Midweek days");
                break;
            case "Friday":
                System.out.println("Almost weekend");
                break;
            case "Saturday":
            case "Sunday":
                System.out.println("Weekend!");
                break;
            default:
                System.out.println("Invalid day");
        }

    }

}
