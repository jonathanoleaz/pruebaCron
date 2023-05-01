package com.mx.notificaciones.models.dao;

import java.util.List;
import org.springframework.data.repository.query.Param;

import com.mx.notificaciones.models.entity.Solicitud;

public interface ISolicitudBloqueanteDao{
	public List<Solicitud> obtenerSolicitudPorTysAndSecuencia(@Param("tys") Integer tys,@Param("secuenciaAnterior") Integer secuenciaAnterior);
}
