package br.edu.ifsp.pep.agendamento;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import java.time.LocalDateTime;

@Singleton  // Uma unica instância da classe
@Startup    // Cria a classe quando a aplicação inicia
public class Agendamento {

    public Agendamento (){
        System.out.println("----------");
        System.out.println("Construtor Agendamento");
        System.out.println("----------");
    }
    
    @PostConstruct
    public void init(){
        System.out.println("----------");
        System.out.println("Post Construct");
        System.out.println("----------");
    }
    
    @Schedule(hour = "*", minute = "*", second = "0-10,30,40")     // Definindo o agendamento da tarefa
    private void tarefaAgendada(){
        System.out.println("----------");
        System.out.println("Tarefa Agendada");
        System.out.println("Hora: "+ LocalDateTime.now());
        System.out.println("----------");
    }
}
