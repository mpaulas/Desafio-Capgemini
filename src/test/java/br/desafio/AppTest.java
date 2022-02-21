package br.desafio;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    @Test
    public void validarImpressaoDeTextoEmEscada() {
        int numero = 10;
        Assert.assertTrue("Falha ao realizar impressão, pois o número informado é negativo ou zero.", App.imprimirTextoEmEscada(numero));
    }

    @Test
    public void validarSenhaForte() {
        String senha = "1Bb!00";
        Assert.assertTrue("Falha ao validar se a senha informada é forte.", App.validarSenhaForte(senha));
        System.out.println("A senha informada cumpre todos os requisitos. [ Senha: " + senha + " ]");
    }

}
