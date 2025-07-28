import android.location.Location;

public class GPSDistanceExample {

    public static float getDistance(double lat1, double lon1, double lat2, double lon2) {
        float[] results = new float[1];
        Location.distanceBetween(lat1, lon1, lat2, lon2, results);
        return results[0];  // distância em metros
    }

    public static void main(String[] args) {
        double lat1 = -23.550520;  // exemplo: São Paulo
        double lon1 = -46.633308;
        double lat2 = -22.906847;  // exemplo: Rio de Janeiro
        double lon2 = -43.172897;

        float distanceInMeters = getDistance(lat1, lon1, lat2, lon2);
        System.out.println("Distância em metros: " + distanceInMeters);
    }
}
