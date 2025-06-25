package com.proyCibertec.web.controller;

import com.proyCibertec.application.dto.VentaDto;
import com.proyCibertec.application.service.VentasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class VentasController {

    private final VentasService ventasService;

    @PostMapping
    public ResponseEntity<VentaDto> registrar(@RequestBody VentaDto ventaDto) {
        VentaDto creada = ventasService.registrarVenta(ventaDto);
        return ResponseEntity.status(201).body(creada);
    }


    @GetMapping
    public ResponseEntity<List<VentaDto>> listar() {
        return ResponseEntity.ok(ventasService.listarVentas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaDto> buscarPorId(@PathVariable Integer id) {
        VentaDto dto = ventasService.obtenerVentaPorId(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }
}
