package com.mx.notificaciones.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.notificaciones.models.entity.Solicitud;

public interface ISolicitudDao extends JpaRepository<Solicitud, Long>{
	@Query("select sol from Solicitud sol where cronHostname<>:cronHostname")
    public List<Solicitud> findByCronHostname(@Param("cronHostname") String cronHostname);
}
