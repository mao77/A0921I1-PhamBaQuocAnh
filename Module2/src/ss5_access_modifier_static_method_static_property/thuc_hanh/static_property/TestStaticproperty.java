package ss5_access_modifier_static_method_static_property.thuc_hanh.static_property;

public class TestStaticproperty {
    public static void main(String[] args) {
        Car car1 = new Car("Mercedes", "Skyativ 3");
        System.out.println(Car.numberOfCar);
        Car car2 = new Car("Volvo", "skyativ 6");
        System.out.println(Car.numberOfCar);
    }
}
