package org.example.souchite.controllers;

import lombok.RequiredArgsConstructor;
import org.example.souchite.dto.ActionChariteDTO;
import org.example.souchite.services.ActionChariteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/actions")
@RequiredArgsConstructor
public class ActionController {
    private final ActionChariteService actionChariteService;

    @GetMapping
    public ResponseEntity<List<ActionChariteDTO>> getAll() {
        return ResponseEntity.ok(actionChariteService.getAll());
    }

    @GetMapping("/organisation/{organisationId}")
    public ResponseEntity<List<ActionChariteDTO>> getByOrganisation(@PathVariable Long organisationId) {
        return ResponseEntity.ok(actionChariteService.getByOrganisation(organisationId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActionChariteDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(actionChariteService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ActionChariteDTO> create(@Valid @RequestBody ActionChariteDTO dto) {
        return ResponseEntity.ok(actionChariteService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActionChariteDTO> update(@PathVariable Long id, @Valid @RequestBody ActionChariteDTO dto) {
        return ResponseEntity.ok(actionChariteService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        actionChariteService.delete(id);
        return ResponseEntity.noContent().build();
    }
} 