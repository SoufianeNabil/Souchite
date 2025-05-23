package org.example.souchite.repositories;

import org.example.souchite.entities.Don;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface DonRepository extends JpaRepository<Don, Long> {
    List<Don> findByUserId(Long userId);
    List<Don> findByActionChariteId(Long actionChariteId);
    
    @Query("SELECT SUM(d.montant) FROM Don d WHERE d.actionCharite.id = :actionChariteId")
    Double getTotalMontantByActionChariteId(Long actionChariteId);
} 