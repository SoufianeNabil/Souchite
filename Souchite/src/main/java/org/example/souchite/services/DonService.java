package org.example.souchite.services;

import lombok.RequiredArgsConstructor;
import org.example.souchite.dto.DonDTO;
import org.example.souchite.entities.ActionCharite;
import org.example.souchite.entities.Don;
import org.example.souchite.entities.User;
import org.example.souchite.repositories.ActionChariteRepository;
import org.example.souchite.repositories.DonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DonService {
    private final DonRepository donRepository;
    private final ActionChariteRepository actionChariteRepository;
    private final UserService userService;

    @Transactional
    public Don effectuerDon(DonDTO dto, Long userId) {
        User user = userService.findByEmail(userId.toString());
        ActionCharite actionCharite = actionChariteRepository.findById(dto.getActionChariteId())
                .orElseThrow(() -> new RuntimeException("Action de charité non trouvée"));

        Don don = new Don();
        don.setMontant(dto.getMontant());
        don.setMessage(dto.getMessage());
        don.setUser(user);
        don.setActionCharite(actionCharite);

        return donRepository.save(don);
    }

    public List<Don> getDonsByUser(Long userId) {
        return donRepository.findByUserId(userId);
    }

    public List<Don> getDonsByActionCharite(Long actionChariteId) {
        return donRepository.findByActionChariteId(actionChariteId);
    }

    public Double getTotalMontantByActionCharite(Long actionChariteId) {
        return donRepository.getTotalMontantByActionChariteId(actionChariteId);
    }
} 