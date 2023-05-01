package com.mx.notificaciones.models.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mx.notificaciones.models.entity.Solicitud;

@Repository
public class SolicitudBloqueanteDao implements ISolicitudBloqueanteDao{
	
	@Autowired
    EntityManager em;

	@Override
	public List<Solicitud> obtenerSolicitudPorTysAndSecuencia(Integer tys, Integer secuenciaAnterior) {
		
	        Query q = em.createQuery("select sol from Solicitud sol where tys=:tys and ultimaSecuencia=:secuenciaAnterior");
	        q.setParameter("tys", tys);
	        q.setParameter("secuenciaAnterior", secuenciaAnterior);
	        q.setLockMode(LockModeType.PESSIMISTIC_WRITE);
	        List<Solicitud> list = new ArrayList<Solicitud>(); 
	        list=q.getResultList();
	        
	        return list;
		
	}

}
