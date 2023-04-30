package com.mx.notificaciones.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.notificaciones.models.entity.Notificacion;

public interface INotificacionDao extends JpaRepository<Notificacion, Long>{

}
