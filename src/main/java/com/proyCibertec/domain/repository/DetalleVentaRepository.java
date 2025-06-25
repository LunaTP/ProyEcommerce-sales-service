package com.proyCibertec.domain.repository;

import com.proyCibertec.domain.model.DetalleVenta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DetalleVentaRepository extends CrudRepository<DetalleVenta,Integer> {
    List<DetalleVenta> findByVentaId(Integer ventaId);

}
