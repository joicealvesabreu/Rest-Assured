package br.com.caelum.leilao.teste;

import static org.junit.Assert.*;
import static com.jayway.restassured.RestAssured.given;
import java.util.List;

import org.junit.Test;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;

import br.com.caelum.leilao.modelo.Usuario;

public class UsuariowTestes {

	@Test
	public void deveretormarlistadeusuario() {

		XmlPath path = given().header("Accept", "application/xml").get("/usuarios").andReturn().xmlPath();

		List<Usuario> usuarios = path.getList("list.usuario", Usuario.class);

		// Usuario usuario1 = path.getObject("list.usuario[0]", Usuario.class);
		// Usuario usuario2 = path.getObject("list.usuario[1]", Usuario.class);

		Usuario esperado1 = new Usuario(1L, "Mauricio Aniche", "mauricio.aniche@caelum.com.br");
		Usuario esperado2 = new Usuario(2L, "Guilherme Silveira", "guilherme.silveira@caelum.com.br");

		assertEquals(esperado1, usuarios.get(0));
		assertEquals(esperado2, usuarios.get(1));

	}

	@Test
	public void deveRetornarusuariopeloid() {

		JsonPath path = given().header("Accept", "application/json").parameter("usuario.id", 1).get("/usuarios/show")
				.andReturn().jsonPath();

		Usuario usuarios = path.getObject("usuario", Usuario.class);
		Usuario esperado1 = new Usuario(1L, "Mauricio Aniche", "mauricio.aniche@caelum.com.br");
		assertEquals(esperado1, usuarios);
	}

	@Test
	public void deveRetornarQuantidadeDeLeiloes() {
		XmlPath path = given().header("Accept", "application/xml").get("/leiloes/total").andReturn().xmlPath();

		int total = path.getInt("int");

		assertEquals(2, total);
	}
}