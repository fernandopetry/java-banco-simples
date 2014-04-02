/*
 * Projeto principal do banco
 */
package classes;

import javax.swing.JOptionPane;

/**
 *
 * @author Fernando
 */
public class Home {

    /**
     * Instancia do Cliente 01
     */
    Cliente cliente1;
    /**
     * Instancia do Cliente 02
     */
    Cliente cliente2;

    /**
     * Instancia de Conta Corrente
     */
    ContaCorrente corrente;
    /**
     * Instancia de Conta Poupança
     */
    ContaPoupanca poupanca;

    /**
     * Método construtor da classe
     */
    public Home() {
        // CONTA CORRENTE
        this.cliente1 = new Cliente();
        this.cliente1.setNumero(1);
        this.cliente1.setNome("Eny Antonianca");
        this.cliente1.setSaldo(1000);

        // CONTA POUPANCA
        this.cliente2 = new Cliente();
        this.cliente2.setNumero(2);
        this.cliente2.setNome("Eny Antonianca");
        this.cliente2.setSaldo(2000);

        // CONTA CORRENTE
        this.corrente = new ContaCorrente(this.cliente1);

        // CONTA POUPANCA
        this.poupanca = new ContaPoupanca(this.cliente2);
    }

    /**
     * Efetuando um deposito
     */
    public void deposito() {
        // DEPOSITANDO VALOR
        this.corrente.depositar("Digite o valor a depositar: ");
        // MOSTRANDO SALDO
        this.corrente.alertaSaldo("Corrente");
    }

    /**
     * Efetuando um saque
     */
    public void saque() {
        // SACANDO VALOR
        this.corrente.sacar("Digite o valor a sacar: ");
        // MOSTRANDO SALDO
        this.corrente.alertaSaldo("Corrente");
    }

    /**
     * Efetuando uma transferencia
     */
    public void transferencia() {
        // escolhendo o tipo de tranferencia: (poupanca -> corrente) ou (corrente -> poupanca)
        int tipoDeTransferencia = this.corrente.opcoesDisponiveisTransferencia();

        // TRANSFERENCIA DE CONTA CORRENTE => POUPANCA
        if (tipoDeTransferencia == 1) {
            this.corrente.transfere(this.corrente, this.poupanca);
        }

        // TRANSFERENCIA DE CONTA POUPANCA => CORRENTE
        if (tipoDeTransferencia == 2) {
            this.corrente.transfere(this.poupanca, this.corrente);
        }

        // MOSTRANDO SALDO COMPLETO
        this.corrente.alertaSaldoCompleto(this.corrente, this.poupanca);
    }

    /**
     * Mostrando o Saldo da conta corrente e poupanca
     */
    public void saldoCompleto() {
        // MOSTRANDO SALDO COMPLETO
        this.corrente.alertaSaldoCompleto(this.corrente, this.poupanca);
    }

    /**
     * Mensagem final do sistema
     */
    private void fim() {
        JOptionPane.showMessageDialog(null, "Obrigado por acessar nosso sistema.");
    }

    /**
     * Execução principal do programa
     */
    public void principal() {

        // EXIBINDO SALDO INICIAL COMPLETO
        this.saldoCompleto();

        // MENU DE OPCOES
        int opcao = 0;
        while (opcao != 5) {
            // RESGATA A OPCAO DO USUARIO
            opcao = this.corrente.opcoesDisponiveis();

            switch (opcao) {
                case 1:
                    this.deposito();
                    break;
                case 2:
                    this.saque();
                    break;
                case 3:
                    this.transferencia();
                    break;
                case 4:
                    this.saldoCompleto();
                    break;
            }

        } //END WHILE

        this.fim();
    }
}
