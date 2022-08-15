package bg.softuni.exam.web;

import bg.softuni.exam.model.view.StatsView;
import bg.softuni.exam.service.StatsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatsController {

    private final StatsService statsService;
    private final ModelMapper modelMapper;



    public StatsController(StatsService statsService, ModelMapper modelMapper) {
        this.statsService = statsService;
        this.modelMapper = modelMapper;

    }

    @GetMapping("/stats")
    public String Statistics(Model model) {
        model.addAttribute("statics",5);
        return "stats";
    }

}