package main;

import javax.swing.JOptionPane;

public class EntregaPagamento {

    private Double troco;
    private Object cartao;
    Object[] cartao_list = { "Visa", "Mastercard", "Elo" };
    Object[] pagamento = { "Dinheiro", "Cartao" };

    /**
     * Método construtor da classe
     */
    public EntregaPagamento() {
        this.troco = Double.MIN_VALUE;
    }

    public void pagamento() {

        Object select = JOptionPane.showInputDialog(null,"Forma de pagamento", "Opçao", JOptionPane.INFORMATION_MESSAGE, null, pagamento, pagamento [0]);

        if(select == pagamento[0]) {
            this.troco = Double.parseDouble(JOptionPane.showInputDialog(null, "Troco"));
        } else {
            this.cartao = JOptionPane.showInputDialog(null,"Forma de pagamento", "Opçao", JOptionPane.INFORMATION_MESSAGE, null, cartao_list, cartao_list[0]);
        }
    }

}
