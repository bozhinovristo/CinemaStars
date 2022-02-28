package com.example.cinemastars.web;

import com.example.cinemastars.model.Projection;
import com.example.cinemastars.model.Seat;
import com.example.cinemastars.service.ProjectionService;
import com.example.cinemastars.service.SeatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projection")
public class ProjectionController {

    private final ProjectionService projectionService;
    private final SeatService seatService;

    public ProjectionController(ProjectionService projectionService, SeatService seatService) {
        this.projectionService = projectionService;
        this.seatService = seatService;
    }

    @GetMapping("/{id}")
    public String showProjection(@PathVariable Long id, Model model)
    {
        Projection projection= projectionService.findById(id);
        model.addAttribute("projection", projection);
        List<Seat> seats=seatService.findAllByProjectionId(id);
        model.addAttribute("seats", seats);
        return "projection";
    }

}
