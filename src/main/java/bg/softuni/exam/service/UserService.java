package bg.softuni.exam.service;

import bg.softuni.exam.model.service.UserRegistrationServiceModel;

public interface UserService {

    void initializeUsersAndRoles();

    void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel);

    boolean isUserNameFree(String username);
}