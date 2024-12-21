package vn.edu.iuh.fit.trananhtien.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.trananhtien.backend.repositories.FlightRepository;
import vn.edu.iuh.fit.trananhtien.backend.services.FlightService;

@Controller
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightService flightService;

    @GetMapping("/list")
    public String showFlightList(Model model){
        model.addAttribute("flights", flightRepository.findAll());
        return "flights";
    }
}
