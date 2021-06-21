package com.grupo4.sorteio.controller;

import com.grupo4.sorteio.dtos.CreatePrizeDTO;
import com.grupo4.sorteio.dtos.PrizeDTO;
import com.grupo4.sorteio.services.PrizeService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/prize")
public class PrizeController {

    private final PrizeService prizeService;

    public PrizeController(PrizeService prizeService) {
        this.prizeService = prizeService;
    }

    @PostMapping
    public ResponseEntity<PrizeDTO> create(@Valid  @RequestBody CreatePrizeDTO createPrizeDTO) {
        return ResponseEntity.ok(prizeService.create(createPrizeDTO));
    }

    @PostMapping("/{prizeId}/draw")
    public ResponseEntity<?> draw(@PathVariable Long prizeId) {
        return ResponseEntity.ok(prizeService.draw(prizeId));
    }
}
