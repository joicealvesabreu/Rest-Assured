package br.com.caelum.leilao.teste;

import static com.jayway.restassured.RestAssured.expect;
import static org.junit.Assert.*;

import org.junit.Test;

import com.jayway.restassured.path.xml.XmlPath;

import br.com.caelum.leilao.modelo.Usuario;

public class OutrosTestes {

	// gerar um cookies
	@Test
    public void deveGerarUmCookie() {
    	
        expect()
            .cookie("rest-assured", "funciona")
        .when()
            .get("/cookie/teste");
    }

	@Test
    public void deveGerarumHeader() {
		
		expect().header("novo-header", "abc")
		 .get("/cookie/teste");
	
	
	}
}
