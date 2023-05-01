package com.mx.notificaciones.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "notificaciones")
public class Notificacion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quoteSeq")
    @SequenceGenerator(name = "quoteSeq", sequenceName = "NOTIFICACIONES_SEQ ", allocationSize = 1)
	@Column(name = "id_notificacion")
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	@Column(name = "fk_solicitud")
	private Integer fkSolicitud;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getFkSolicitud() {
		return fkSolicitud;
	}

	public void setFkSolicitud(Integer fkSolicitud) {
		this.fkSolicitud = fkSolicitud;
	}

	public Notificacion(@NotEmpty Date fechaCreacion, @NotEmpty Integer fkSolicitud) {
		super();
		this.fechaCreacion = fechaCreacion;
		this.fkSolicitud = fkSolicitud;
	}
}
