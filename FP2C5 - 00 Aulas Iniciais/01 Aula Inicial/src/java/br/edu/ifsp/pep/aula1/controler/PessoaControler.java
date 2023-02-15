package br.edu.ifsp.pep.aula1.controler;

import br.edu.ifsp.pep.aula1.entity.Pessoa;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



@Named
//@RequestScoped Menor tempo de vida, sempre que for requisitado, cria um novo controler
@SessionScoped // Maior tempo de vida, uma sessão inteira
public class PessoaControler implements Serializable{

    private Pessoa pessoa;
    private List<Pessoa> listaPessoas;
    
    // Servidor instancia por padrão o construtor vazio
    // Necessário instaciar as demais classes para funcionar, usando um construtor vazio
    public PessoaControler() {
        this.pessoa = new Pessoa();
        this.listaPessoas = new ArrayList<>();
    }
        
    public void dizerOla() {
        this.listaPessoas.add(pessoa);
        this.pessoa = new Pessoa();
        System.out.println("Olá");      
        this.listarPessoas();
    }
    
    private void listarPessoas(){
        for (Pessoa p : listaPessoas) {
            System.out.println(p);
        }
    }

    // Código Gerado e necessário
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getListaPessoas() {
        return listaPessoas;
    }
    
}
