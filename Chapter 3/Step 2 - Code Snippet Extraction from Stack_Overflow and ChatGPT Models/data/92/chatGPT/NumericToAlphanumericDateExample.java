import java.text.SimpleDateFormat;
import java.util.Date;

public class NumericToAlphanumericDateExample {
    public static void main(String[] args) {
        Location location1 = new Location("");
        location1.setLatitude(40.748817);
        location1.setLongitude(-73.985428);

        Location location2 = new Location("");
        location2.setLatitude(37.7749);
        location2.setLongitude(-122.4194);

        float[] distance = new float[1];
        Location.distanceBetween(location1.getLatitude(), location1.getLongitude(), location2.getLatitude(), location2.getLongitude(), distance);

        float distanceInMeters = distance[0];
        float distanceInKilometers = distanceInMeters / 1000.0f;

        System.out.println("Distance between location1 and location2 is " + distanceInKilometers + " km");

    }
}
