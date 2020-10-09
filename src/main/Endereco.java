package main;

import javax.swing.JOptionPane;

public class Endereco {

    private String rua;
    private String bairro;
    private String cep;
    private int numero;

    /**
     * Método construtor da classe
     */
    public Endereco() {
        this.rua = this.bairro = this.cep = "";
        this.numero = Integer.MIN_VALUE;
    }

    public void insere() {
        do {
            this.rua = JOptionPane.showInputDialog(null, "Rua");
        } while (this.rua.equals(""));

        do {
            this.bairro = JOptionPane.showInputDialog(null, "Bairro");
        } while (this.bairro.equals(""));

        do {
            this.cep = JOptionPane.showInputDialog(null, "Cep");
        } while (this.cep.equals(""));
        
        do {
            this.numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Número"));
        } while (this.numero <= 0);
    }

}
