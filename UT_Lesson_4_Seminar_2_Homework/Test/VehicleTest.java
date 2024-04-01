import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VehicleTest {
    private Car car;
    private Motorcycle motorcycle;

    @BeforeEach
    void setup() {
        car = new Car("Mercedes", "GLS 600", 2021);
        motorcycle = new Motorcycle("Suzuki", "Katana", 2024);
    }

    // - проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
    @Test
    void carIsVehicle() {
        assertThat(car).isInstanceOf(Vehicle.class);
    }

    // - проверка того, объект Car создается с 4-мя колесами
    @Test
    void carHasFourWheels() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    // - проверка того, объект Motorcycle создается с 2-мя колесами
    @Test
    void motorcycleHasTwoWheels() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    // - проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
    @Test
    void carTestDrive() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    // - проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
    @Test
    void motorcycleTestDrive() {
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    // - проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
    @Test
    void carPark() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    // - проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
    @Test
    void motorcyclePark() {
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}
