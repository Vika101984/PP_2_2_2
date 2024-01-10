package web.servise;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiseImpl implements CarServise {
    private final List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(1,"bmw","red"));
        cars.add(new Car(2,"hyundai","black"));
        cars.add(new Car(3,"porsche","blue"));
        cars.add(new Car(4,"chevrolet","silver"));
        cars.add(new Car(5,"lada","white"));
    }

    @Override
    public List<Car> listCars(int count) {
        return cars.stream().limit(count).toList();
    }

    @Override
    public int countCars() {
        return cars.size();
    }
}
