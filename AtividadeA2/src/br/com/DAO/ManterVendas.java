/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.control.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author erikr
 */
public class ManterVendas extends Conexao{
    
    public void inserir(Venda v) throws Exception {
        abrirBanco();
        String query = "INSERT INTO vendas(codigo,descricao,valor,desconto)"+ "values(null,?,?,?)";
        pst = (PreparedStatement) con.prepareStatement(query);
        pst.setString(1, v.getDescricao());
        pst.setDouble(2, v.getValor());
        pst.setDouble(3, v.getDesconto());
        pst.execute();
        JOptionPane.showMessageDialog(null, "Venda Inserida com sucesso!");
        fecharBanco();
    }
    public ArrayList<Venda> listar() throws Exception{
        ArrayList<Venda> vendas = new ArrayList<Venda>();
         try{
        abrirBanco();
            String query = "SELECT codigo,descricao,valor,desconto FROM vendas";
            pst = con.prepareStatement(query);
            ResultSet tr = pst.executeQuery();
            Venda v;
            while(tr.next()){
                v = new Venda();
                v.setCodigo(tr.getInt("codigo"));
                v.setDescricao(tr.getString("descricao"));
                v.setValor(tr.getDouble("valor"));
                v.setDesconto(tr.getDouble("desconto"));
                vendas.add(v);
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println(e);
        }
         return vendas;
    }
    public Double Somar(){
        double soma = 0;
         try{
        abrirBanco();
            String query = "SELECT sum(valor-desconto) as valor_total FROM vendas";
            pst = con.prepareStatement(query);
            ResultSet tr = pst.executeQuery();
            while(tr.next()){
             soma=tr.getDouble("valor_total");
            }
            fecharBanco();
         }catch(Exception e){
             System.out.println(e);
         }
         return soma;
    }
    public void deletar(Venda v) throws Exception {
        abrirBanco();
        String query = "delete from vendas where codigo=?";
        pst = (PreparedStatement) con.prepareStatement(query);
        pst.setInt(1, v.getCodigo());
        pst.execute();
        JOptionPane.showMessageDialog(null, "Venda deletada com sucesso!");
        fecharBanco();
}
}