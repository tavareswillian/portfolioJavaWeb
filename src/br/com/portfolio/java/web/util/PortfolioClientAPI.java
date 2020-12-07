package br.com.portfolio.java.web.util;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PortfolioClientAPI {
	
	private WebTarget baseTarget;
	
	public PortfolioClientAPI(String serviceUrl) {
		Client client = ClientBuilder.newClient();

		baseTarget = client.target(serviceUrl);
	}
	
	public List<Object> findAll() {
		Invocation.Builder invocationBuilder = baseTarget
				.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.get();

		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			throw new RuntimeException("Erro listando os recursos");
		}

		return response.readEntity(new GenericType<List<Object>>() {
		});

	}

	public List<Object> findByName(String name) {

		WebTarget searchTarget = baseTarget.path("/find/" + name);

		Invocation.Builder invocationBuilder = searchTarget
				.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.get();

		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			throw new RuntimeException("Erro listando o recurso");
		}

		return response.readEntity(new GenericType<List<Object>>() {
		});

	}

	public Object findById(int id) {

		WebTarget searchTarget = baseTarget.path("/" + id);

		Invocation.Builder invocationBuilder = searchTarget
				.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.get();

		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			throw new RuntimeException("Erro recuperando o recurso");
		}

		return response.readEntity(Object.class);
	}

	public Object add(Object resource) {

		Invocation.Builder invocationBuilder = baseTarget
				.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.post(Entity.entity(resource,
				MediaType.APPLICATION_JSON));

		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			throw new RuntimeException("Erro criando o recurso");
		}

		return response.readEntity(Object.class);

	}

	public void update(Object resource, String idResource) {
		WebTarget updateTarget = baseTarget.path("/" + idResource);//resource.getId());

		Invocation.Builder invocationBuilder = updateTarget
				.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.put(Entity.entity(resource,
				MediaType.APPLICATION_JSON));

		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			throw new RuntimeException("Erro atualizando o recurso");
		}
	}

	public void delete(Object resource, String idNameResource, String idResource) {
//		WebTarget deleteTarget = baseTarget.queryParam("contactId", idResource);
		WebTarget deleteTarget = baseTarget.queryParam(idNameResource, idResource);

		Invocation.Builder invocationBuilder = deleteTarget
				.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.delete();

		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			throw new RuntimeException("Erro removendo o recurso");
		}
	}

}
