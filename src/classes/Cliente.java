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
    public void sacar() {
        double valorSacar = this.resgataValor("Digite o valor a sacar: ");
        this.saldo -= valorSacar;
    }

    public void depositar() {
        double valordepositar = this.resgataValor("Digite o valor a depositar: ");
        this.saldo += valordepositar;
    }

    /**
     * Este método resgata um valor para ser utilizado em sacar, depositar e
     * transferir
     *
     * @param mensagem mensagem a se informado ao usuario
     * @return
     */
    private double resgataValor(String mensagem) {
        double valorRetorno = Double.parseDouble(JOptionPane.showInputDialog(mensagem));
        return valorRetorno;
    }

    //**************************************************************************
    // ALERTAS
    //**************************************************************************
    public void alertaSaldo() {
        JOptionPane.showMessageDialog(null,
                "Conta Corrente nº: " + this.numero
                + "\n Nome: " + this.nome
                + " \n Saldo Atual: R$ " + this.saldo);
    }

    /**
     * Tela demonstrando as opçoes disponiveis
     *
     * @return
     */
    public int opcoesDisponiveis() {
        int opcao = 0;
        while (opcao > 4 || opcao < 1) {

            String num = JOptionPane.showInputDialog(
                    "Digite a opção desejada:"
                    + "\n 1 - Depositar"
                    + "\n 2 - Sacar"
                    + "\n 3 - Transferir"
                    + "\n 4 - Sair");
            opcao = Integer.parseInt(num);

            if (opcao > 4 || opcao < 1) {
                JOptionPane.showMessageDialog(null, "\nEscolha um nº entre 1 e 4 - tente novamente\n");
            }
        }

        return opcao;
    }
}
