/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;
/**
 *
 * @author erikr
 */
import java.sql.SQLException;
public class Teste extends Conexao{
    public static void main(String[] args) throws SQLException {
        Conexao cx = new Conexao();
        cx.abrirBanco();
    }
}