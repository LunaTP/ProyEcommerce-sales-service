package com.proyCibertec.application.service.impl;

import com.proyCibertec.application.dto.VentaDto;
import com.proyCibertec.application.mapper.VentaMapper;
import com.proyCibertec.application.service.VentasService;
import com.proyCibertec.domain.model.Ventas;
import com.proyCibertec.domain.repository.VentasRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class VentasServiceImpl implements VentasService {

    private final VentasRepository ventasRepository;

    @Override
    public VentaDto registrarVenta(VentaDto ventaDto) {
        Ventas venta = VentaMapper.toEntity(ventaDto);
        venta.setFecha(new Date());
        Ventas guardada = ventasRepository.save(venta);
        return VentaMapper.toDto(guardada);
    }

    @Override
    public List<VentaDto> listarVentas() {
        List<VentaDto> resultado = new ArrayList<>();
        ventasRepository.findAll().forEach(v -> resultado.add(VentaMapper.toDto(v)));
        return resultado;
    }

    @Override
    public VentaDto obtenerVentaPorId(Integer id) {
        return ventasRepository.findById(id)
                .map(VentaMapper::toDto)
                .orElse(null);
    }
}
