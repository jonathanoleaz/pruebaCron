package com.mx.notificaciones.cron;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.mx.notificaciones.models.dao.INotificacionDao;
import com.mx.notificaciones.models.dao.ISolicitudDao;
import com.mx.notificaciones.models.entity.Solicitud;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NotificacionesScheduler {
	@Autowired
	INotificacionDao iNotificacionDao;
	
	@Autowired
	ISolicitudDao iSolicitudDao;
	
	private static final Logger logger = LogManager.getLogger(NotificacionesScheduler.class);

	@Scheduled(cron = "0 0/2 0-23 * * MON-SUN")
	   public void cronJobSch() {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	      Date now = new Date();
	      String strDate = sdf.format(now);
	      logger.debug("Java cron job expression:: " + strDate);
	      List<Solicitud> solicitudes = iSolicitudDao.findAll();
	      for (Solicitud solicitud : solicitudes) {
			logger.debug(solicitud.getTys());
		}
	   }
}
