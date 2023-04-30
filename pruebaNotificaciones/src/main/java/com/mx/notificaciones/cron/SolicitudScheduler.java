package com.mx.notificaciones.cron;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mx.notificaciones.models.dao.INotificacionDao;
import com.mx.notificaciones.models.dao.ISolicitudDao;
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
	AppUtils appUtils;
	
	@Autowired
	EntityManager entityManager;
	
	private static final Logger logger = LogManager.getLogger(SolicitudScheduler.class);

	@Scheduled(cron = "0 * * ? * *", zone = "America/Mexico_City")
	@Transactional
	   public void cronJobSch() {
	      String uuid= appUtils.generaUuid();
	      List<Solicitud> solicitudes = iSolicitudDao.findByCronHostname(uuid);
	      for (Solicitud solicitud : solicitudes) {
			logger.debug(solicitud.getTys());
			solicitud.setCronHostname(uuid);
			entityManager.persist(solicitud);
		}
	   }
}
