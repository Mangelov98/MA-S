package bg.softuni.exam.repository;

import bg.softuni.exam.model.entity.UserRoleEntity;
import bg.softuni.exam.model.entity.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    UserRoleEntity findByRole(UserRoleEnum role);

}