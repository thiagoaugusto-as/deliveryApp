package main;

import javax.swing.JOptionPane;

/**
 * Classe com o método principal para iniciar a aplicação
 */
public class App {
    public static void main(String[] args) {

        int opcao;
        Pedido pedido = new Pedido(1001);
        Object[] op = { "Remover pedido", "Adicionar Pedido", "Finalizar carrinho" };
        Object select = op[1];

        //Detalhes do pedido

        do {

            select = JOptionPane.showInputDialog(null,"Escolha um item", "Opçao", JOptionPane.INFORMATION_MESSAGE, null, op, op [0]);

            if(select == op[0]) {
                pedido.imprime();
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Remover qual item?"));
                pedido.removeItem(opcao-1);
            } else if(select == op[1]) {
                String nome_pedido = JOptionPane.showInputDialog("Produto: ");
                Double preco_pedido = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço do produto: "));
    
                Cardapio cardapio = new Cardapio();
                cardapio.listAll();
    
                pedido.adicionaItem(new Item(nome_pedido,preco_pedido));
            }

            System.out.println(select);

        } while(select != op[2]);

        //Dados de pagamento

        Object[] pagamento = { "Cartão", "Boleto", "Pagar na Entrega" };
        select = JOptionPane.showInputDialog(null,"Forma de pagamento", "Opçao", JOptionPane.INFORMATION_MESSAGE, null, pagamento, pagamento [0]);
        pedido.imprime();

        if (select == pagamento[0]) {
            CartaoCredito cartaoCredito = new CartaoCredito();
            cartaoCredito.leitura();
            cartaoCredito.processamento();
            cartaoCredito.emissao(pedido);
        } else if (select == pagamento[1]) {
            Boleto boleto = new Boleto();
            boleto.leitura();
            boleto.processamento();
            boleto.processamento();
            boleto.emissao(pedido);
        } else if (select == pagamento[2]) {
            EntregaPagamento entregaPagamento = new EntregaPagamento();
            entregaPagamento.pagamento();
        }
        
        //Dados de entrega

        Endereco endereco = new Endereco();
        endereco.insere();

        Object[] options = { "OK" };
        JOptionPane.showOptionDialog(null, "Pedido Realizado!", "Obrigado pela preferência! ", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
    }
}
