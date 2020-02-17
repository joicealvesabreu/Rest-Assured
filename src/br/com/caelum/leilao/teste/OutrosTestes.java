package br.com.caelum.leilao.teste;

import static com.jayway.restassured.RestAssured.expect;

import org.junit.Test;





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
