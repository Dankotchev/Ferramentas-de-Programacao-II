package br.edu.ifsp.pep.tables.controller;

import br.edu.ifsp.pep.tables.model.Produto;
import br.edu.ifsp.pep.tables.services.ProdutoDAO;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import util.Mensagem;

@Named
@SessionScoped
public class ProdutoController implements Serializable {

    // Servidor responsável por instanciar o DAO
    @EJB
    private ProdutoDAO produtoDAO;

    private List<Produto> listaProduto;
    private Produto produtoSelecionado;
    private Produto produtoInserir = new Produto();

    public void cadastrarProduto () {
        this.produtoDAO.inserir(produtoInserir);
        this.produtoInserir = new Produto();
        this.listaProduto = null;   // Para atualizar a lista de produtos
        Mensagem.info("Produto cadastrado");
    }
    
    public String alterarProduto(){
        this.produtoDAO.atualizar(produtoSelecionado);
        this.produtoSelecionado = null;
        return "/produto/lista";
    }

    public void exibir () {
        System.out.println(produtoSelecionado.getName());
    }

    public void removerProduto() {
        this.produtoDAO.remover(produtoSelecionado);
        this.produtoSelecionado = null;
        this.listaProduto = null;   // Para atualizar a lista de produtos
        Mensagem.info("Produto removido");
    }

    public List<Produto> getListaProduto () {
        // Reduzi o acesso ao banco de dados
        if (listaProduto == null) {
            listaProduto = produtoDAO.buscarTodos();
        }
        return listaProduto;
    }
       
    //
    public void setListaProduto (List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public Produto getProdutoSelecionado () {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado (Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

    public Produto getProdutoInserir () {
        return produtoInserir;
    }

    public void setProdutoInserir (Produto produtoInserir) {
        this.produtoInserir = produtoInserir;
    }
}
