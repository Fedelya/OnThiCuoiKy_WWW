package vn.edu.iuh.fit.trananhtien.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.trananhtien.backend.enums.FlightStatus;
import vn.edu.iuh.fit.trananhtien.backend.models.Flight;
import vn.edu.iuh.fit.trananhtien.backend.repositories.FlightRepository;
import vn.edu.iuh.fit.trananhtien.backend.repositories.PlaneRepository;
import vn.edu.iuh.fit.trananhtien.backend.services.FlightService;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
public class FlightController {
    @Autowired
    private PlaneRepository planeRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightService flightService;

    @GetMapping("/list")
    public String showFlightList(Model model){
        model.addAttribute("flights", flightRepository.findAll());
        return "flights/flights";
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView mav = new ModelAndView();
        Flight flight = new Flight();
        mav.addObject("flight", flight);
        mav.addObject("planes", planeRepository.findAll());
        mav.addObject("flightStatuses", FlightStatus.values());
        mav.setViewName("flights/add-flights");
        return mav;
    }

    @PostMapping("/flights/add-flights")
    public String addFlight(@ModelAttribute("flight") Flight flight){
        flightRepository.save(flight);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editFlight(@PathVariable("id") int id){
        ModelAndView mav = new ModelAndView();
        Optional<Flight> flight = flightRepository.findById(id);
        if (flight.isPresent()){
            mav.addObject("flight", flight.get());
            mav.addObject("planes", planeRepository.findAll());
            mav.addObject("flightStatuses", FlightStatus.values());
            mav.setViewName("flights/update-flight");
        } else {
            mav.setViewName("redirect:/flights");
        }
        return mav;
    }

    @PostMapping("/flights/update-flight")
    public String updateFlight(@ModelAttribute("flight") Flight flight){
        flightRepository.save(flight);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteFlight(@PathVariable("id") int id){
        flightRepository.deleteById(id);
        return "redirect:/list";
    }
}
