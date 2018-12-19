package cl.miHospital.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private String rut;
	private String nombres;
	private String apellido;
	private String correo;
	private String contrasena;
	private Integer esPaciente;
	private Integer es_some;
	private String creado_por;
	private Timestamp fecha_creacion;
	private Integer id_institucion;
	private Integer primer_ingreso;
	private Integer acepta_condiciones;
	private String telefono;
	
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Integer getEsPaciente() {
		return esPaciente;
	}
	public void setEsPaciente(Integer esPaciente) {
		this.esPaciente = esPaciente;
	}
	public Integer getEs_some() {
		return es_some;
	}
	public void setEs_some(Integer es_some) {
		this.es_some = es_some;
	}
	public String getCreado_por() {
		return creado_por;
	}
	public void setCreado_por(String creado_por) {
		this.creado_por = creado_por;
	}
	public String getFecha_creacion() {
		
		if(fecha_creacion!=null){
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String fecha_string  = dateFormat.format(fecha_creacion);
			return fecha_string;
		}

		return "";
	}
	public void setFecha_creacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public Integer getId_institucion() {
		return id_institucion;
	}
	public void setId_institucion(Integer id_institucion) {
		this.id_institucion = id_institucion;
	}
	public Integer getPrimer_ingreso() {
		return primer_ingreso;
	}
	public void setPrimer_ingreso(Integer primer_ingreso) {
		this.primer_ingreso = primer_ingreso;
	}
	public Integer getAcepta_condiciones() {
		return acepta_condiciones;
	}
	public void setAcepta_condiciones(Integer acepta_condiciones) {
		this.acepta_condiciones = acepta_condiciones;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
