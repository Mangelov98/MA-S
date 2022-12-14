package bg.softuni.exam.repository;

import bg.softuni.exam.model.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
    ModelEntity findByName(String model);
}