package com.mx.notificaciones.cron;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mx.notificaciones.models.dao.INotificacionDao;
import com.mx.notificaciones.models.dao.ISolicitudBloqueanteDao;
import com.mx.notificaciones.models.dao.ISolicitudDao;
import com.mx.notificaciones.models.entity.Notificacion;
import com.mx.notificaciones.models.entity.Solicitud;
import com.mx.notificaciones.utils.AppUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
public class SolicitudScheduler {
	@Autowired
	INotificacionDao iNotificacionDao;

	@Autowired
	ISolicitudDao iSolicitudDao;

	@Autowired
	ISolicitudBloqueanteDao iSolicitudBloqueanteDao;

	@Autowired
	AppUtils appUtils;

	@Autowired
	EntityManager entityManager;

	private static final Logger logger = LogManager.getLogger(SolicitudScheduler.class);

	@Scheduled(cron = "0 0/1 * * * ?", zone = "America/Mexico_City")
	@Transactional
	public void cronJobSch() {

		String uuid= appUtils.generaUuid();
		String idCron = "-1";
		uuid = uuid+idCron;
		List<Solicitud> solicitudes = iSolicitudDao.findWhereCronHostnameNull();
		for (Solicitud solicitud : solicitudes) {

				Integer tys = solicitud.getTys();
				/*Solicitud solicitudMasReciente= iSolicitudDao.findByTys(solicitud.getTys()).get();
				logger.debug("solicitudMasReciente.getCronHostname(): "+solicitudMasReciente.getCronHostname());*/

				//solicitudMasReciente.setCronHostname(uuid);
				List<Solicitud> solicitudesCoincidentes = iSolicitudDao.obtenerSolicitudPorTysAndSecuencia(solicitud.getTys(), solicitud.getUltimaSecuencia());
				if(solicitudesCoincidentes.size()!=0) {

					iSolicitudDao.actualizaCronHostnameSigSecuencia(solicitud.getTys(), solicitud.getUltimaSecuencia()+1, uuid, solicitud.getUltimaSecuencia());
					/*solicitud.setCronHostname(uuid);
				solicitud.setUltimaSecuencia(solicitud.getUltimaSecuencia()+1);
				entityManager.persist(solicitud);*/

					Notificacion notificacion=new Notificacion(new Date(), tys);

					entityManager.persist(notificacion);
					logger.error(notificacion.getId());

					//iSolicitudDao.actualizaCronHostnameNull(solicitud.getTys());
				}	
			
		}
		

	}
	/*
	@Transactional()
	public void cronJobSchStream() {
		final String uuid= appUtils.generaUuid()+"-1";

	    try (Stream<Solicitud> solicitudes = iSolicitudDao.findAllAsStream()) {
	    	solicitudes.forEach(solicitud -> procesarSolicitud(solicitud.getTys(), uuid));
	    }
	}

	@Transactional
    public void procesarSolicitud(int tys, String uuid) {
        Optional<Solicitud> optionalSolicitud = iSolicitudDao.findByTys(tys);
        Solicitud solicitud = optionalSolicitud.get();

        if(solicitud.getCronHostname()!=null) {
        	solicitud.setCronHostname(uuid);
        	entityManager.persist(solicitud);

        	Notificacion notificacion=new Notificacion(new Date(), solicitud.getTys());

			entityManager.persist(notificacion);

			solicitud.setCronHostname(uuid);
        	entityManager.persist(solicitud);
        }
    }*/
}
