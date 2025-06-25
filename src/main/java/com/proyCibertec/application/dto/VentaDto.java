package com.proyCibertec.application.dto;

import java.util.Date;
import java.util.List;

public record VentaDto(Integer id, Integer usuarioId, Date fecha, List<DetalleVentaDto> detalles) {}
