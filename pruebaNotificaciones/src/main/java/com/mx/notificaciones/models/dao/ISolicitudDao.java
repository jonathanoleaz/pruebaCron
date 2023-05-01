package com.mx.notificaciones.models.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.notificaciones.models.entity.Solicitud;

public interface ISolicitudDao extends JpaRepository<Solicitud, Long>{
	@Query(value="select * from solicitud order by DBMS_RANDOM.RANDOM", nativeQuery = true)
    public List<Solicitud> findWhereCronHostnameNull();
	
	/*@Query("select sol from Solicitud sol")
	public Stream<Solicitud> findAllAsStream();*/
	
	Optional<Solicitud> findByTys(@Param(value = "tys") Integer tys);
	
	@Modifying
	@Query("update Solicitud sol set sol.ultimaSecuencia=:ultimaSecuencia, sol.cronHostname=:cronHostname where tys=:tys and ultimaSecuencia=:secuenciaAnterior")
	int actualizaCronHostnameSigSecuencia(@Param("tys") Integer tys, 
											@Param("ultimaSecuencia") Integer ultimaSecuencia, 
											@Param("cronHostname") String cronHostname, 
											@Param("secuenciaAnterior") Integer secuenciaAnterior);
	

	@Query("select sol from Solicitud sol where tys=:tys and ultimaSecuencia=:secuenciaAnterior")
	public List<Solicitud> obtenerSolicitudPorTysAndSecuencia(@Param("tys") Integer tys,
															@Param("secuenciaAnterior") Integer secuenciaAnterior);
	
	@Modifying
	@Query("update Solicitud sol set sol.cronHostname=null where tys=:tys")
	int actualizaCronHostnameNull(@Param("tys") Integer tys);
}
