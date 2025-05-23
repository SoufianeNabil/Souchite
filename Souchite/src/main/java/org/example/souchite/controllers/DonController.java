package org.example.souchite.controllers;

import lombok.RequiredArgsConstructor;
import org.example.souchite.dto.DonDTO;
import org.example.souchite.entities.Don;
import org.example.souchite.services.DonService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/dons")
@RequiredArgsConstructor
public class DonController {
    private final DonService donService;

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Don> effectuerDon(
            @Valid @RequestBody DonDTO dto,
            @RequestParam Long userId) {
        return ResponseEntity.ok(donService.effectuerDon(dto, userId));
    }

    @GetMapping("/utilisateur/{userId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<Don>> getDonsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(donService.getDonsByUser(userId));
    }

    @GetMapping("/action-charite/{actionChariteId}")
    public ResponseEntity<List<Don>> getDonsByActionCharite(@PathVariable Long actionChariteId) {
        return ResponseEntity.ok(donService.getDonsByActionCharite(actionChariteId));
    }

    @GetMapping("/action-charite/{actionChariteId}/total")
    public ResponseEntity<Double> getTotalMontantByActionCharite(@PathVariable Long actionChariteId) {
        return ResponseEntity.ok(donService.getTotalMontantByActionCharite(actionChariteId));
    }
} 