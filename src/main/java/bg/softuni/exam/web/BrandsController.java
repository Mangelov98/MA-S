package bg.softuni.exam.web;

import bg.softuni.exam.model.view.BrandViewModel;
import bg.softuni.exam.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BrandsController {
    private final BrandService brandService;
    private final ModelMapper modelMapper;

    public BrandsController(BrandService brandService, ModelMapper modelMapper) {
        this.brandService = brandService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/brands/all")
    public String getAllBrandsPage(Model model) {

        model.addAttribute("allBrands",
                brandService.getAllBrands());
        return "brands";
    }
}