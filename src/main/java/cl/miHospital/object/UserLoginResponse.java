package cl.miHospital.object;

public class UserLoginResponse {
	 
	public UserLoginResponse() {
		super();
	}
	
	public UserLoginResponse(String username, String rut, String firstName,
			String lastName, String token, String role) {
		super();
		this.username = username;
		this.rut = rut;
		this.token = token;
		this.role = role;
	}
	
	private String username;
	private String rut;
	private String token;
	private String role;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
