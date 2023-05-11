package br.edu.ifsp.pep.util;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

/**
 * Classe para objetos do tipo Mensagens a serem exibidas na aplicação.
 *
 * @author Danilo D. Quirino
 * @version 0.9
 */
public class Mensagem {

    /**
     * Exibe uma mensagem informativa ao usuário.
     *
     * @param mensagem Mensagem a ser exibida.
     */
    public static void info(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Informação:",
                        mensagem)
        );
    }

    /**
     * Exibe uma mensagem informativa ao usuário.
     *
     * @param sumario Sumarização da mensagem.
     * @param mensagem Mensagem a ser exibida.
     */
    public static void info(String sumario, String mensagem) {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        sumario,
                        mensagem)
        );
    }

    /**
     * Exibe uma mensagem de atenção, aviso ao usuário.
     *
     * @param mensagem Mensagem a ser exibida.
     */
    public static void warn(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(
                        FacesMessage.SEVERITY_WARN,
                        "Aviso:",
                        mensagem));
    }

    /**
     * Exibe uma mensagem de atenção, aviso ao usuário.
     *
     * @param sumario Sumarização da mensagem.
     * @param mensagem mensagem a ser exibida.
     */
    public static void warn(String sumario, String mensagem) {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(
                        FacesMessage.SEVERITY_WARN,
                        sumario,
                        mensagem));
    }

    /**
     * Exibe uma mensagem de erro ao usuário.
     *
     * @param mensagem Mensagem a ser exibida.
     */
    public static void error(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(
                        FacesMessage.SEVERITY_ERROR,
                        "Erro:",
                        mensagem));
    }

    /**
     * Exibe uma mensagem de erro ao usuário.
     *
     * @param sumario Sumarização da mensagem.
     * @param mensagem Mensagem a ser exibida.
     */
    public static void error(String sumario, String mensagem) {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(
                        FacesMessage.SEVERITY_ERROR,
                        sumario,
                        mensagem));
    }

    /**
     * Exibe uma mensagem de erro fatal ao usuário.
     *
     * @param mensagem Mensagem a ser exibida.
     */
    public static void fatal(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(
                        FacesMessage.SEVERITY_FATAL,
                        "Fatal!",
                        mensagem));
    }

    /**
     * Exibe uma mensagem de erro fatal ao usuário.
     *
     * @param sumario Sumarização da mensagem.
     * @param mensagem Mensagem a ser exibida.
     */
    public static void fatal(String sumario, String mensagem) {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(
                        FacesMessage.SEVERITY_FATAL,
                        "Fatal!",
                        mensagem));
    }
}