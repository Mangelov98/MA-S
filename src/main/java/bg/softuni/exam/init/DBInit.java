package bg.softuni.exam.init;
import bg.softuni.exam.service.BrandService;
import bg.softuni.exam.service.ModelService;
import bg.softuni.exam.service.ClothesService;
import bg.softuni.exam.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandService brandService;
    private final ModelService modelService;
    private final UserService userService;
    private final ClothesService clothesService;

    public DBInit(BrandService brandService, ModelService modelService, UserService userService,
                  ClothesService clothesService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.userService = userService;
        this.clothesService = clothesService;
    }

    @Override
    public void run(String... args) throws Exception {
        brandService.initializeBrand();
        modelService.initializeModels();
        userService.initializeUsersAndRoles();
        clothesService.initializeClothes();
    }
}