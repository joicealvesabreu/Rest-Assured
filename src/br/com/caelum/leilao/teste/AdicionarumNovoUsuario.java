package br.com.caelum.leilao.teste;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.*;

import org.junit.Test;

import com.jayway.restassured.path.xml.XmlPath;

import br.com.caelum.leilao.modelo.Usuario;

public class AdicionarumNovoUsuario {

	@Test
	public void deveAdicionarumNovoUsuario() {

		Usuario joao = new Usuario("Joice Natalice", "joice@natalice.com");

		XmlPath path = given().header("Accept", "application/xml").contentType("application/xml").body(joao).expect()
				.statusCode(200).when().post("/usuarios").andReturn().xmlPath();

		Usuario resposta = path.getObject("usuario", Usuario.class);
		assertEquals("Joice Natalice", resposta.getNome());
		assertEquals("joice@natalice.com", resposta.getEmail());
		
		// se o meu serviço web não é localhost:8080 da para configurar
		// COMO ABAIXO
		
		//	essa parte posso colocar em um before 
		//RestAssured.baseURI = "http://www.meuendereco.com.br";
		//RestAssured.port = 80;

	}
	
}