package com.pfa.Controller;

import com.pfa.dto.SujetDTO;
import com.pfa.Service.SujetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sujets")
public class SujetController {

    @GetMapping("/disponibles")
    public ResponseEntity<List<SujetDTO>> getSujetsDisponibles() {
        return ResponseEntity.ok(SujetService.getSujetsDisponibles());
    }
}