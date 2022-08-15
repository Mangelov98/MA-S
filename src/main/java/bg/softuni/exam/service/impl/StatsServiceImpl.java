package bg.softuni.exam.service.impl;

import bg.softuni.exam.model.view.StatsView;
import bg.softuni.exam.repository.ClothesRepository;
import bg.softuni.exam.service.ClothesService;
import bg.softuni.exam.service.StatsService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class StatsServiceImpl implements StatsService {

    ClothesService clothesService;

    @Override
    public long getStats() {
        return clothesService.getTotal();
    }
}