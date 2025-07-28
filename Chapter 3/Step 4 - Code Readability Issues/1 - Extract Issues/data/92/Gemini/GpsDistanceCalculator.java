import android.location.Location;

public class GpsDistanceCalculator {

    /**
     * Calculates the distance between two GPS coordinates in meters.
     *
     * @param lat1 Latitude of the first point.
     * @param lon1 Longitude of the first point.
     * @param lat2 Latitude of the second point.
     * @param lon2 Longitude of the second point.
     * @return The distance in meters, or -1 if the input is invalid.
     */
    public static float calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        Location location1 = new Location("");
        location1.setLatitude(lat1);
        location1.setLongitude(lon1);

        Location location2 = new Location("");
        location2.setLatitude(lat2);
        location2.setLongitude(lon2);

        return location1.distanceTo(location2); // Returns distance in meters
    }

    public static void main(String[] args) {
        // Example usage:
        double latA = 40.7128; // New York City latitude
        double lonA = -74.0060; // New York City longitude

        double latB = 34.0522; // Los Angeles latitude
        double lonB = -118.2437; // Los Angeles longitude

        float distanceInMeters = calculateDistance(latA, lonA, latB, lonB);
        System.out.println("Distance between points: " + distanceInMeters + " meters");
        System.out.println("Distance between points: " + (distanceInMeters / 1000) + " kilometers");
    }
}
