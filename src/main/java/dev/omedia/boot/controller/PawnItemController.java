package dev.omedia.boot.controller;

import dev.omedia.boot.dto.PawnItemDTO;
import dev.omedia.boot.service.PawnService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/pawn")
@RequiredArgsConstructor
public class PawnItemController {
    private final PawnService service;

    @GetMapping
    public ResponseEntity<ArrayList<PawnItemDTO>> findAll() {
        return ResponseEntity.of(
                Optional.of(service.findAll())
        );
    }

    @PostMapping
    public ResponseEntity<PawnItemDTO> save(@RequestBody @Valid PawnItemDTO dto) {
        System.out.println(dto);
        return ResponseEntity.of(
                Optional.of(service.save(dto))
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<PawnItemDTO> pay(
            @PathVariable @RequestParam long id,
            @RequestParam int amount
    ) {
        return ResponseEntity.of(
                Optional.of(service.pay(id, amount))
        );
    }
}
