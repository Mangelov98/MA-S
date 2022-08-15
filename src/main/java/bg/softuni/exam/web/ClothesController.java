package bg.softuni.exam.web;

import bg.softuni.exam.model.binding.ClothesAddBindModel;
import bg.softuni.exam.model.binding.ClothesUpdateBindingModel;
import bg.softuni.exam.model.entity.enums.EngineEnum;
import bg.softuni.exam.model.service.ClothesAddServiceModel;
import bg.softuni.exam.model.service.ClothesUpdateServiceModel;
import bg.softuni.exam.model.view.ClothesDetailsView;
import bg.softuni.exam.service.BrandService;
import bg.softuni.exam.service.ClothesService;
import bg.softuni.exam.service.impl.ShopUser;
import java.security.Principal;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ClothesController {
    private final ClothesService clothesService;
    private final ModelMapper modelMapper;
    private final BrandService brandService;

    public ClothesController(ClothesService clothesService,
                             ModelMapper modelMapper, BrandService brandService) {
        this.clothesService = clothesService;
        this.modelMapper = modelMapper;
        this.brandService = brandService;
    }

    // GET
    @GetMapping("/clothes/all")
    public String allClothes(Model model) {
        model.addAttribute("clothes",
                clothesService.getAllClothes());
        return "clothes";
    }

    @GetMapping("/clothes/{id}/details")
    public String showOffer(
            @PathVariable Long id, Model model,
            Principal principal) {
        model.addAttribute("clothes", this.clothesService.findById(id, principal.getName()));
        return "details";
    }

    // DELETE
    @PreAuthorize("isOwner(#id)")
    //@PreAuthorize("@clothesServiceImp.isOwner(#principal.name, #id)")
    @DeleteMapping("/clothes/{id}")
    public String deleteClothes(@PathVariable Long id,
                                Principal principal) {

        // Most naive approach - check explicitly if the current user is an
        //owner and throw exception if this is not the case.
//        if (!clothesService.isOwner(principal.getName(), id)) {
//            throw new RuntimeException();
//        }
        clothesService.deleteClothes(id);


        return "item-deleted";
    }

    // UPDATE

    @GetMapping("/clothes/{id}/edit")
    public String editClothes(@PathVariable Long id, Model model,
                              @AuthenticationPrincipal ShopUser currentUser) {

        ClothesDetailsView clothesDetailsView = clothesService.findById(id, currentUser.getUserIdentifier());
        ClothesUpdateBindingModel clothesModel = modelMapper.map(
                clothesDetailsView,
                ClothesUpdateBindingModel.class
        );
        model.addAttribute("engines", EngineEnum.values());
        model.addAttribute("clothesModel", clothesModel);
        return "update";
    }

    @GetMapping("/clothes/{id}/edit/errors")
    public String editClothesErrors(@PathVariable Long id, Model model) {
        model.addAttribute("engines", EngineEnum.values());
        return "update";
    }

    @PatchMapping("/clothes/{id}/edit")
    public String editClothes(
            @PathVariable Long id,
            @Valid ClothesUpdateBindingModel clothesModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("clothesModel", clothesModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.clothesModel", bindingResult);

            return "redirect:/clothes/" + id + "/edit/errors";
        }

        ClothesUpdateServiceModel serviceModel = modelMapper.map(clothesModel,
                ClothesUpdateServiceModel.class);
        serviceModel.setId(id);

        clothesService.updateClothes(serviceModel);

        return "item-updated";
    }

    @GetMapping("/clothes/add")
    public String getAddClothesPage(Model model) {

        if (!model.containsAttribute("clothesAddBindModel")) {
            model.
                    addAttribute("clothesAddBindModel", new ClothesAddBindModel()).
                    addAttribute("brandsModels", brandService.getAllBrands());
        }
        return "clothes-add";
    }

    @PostMapping("/clothes/add")
    public String addOffer(@Valid ClothesAddBindModel clothesAddBindModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal ShopUser user) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("clothesAddBindModel", clothesAddBindModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.clothesAddBindModel", bindingResult)
                    .addFlashAttribute("brandsModels", brandService.getAllBrands());
            return "redirect:/clothes/add";
        }
        ClothesAddServiceModel savedClothesAddServiceModel = clothesService.addClothes(clothesAddBindModel, user.getUserIdentifier());
        return "redirect:/clothes/" + savedClothesAddServiceModel.getId() + "/details";
    }
}