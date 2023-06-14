package br.edu.ifsp.pep.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ValoresNumericos {

    private List<Number> valores;
    
    public ValoresNumericos (){
        Random random = new Random();
        this.valores = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            valores.add(random.nextInt(9000) + 1000);
        }
    }

    public List<Number> gerarValores() {
       Random random = new Random();
        this.valores = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            valores.add(random.nextInt(9000) + 1000);
        }
        return valores;
    }
}
