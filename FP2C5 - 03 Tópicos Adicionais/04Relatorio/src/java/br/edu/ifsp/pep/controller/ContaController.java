package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.ContaCorrente;
import br.edu.ifsp.pep.util.Relatorio;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.primefaces.model.StreamedContent;

@Named
@RequestScoped
public class ContaController {

    public StreamedContent gerarRelatorio() {
        List<ContaCorrente> listaContas = gerarContasCorrentes();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaContas);

        InputStream is = getClass()
                .getResourceAsStream("/br/edu/ifsp/pep/relatorio/relatorio-contas.jasper");

        return Relatorio.gerar(is, null, dataSource);
    }

    private List<ContaCorrente> gerarContasCorrentes() {
        List<ContaCorrente> listaContas = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            listaContas.add(new ContaCorrente(i, i * 1000.0));
        }
        return listaContas;
    }

}
