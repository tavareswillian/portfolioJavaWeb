package br.com.portfolio.java.web.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.portfolio.java.web.dto.Autenticador;
import br.com.portfolio.java.web.model.Funcionalidade;

public class PortfolioClientAPI {

	public static List<Funcionalidade> obtemFuncionalidades(){
		ArrayList<Funcionalidade> lista = null;

		try {

			URL url = new URL("http://localhost:8080/funcionalidade/listar");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : "
						+ conn.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			String output;
			String json ="";
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				json += output;
			}
			conn.disconnect();

			Gson gson = new Gson();
			Type tipoLista = new TypeToken<ArrayList<Funcionalidade>>() {}.getType();
			lista = gson.fromJson(json, tipoLista);

			for(Funcionalidade funcionalidade : lista)
			{
				System.out.println(funcionalidade.getNmFuncionalidade());
			}
		} catch (Exception e) {
			System.out.println("Exception in NetClientGet:- " + e);
		}
		return lista;
	}

	public static ArrayList<Autenticador> obtemAutenticadores(){
		ArrayList<Autenticador> lista = null;

		try {

			URL url = new URL("http://localhost:8080/autenticador/listar");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : "
						+ conn.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			String output;
			String json ="";
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				json += output;
			}
			conn.disconnect();

			Gson gson = new Gson();
			Type tipoLista = new TypeToken<ArrayList<Funcionalidade>>() {}.getType();
			lista = gson.fromJson(json, tipoLista);

			for(Autenticador autenticador : lista)
			{
				System.out.println(autenticador.getHashSessao());
			}
		} catch (Exception e) {
			System.out.println("Exception in NetClientGet:- " + e);
		}
		return lista;
	}

	public static Autenticador obtemAutenticador(String idAutenticador){
		Autenticador autenticador = null;

		try {

			URL url = new URL("http://localhost:8080/autenticador/" + idAutenticador);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : "
						+ conn.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			String output;
			String json ="";
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				json += output;
			}
			conn.disconnect();

			Gson gson = new Gson();
			Type tipoLista = new TypeToken<ArrayList<Funcionalidade>>() {}.getType();
			autenticador = (Autenticador) gson.fromJson(json, tipoLista);

			System.out.println(autenticador.getHashSessao());

		} catch (Exception e) {
			System.out.println("Exception in NetClientGet:- " + e);
		}
		return autenticador;
	}

	public static String addAutenticador(Autenticador autenticador){

		String resultado = "";
		try {

			URL url = new URL("http://localhost:8080/autenticador");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json; utf-8");
			conn.setRequestProperty("Accept", "application/json");
			conn.setDoOutput(true);

			String autenticadorEnviado = "{ expirado:" + autenticador.isExpirado() +
					",hashSessao:" + autenticador.getHashSessao() +"}";

			try(OutputStream os = conn.getOutputStream()) {
				byte[] input = autenticadorEnviado.getBytes("utf-8");
				os.write(input, 0, input.length);			
			}

			try(BufferedReader br = new BufferedReader(
					new InputStreamReader(conn.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				System.out.println(response.toString());
				resultado = response.toString();
			}

		} catch (Exception e) {
			System.out.println("Exception in NetClientGet:- " + e);
		}
		return resultado;
	}

	public static String addAutenticador(String idSessao){

		String resultado = "";
		try {

			URL url = new URL("http://localhost:8080/autenticador");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json; utf-8");
			conn.setRequestProperty("Accept", "application/json");
			conn.setDoOutput(true);

			String autenticadorEnviado = "{hashSessao:" + idSessao +"}";

			try(OutputStream os = conn.getOutputStream()) {
				byte[] input = autenticadorEnviado.getBytes("utf-8");
				os.write(input, 0, input.length);			
			}

			try(BufferedReader br = new BufferedReader(
					new InputStreamReader(conn.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				System.out.println(response.toString());
				resultado = response.toString();
			}

		} catch (Exception e) {
			System.out.println("Exception in NetClientGet:- " + e);
		}
		return resultado;
	}

	public static String removeAutenticador(String idSessao) {

		String resultado = "";
		try {

			URL url = new URL("http://localhost:8080/autenticador");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("DELETE");
			conn.setRequestProperty("Content-Type", "application/json; utf-8");
			conn.setRequestProperty("Accept", "application/json");
			conn.setDoOutput(true);

			String autenticadorEnviado = "{hashSessao:" + idSessao +"}";

			try(OutputStream os = conn.getOutputStream()) {
				byte[] input = autenticadorEnviado.getBytes("utf-8");
				os.write(input, 0, input.length);			
			}

			try(BufferedReader br = new BufferedReader(
					new InputStreamReader(conn.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				System.out.println(response.toString());
				resultado = response.toString();
			}

		} catch (Exception e) {
			System.out.println("Exception in NetClientGet:- " + e);
		}
		return resultado;
	}
}
