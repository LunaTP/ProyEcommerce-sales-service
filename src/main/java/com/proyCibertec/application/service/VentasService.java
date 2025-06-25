package com.proyCibertec.application.service;

import com.proyCibertec.application.dto.VentaDto;
import java.util.List;

public interface VentasService {
    VentaDto registrarVenta(VentaDto ventaDto);
    List<VentaDto> listarVentas();
    VentaDto obtenerVentaPorId(Integer id);
}
