package com.pfa.controller;

import com.pfa.Shared.GlobalResponse;
import com.pfa.abstracts.BinomeService;
import com.pfa.dto.BinomeDTO;
import com.pfa.model.Binome;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/binomes")
public class BinomeController {
    private final BinomeService binService;

    public BinomeController(BinomeService binService) {
        this.binService = binService;
    }

    @PostMapping
    public GlobalResponse<Binome> createBinome(@Valid @RequestBody BinomeDTO dto) {
        return new GlobalResponse<>(binService.createBinome(dto));
    }

    @GetMapping("/{id}")
    public GlobalResponse<Binome> getBinome(@PathVariable Integer id) {
        return new GlobalResponse<>(binService.getBinomeById(id));
    }

    @GetMapping
    public GlobalResponse<List<Binome>> getAllBinomes() {
        return new GlobalResponse<>(binService.getAllBinomes());
    }

    @PutMapping("/{id}")
    public GlobalResponse<Binome> updateBinome(@PathVariable Integer id,
                                               @Valid @RequestBody BinomeDTO dto) {
        return new GlobalResponse<>(binService.updateBinome(id, dto));
    }

    @DeleteMapping("/{id}")
    public GlobalResponse<String> deleteBinome(@PathVariable Integer id) {
        binService.deleteBinome(id);
        return new GlobalResponse<>("Binome supprimé avec succès");
    }
}