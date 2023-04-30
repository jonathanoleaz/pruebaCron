package com.mx.notificaciones.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.notificaciones.models.entity.Solicitud;

public interface ISolicitudDao extends JpaRepository<Solicitud, Long>{

}
