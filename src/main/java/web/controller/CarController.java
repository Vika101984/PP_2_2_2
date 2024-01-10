package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.servise.CarServise;

@Controller
public class CarController {
    private final CarServise carServise;

    @Autowired
    public CarController(CarServise carServise) {
        this.carServise = carServise;
    }

    @GetMapping("/cars")
    public String listIndexCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        if (count >= 5) {
            model.addAttribute("cars", carServise.listCars(carServise.countCars()));
        } else {
            model.addAttribute("cars", carServise.listCars(count));
        }
        return "cars";
    }
}