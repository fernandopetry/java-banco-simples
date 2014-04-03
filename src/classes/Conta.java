package classes;

import javax.swing.JOptionPane;

/**
 * Classe responsavel em gerenciar a conta bancaria
 * @author Fernando
 */
public class Conta {
    Cliente cliente;

    /**
     * M�todo construtor da classe
     * @param cliente instancia de cliente
     */
    public Conta(Cliente cliente) {
        this.cliente = cliente;
    }
    
    //**************************************************************************
    // OPERACOES
    //**************************************************************************
    /**
     * Efetua um saque na conta
     * @param msg Mensagem do JOptionPane
     * @return
     */
    public double sacar(String msg) {
        double valorSacar = this.resgataValor(msg);
        this.sacarTransparente(valorSacar);
        return valorSacar;
    }

    /**
     * Efetua um saque transparente ao usuario, n�o emite nenhuma mensagem ou
     * alerta
     * @param valorSacar Valor a ser sacado da conta
     */
    public boolean sacarTransparente(double valorSacar) {
        if (valorSacar > this.cliente.getSaldo()) {
            JOptionPane.showMessageDialog(null, "\nOpera��o n�o efetuada, conta com saldo insuficiente\n");
            return false;
        } else {
//            double saldoModificado = (this.cliente.getSaldo()-valorSacar);
//            this.cliente.setSaldo(saldoModificado);
            this.cliente.setSaldo(this.cliente.getSaldo()-valorSacar);
            return true;
        } 
    }

    /**
     * Efetua um deposito na conta
     * @param msg Mensagem do JOptionPane
     * @return
     */
    public double depositar(String msg) {
        double valorDepositar = this.resgataValor(msg);
        this.depositarTransparente(valorDepositar);
        return valorDepositar;
    }

    /**
     * Efetua um deposito transparente ao usuario, n�o emite nenhuma mensagem ou
     * alerta
     * @param valorDepositar valor a ser depositado
     */
    public void depositarTransparente(double valorDepositar) {
        this.cliente.setSaldo(this.cliente.getSaldo()+valorDepositar);
    }

    /**
     * M�todo transferencia de valor
     * @param origem Instancia da classe conta, sendo a conta de origem da transferencia
     * @param destino Instancia da classe conta, sendo a conta que recebe a transferencia
     */
    public void transfere(Conta origem, Conta destino) {
        double valorDeTransferencia = this.resgataValor("Digite o valor a transferir");
        // Origem do saque
        if (origem.sacarTransparente(valorDeTransferencia)) {
            // Destino do saque anterior
            destino.depositarTransparente(valorDeTransferencia);

            JOptionPane.showMessageDialog(null, "\nTransferencia efetuada de \n" + origem.cliente.getNome() + " N�(" + origem.cliente.getNumero() + ")"
                    + "\n\npara:\n " + destino.cliente.getNome() + " N�(" + destino.cliente.getNumero() + ")\n");
        }
    }

    /**
     * Este m�todo resgata um valor para ser utilizado em sacar, depositar e
     * transferir
     * @param mensagem mensagem a se informado ao usuario
     * @return
     */
    public double resgataValor(String mensagem) {
        double valorRetorno = Double.parseDouble(JOptionPane.showInputDialog(mensagem));
        return valorRetorno;
    }

    //**************************************************************************
    // ALERTAS
    //**************************************************************************
    public void alertaSaldo(String tipo) {
        JOptionPane.showMessageDialog(null,
                "Conta " + tipo + " n�: " + this.cliente.getNumero()
                + "\n Nome: " + this.cliente.getNome()
                + " \n Saldo Atual: R$ " + this.cliente.getSaldo());
    }

    /**
     * Exibi o salgo completo
     * @param corrente Instancia da conta corrente
     * @param poupanca Instancia da conta poupanca
     */
    public void alertaSaldoCompleto(Conta corrente, Conta poupanca) {
        JOptionPane.showMessageDialog(null,
                "Conta Corrente n�: " + corrente.cliente.getNumero()
                + "\n Nome: " + corrente.cliente.getNome()
                + " \n Saldo Atual: R$ " + corrente.cliente.getSaldo()
                + " \n \nConta Poupanca n�: " + poupanca.cliente.getNumero()
                + "\n Nome: " + poupanca.cliente.getNome()
                + " \n Saldo Atual: R$ " + poupanca.cliente.getSaldo()
        );
    }

    /**
     * Tela demonstrando as op�oes disponiveis
     * @return int numero da op�ao
     */
    public int opcoesDisponiveis() {
        int opcao = 0;
        while (opcao > 5 || opcao < 1) {

            String num = JOptionPane.showInputDialog(
                    "Digite a op��o desejada:"
                    + "\n 1 - Depositar"
                    + "\n 2 - Sacar"
                    + "\n 3 - Transferir"
                    + "\n 4 - Saldo"
                    + "\n 5 - Sair");
            opcao = Integer.parseInt(num);

            if (opcao > 5 || opcao < 1) {
                JOptionPane.showMessageDialog(null, "\nEscolha um n� entre 1 e 5 - tente novamente\n");
            }
        }

        return opcao;
    }

    /**
     * Tela demonstrando as op�oes disponiveis para transferencia
     * @return int numero da op�ao
     */
    public int opcoesDisponiveisTransferencia() {
        int opcao = 0;
        while (opcao > 2 || opcao < 1) {

            String num = JOptionPane.showInputDialog(
                    "Digite a op�ao:"
                    + "\n 1 - Transferir de corrente => poupanca"
                    + "\n 2 - Transferir de poupanca => corrente");
            opcao = Integer.parseInt(num);

            if (opcao > 2 || opcao < 1) {
                JOptionPane.showMessageDialog(null, "\nEscolha um n� entre 1 ou 2 - tente novamente\n");
            }
        }

        return opcao;
    }
}
