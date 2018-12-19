package cl.miHospital.model;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Institucion implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_institucion;
	private String nombre_institucion;
	
	@OneToMany(mappedBy="paciente")
	private Set<Retiro_medicamento> retiro_medicamento;
	
	public String getNombre_institucion() {
		return nombre_institucion;
	}
	public void setNombre_institucion(String nombre_institucion) {
		this.nombre_institucion = nombre_institucion;
	}
	public Integer getId(){
		return this.id_institucion;
	}
	
}
