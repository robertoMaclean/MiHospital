package cl.miHospital.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "paciente") 
public class Paciente {
	
	@Id
	private String rut;
	private String nombre;
	private String apellido;
	private Integer es_familiar;
	private String password;
	private String correo;
	private Integer es_paciente;
	private String password_original;
	private Integer primer_ingreso;
	private String creado_por;
	
	@OneToMany(mappedBy="paciente")
	private Set<Retiro_medicamento> retiro_medicamento;

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		if(nombre==null) return "";
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		if(apellido==null) return "";
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEs_familiar() {
		return es_familiar;
	}

	public void setEs_familiar(Integer es_familiar) {
		this.es_familiar = es_familiar;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getEs_paciente() {
		return es_paciente;
	}

	public void setEs_paciente(Integer es_paciente) {
		this.es_paciente = es_paciente;
	}

	public String getPassword_original() {
		return password_original;
	}

	public void setPassword_original(String password_original) {
		this.password_original = password_original;
	}

	public Integer getPrimer_ingreso() {
		return primer_ingreso;
	}

	public void setPrimer_ingreso(Integer primer_ingreso) {
		this.primer_ingreso = primer_ingreso;
	}

	public String getCreado_por() {
		return creado_por;
	}

	public void setCreado_por(String creado_por) {
		this.creado_por = creado_por;
	}

	public Set<Retiro_medicamento> getRetiro_medicamento() {
		return retiro_medicamento;
	}

	public void setRetiro_medicamento(Set<Retiro_medicamento> retiro_medicamento) {
		this.retiro_medicamento = retiro_medicamento;
	}

	
}
