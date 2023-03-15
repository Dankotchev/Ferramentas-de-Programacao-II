package br.edu.ifsp.pep.tables.controller;

import br.edu.ifsp.pep.tables.model.Produto;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ProdutoController implements Serializable{

    private List<Produto> listaProduto;
    private Produto produtoSelecionado;

    @PostConstruct
    public void init() {
        listaProduto = new ArrayList<>();
        listaProduto.add(new Produto(1000, "f230fh0g3", "Bamboo Watch", "Descrição do Produto", "bamboo-watch.jpg", 65,
                "Accessories", 24, 5));
        listaProduto.add(new Produto(1001, "nvklal433", "Black Watch", "Descrição do Produto", "black-watch.jpg", 72,
                "Accessories", 61, 4));
        listaProduto.add(new Produto(1002, "zz21cz3c1", "Blue Band", "Descrição do Produto", "blue-band.jpg", 79,
                "Fitness", 2, 3));
        listaProduto.add(new Produto(1003, "244wgerg2", "Blue T-Shirt", "Descrição do Produto", "blue-t-shirt.jpg", 29,
                "Clothing", 25, 5));
        listaProduto.add(new Produto(1004, "h456wer53", "Bracelet", "Descrição do Produto", "bracelet.jpg", 15,
                "Accessories", 73, 4));
        listaProduto.add(new Produto(1005, "av2231fwg", "Brown Purse", "Descrição do Produto", "brown-purse.jpg", 120,
                "Accessories", 0, 4));
        listaProduto.add(new Produto(1006, "bib36pfvm", "Chakra Bracelet", "Descrição do Produto", "chakra-bracelet.jpg", 32,
                "Accessories", 5, 3));
        listaProduto.add(new Produto(1007, "mbvjkgip5", "Galaxy Earrings", "Descrição do Produto", "galaxy-earrings.jpg", 34,
                "Accessories", 23, 5));
        listaProduto.add(new Produto(1008, "vbb124btr", "Game Controller", "Descrição do Produto", "game-controller.jpg", 99,
                "Electronics", 2, 4));
        listaProduto.add(new Produto(1009, "cm230f032", "Gaming Set", "Descrição do Produto", "gaming-set.jpg", 299,
                "Electronics", 63, 3));
        listaProduto.add(new Produto(1010, "plb34234v", "Gold Phone Case", "Descrição do Produto", "gold-phone-case.jpg", 24,
                "Accessories", 0, 4));
        listaProduto.add(new Produto(1011, "4920nnc2d", "Green Earbuds", "Descrição do Produto", "green-earbuds.jpg", 89,
                "Electronics", 23, 4));
        listaProduto.add(new Produto(1012, "250vm23cc", "Green T-Shirt", "Descrição do Produto", "green-t-shirt.jpg", 49,
                "Clothing", 74, 5));
        listaProduto.add(new Produto(1013, "fldsmn31b", "Grey T-Shirt", "Descrição do Produto", "grey-t-shirt.jpg", 48,
                "Clothing", 0, 3));
        listaProduto.add(new Produto(1014, "waas1x2as", "Headphones", "Descrição do Produto", "headphones.jpg", 175,
                "Electronics", 8, 5));
        listaProduto.add(new Produto(1015, "vb34btbg5", "Light Green T-Shirt", "Descrição do Produto", "light-green-t-shirt.jpg", 49,
                "Clothing", 34, 4));
        listaProduto.add(new Produto(1016, "k8l6j58jl", "Lime Band", "Descrição do Produto", "lime-band.jpg", 79,
                "Fitness", 12, 3));
        listaProduto.add(new Produto(1017, "v435nn85n", "Mini Speakers", "Descrição do Produto", "mini-speakers.jpg", 85,
                "Clothing", 42, 4));
        listaProduto.add(new Produto(1018, "09zx9c0zc", "Painted Phone Case", "Descrição do Produto", "painted-phone-case.jpg", 56,
                "Accessories", 41, 5));
        listaProduto.add(new Produto(1019, "mnb5mb2m5", "Pink Band", "Descrição do Produto", "pink-band.jpg", 79,
                "Fitness", 63, 4));
        listaProduto.add(new Produto(1020, "r23fwf2w3", "Pink Purse", "Descrição do Produto", "pink-purse.jpg", 110,
                "Accessories", 0, 4));
        listaProduto.add(new Produto(1021, "pxpzczo23", "Purple Band", "Descrição do Produto", "purple-band.jpg", 79,
                "Fitness", 6, 3));
        listaProduto.add(new Produto(1022, "2c42cb5cb", "Purple Gemstone Necklace", "Descrição do Produto", "purple-gemstone-necklace.jpg", 45,
                "Accessories", 62, 4));
        listaProduto.add(new Produto(1023, "5k43kkk23", "Purple T-Shirt", "Descrição do Produto", "purple-t-shirt.jpg", 49,
                "Clothing", 2, 5));
        listaProduto.add(new Produto(1024, "lm2tny2k4", "Shoes", "Descrição do Produto", "shoes.jpg", 64,
                "Clothing", 0, 4));
        listaProduto.add(new Produto(1025, "nbm5mv45n", "Sneakers", "Descrição do Produto", "sneakers.jpg", 78,
                "Clothing", 52, 4));
        listaProduto.add(new Produto(1026, "zx23zc42c", "Teal T-Shirt", "Descrição do Produto", "teal-t-shirt.jpg", 49,
                "Clothing", 3, 3));
        listaProduto.add(new Produto(1027, "acvx872gc", "Yellow Earbuds", "Descrição do Produto", "yellow-earbuds.jpg", 89,
                "Electronics", 35, 3));
        listaProduto.add(new Produto(1028, "tx125ck42", "Yoga Mat", "Descrição do Produto", "yoga-mat.jpg", 20,
                "Fitness", 15, 5));
        listaProduto.add(new Produto(1029, "gwuby345v", "Yoga Set", "Descrição do Produto", "yoga-set.jpg", 20,
                "Fitness", 25, 5));
    }
    
    public void exibir(){
        System.out.println(produtoSelecionado.getName());
    }
    
    public void remover(){
        listaProduto.remove(produtoSelecionado);
    }
    
    // Levando diretamente para a home usando atributo action
    public String gotHome(){
        return "/index";
    }
       
    //
    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }
    
}
