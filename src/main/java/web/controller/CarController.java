package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.config.service.CarServiceImp;

@Controller
public class CarController {

    @GetMapping("/cars")
    public String showCarPage(@RequestParam(value = "count", defaultValue = "5") int allCar, Model model) {
        model.addAttribute("cars", new CarServiceImp().returnCars(allCar));
        return "cars";
    }
}
