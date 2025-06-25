package com.proyCibertec.application.mapper;

import com.proyCibertec.application.dto.DetalleVentaDto;
import com.proyCibertec.application.dto.VentaDto;
import com.proyCibertec.domain.model.Ventas;
import com.proyCibertec.domain.model.DetalleVenta;

import java.util.List;
import java.util.stream.Collectors;

public class VentaMapper {

    public static VentaDto toDto(Ventas entity) {
        List<DetalleVentaDto> detallesDto = entity.getDetalles().stream()
                .map(DetalleVentaMapper::toDto)
                .collect(Collectors.toList());

        return new VentaDto(
                entity.getId(),
                entity.getUsuarioId(),
                entity.getFecha(),
                detallesDto
        );
    }

    public static Ventas toEntity(VentaDto dto) {
        List<DetalleVenta> detalles = dto.detalles().stream()
                .map(DetalleVentaMapper::toEntity)
                .collect(Collectors.toList());

        Ventas entity = new Ventas();
        entity.setId(dto.id());
        entity.setUsuarioId(dto.usuarioId());
        entity.setFecha(dto.fecha());
        entity.setDetalles(detalles);

        // importante: establecer la relación inversa
        detalles.forEach(d -> d.setVenta(entity));

        return entity;
    }
}
