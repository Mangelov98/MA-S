package bg.softuni.exam.repository;

import bg.softuni.exam.model.entity.ClothesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesRepository extends JpaRepository<ClothesEntity, Long> {

}