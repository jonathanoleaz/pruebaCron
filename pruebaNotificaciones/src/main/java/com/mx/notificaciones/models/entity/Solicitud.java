package com.mx.notificaciones.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "solicitud")
public class Solicitud implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "tys")
	private Integer tys;

	@Column(name = "estado_notificacion")
	private Integer estadoNotificacion;

	@Column(name = "cron_hostname")
	private String cronHostname;

	@Column(name = "column1")
	private String column1;
	
	@Column(name = "ultima_secuencia")
	private Integer ultimaSecuencia;

	public Integer getTys() {
		return tys;
	}

	public void setTys(Integer tys) {
		this.tys = tys;
	}

	public Integer getEstadoNotificacion() {
		return estadoNotificacion;
	}

	public void setEstadoNotificacion(Integer estadoNotificacion) {
		this.estadoNotificacion = estadoNotificacion;
	}

	public String getCronHostname() {
		return cronHostname;
	}

	public void setCronHostname(String cronHostname) {
		this.cronHostname = cronHostname;
	}

	public String getColumn1() {
		return column1;
	}

	public void setColumn1(String column1) {
		this.column1 = column1;
	}
	
	public Integer getUltimaSecuencia() {
		return ultimaSecuencia;
	}

	public void setUltimaSecuencia(Integer ultimaSecuencia) {
		this.ultimaSecuencia = ultimaSecuencia;
	}
}
