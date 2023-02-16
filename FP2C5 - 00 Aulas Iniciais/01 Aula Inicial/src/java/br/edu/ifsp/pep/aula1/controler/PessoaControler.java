package br.edu.ifsp.pep.aula1.controler;

import br.edu.ifsp.pep.aula1.entity.Pessoa;
import br.edu.ifsp.pep.aula1.util.Mensagem;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@Named
//@RequestScoped Menor tempo de vida, sempre que for requisitado, cria um novo controler
@SessionScoped // Maior tempo de vida, uma sessão inteira
public class PessoaControler implements Serializable{

    private Pessoa pessoa;
    private List<Pessoa> listaPessoas;
    
    private LocalDate dataMinima = LocalDate.now().minusWeeks(1);
    private LocalDate dataMaxima = LocalDate.now().plusWeeks(1);
    
    // Servidor instancia por padrão o construtor vazio
    // Necessário instaciar as demais classes para funcionar, usando um construtor vazio
    public PessoaControler() {
        this.pessoa = new Pessoa();
        this.listaPessoas = new ArrayList<>();
    }
        
    public void dizerOla() {
        this.listaPessoas.add(pessoa);
        this.pessoa = new Pessoa();
        this.listarPessoas();
        System.out.println("Olá");
        
        if (this.pessoa.getNome() == null ||
                this.pessoa.getNome().length() < 5) {
            Mensagem.warn("Informe um nome válido");
            return;
            
        }
        
        Mensagem.info("Pessoa Cadastrada");
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

    public LocalDate getDataMinima() {
        return dataMinima;
    }

    public LocalDate getDataMaxima() {
        return dataMaxima;
    }
    
}
