
public class VehicleFactory {

    public enum VehicleType {
        CAR, TRUCK, MOTORCYCLE
    }

    public static Vehicle createVehicle(VehicleType type) {
        return switch (type) {
            case CAR ->
                new Car();
            case TRUCK ->
                new Truck();
            case MOTORCYCLE ->
                new Motorcycle();
            default ->
                throw new IllegalArgumentException("Unknown vehicle type");
        };
    }

    public static void main(String[] args) {
// Usage:
        Vehicle car = VehicleFactory.createVehicle(VehicleFactory.VehicleType.CAR);

    }
}
