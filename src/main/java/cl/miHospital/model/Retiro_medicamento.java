package cl.miHospital.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Retiro_medicamento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nombre;
	private String hora;
	private Date fecha;
	private String lugar;
	private String dosis;
	
	@ManyToOne
    @JoinColumn(name="paciente_rut", nullable=false)
	private Paciente paciente;
	
	@ManyToOne
    @JoinColumn(name="id_institucion")
	private Institucion institucion;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getFecha() {
		DateFormat dateFormatDiag = new SimpleDateFormat("dd/MM/yyyy");
    	String fecha = dateFormatDiag.format(this.fecha);
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getDosis() {
		return dosis;
	}
	public void setDosis(String dosis) {
		this.dosis = dosis;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public String getNombrePaciente(){
		return paciente.getNombre() + " " + paciente.getApellido();
	}
	public String getPaciente_rut(){
		return paciente.getRut();
	}
	public Institucion getInstitucion(){
		return this.institucion;
	}
	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}
	
	public String getNombre_institucion(){
		if(institucion!=null) return institucion.getNombre_institucion();
		return "";
	}

}
