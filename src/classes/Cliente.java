package classes;

import javax.swing.JOptionPane;

/**
 * .nome = 'fernando' .setNome('fernando');
 *
 * .nome .getNome()
 *
 * @author Fernando
 */
public class Cliente {

    /**
     * Nome do Cliente
     */
    private String nome;
    /**
     * Numero da conta do cliente
     */
    private int numero;
    /**
     * Saldo da conta do cliente
     */
    private double saldo;

    //**************************************************************************
    // SETs e GETs
    //**************************************************************************
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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
     * Efetua um saque transparente ao usuario, não emite nenhuma mensagem ou
     * alerta
     * @param valorSacar Valor a ser sacado da conta
     */
    public boolean sacarTransparente(double valorSacar) {
        if (valorSacar > this.getSaldo()) {
            JOptionPane.showMessageDialog(null, "\nOperação não efetuada conta com saldo insuficiente\n");
            return false;
        } else {
            this.saldo -= valorSacar;
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
     * Efetua um deposito transparente ao usuario, não emite nenhuma mensagem ou
     * alerta
     * @param valorDepositar valor a ser depositado
     */
    public void depositarTransparente(double valorDepositar) {
        this.saldo += valorDepositar;
    }

    /**
     * Método responsável em fazer a transferencia entre contas
     * @param origem Instancia do cliente origem para a transferencia
     * @param destino Instancia do cliente de destino para a transferencia
     */
    public void transfere(Cliente origem, Cliente destino) {
        double valorDeTransferencia = this.resgataValor("Digite o valor a transferir");
        // Origem do saque
        if (origem.sacarTransparente(valorDeTransferencia)) {
            // Destino do saque anterior
            destino.depositarTransparente(valorDeTransferencia);

            JOptionPane.showMessageDialog(null, "\nTransferencia efetuada de \n" + origem.getNome() + " N°(" + origem.getNumero() + ")"
                    + "\n\npara:\n " + destino.getNome() + " N°(" + destino.getNumero() + ")\n");
        }
    }

    /**
     * Este método resgata um valor para ser utilizado em sacar, depositar e
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
                "Conta " + tipo + " nº: " + this.numero
                + "\n Nome: " + this.nome
                + " \n Saldo Atual: R$ " + this.saldo);
    }

    /**
     * Exibi o salgo completo
     * @param corrente Instancia da conta corrente
     * @param poupanca Instancia da conta poupanca
     */
    public void alertaSaldoCompleto(Cliente corrente, Cliente poupanca) {
        JOptionPane.showMessageDialog(null,
                "Conta Corrente nº: " + corrente.numero
                + "\n Nome: " + corrente.nome
                + " \n Saldo Atual: R$ " + corrente.saldo
                + " \n \nConta Popanca nº: " + poupanca.numero
                + "\n Nome: " + poupanca.nome
                + " \n Saldo Atual: R$ " + poupanca.saldo
        );
    }

    /**
     * Tela demonstrando as opçoes disponiveis
     * @return int numero da opçao
     */
    public int opcoesDisponiveis() {
        int opcao = 0;
        while (opcao > 5 || opcao < 1) {

            String num = JOptionPane.showInputDialog(
                    "Digite a opção desejada:"
                    + "\n 1 - Depositar"
                    + "\n 2 - Sacar"
                    + "\n 3 - Transferir"
                    + "\n 4 - Saldo"
                    + "\n 5 - Sair");
            opcao = Integer.parseInt(num);

            if (opcao > 5 || opcao < 1) {
                JOptionPane.showMessageDialog(null, "\nEscolha um nº entre 1 e 5 - tente novamente\n");
            }
        }

        return opcao;
    }

    /**
     * Tela demonstrando as opçoes disponiveis para transferencia
     * @return int numero da opçao
     */
    public int opcoesDisponiveisTransferencia() {
        int opcao = 0;
        while (opcao > 2 || opcao < 1) {

            String num = JOptionPane.showInputDialog(
                    "Digite a opçao:"
                    + "\n 1 - Transferir de corrente para poupanca"
                    + "\n 2 - Transferir de poupanca para corrente");
            opcao = Integer.parseInt(num);

            if (opcao > 2 || opcao < 1) {
                JOptionPane.showMessageDialog(null, "\nEscolha um nº entre 1 ou 2 - tente novamente\n");
            }
        }

        return opcao;
    }
}
