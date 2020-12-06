package br.com.portfolio.java.web.acao;

public class ApiCliente {
	
	public String apiResource;
	
	public ApiCliente(String apiResource) {
		System.out.println("Nova instância de API...");
		this.apiResource = apiResource;
	}
	
	public String getService(String serviceName) {
		return serviceName;
	}
	
	public String postService(String serviceName) {
		return serviceName;
	}
	
	public String putService(String serviceName) {
		return serviceName;
	}
	
	public String deleteService(String serviceName) {
		return serviceName;
	}
	
	public static String loadService(String serviceName) {
		return serviceName;
	}
}
