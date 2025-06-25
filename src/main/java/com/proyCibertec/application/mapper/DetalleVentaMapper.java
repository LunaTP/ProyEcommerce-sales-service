package com.proyCibertec.application.mapper;

import com.proyCibertec.application.dto.DetalleVentaDto;
import com.proyCibertec.domain.model.DetalleVenta;

public class DetalleVentaMapper {

    public static DetalleVentaDto toDto(DetalleVenta entity) {
        return new DetalleVentaDto(
                entity.getProductoId(),
                entity.getCantidad(),
                entity.getPrecioUnitario()
        );
    }

    public static DetalleVenta toEntity(DetalleVentaDto dto) {
        DetalleVenta entity = new DetalleVenta();
        entity.setProductoId(dto.productoId());
        entity.setCantidad(dto.cantidad());
        entity.setPrecioUnitario(dto.precioUnitario());
        return entity;
    }
}
