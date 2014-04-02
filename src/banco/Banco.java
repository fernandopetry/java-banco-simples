/**
 * Banco UNASP
 */
package banco;

import classes.*;
import javax.swing.JOptionPane;

/**
 * Principal
 *
 * @author Fernando
 */
public class Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // CONTA CORRENTE
        Cliente corrente = new Cliente();
        corrente.setNumero(1);
        corrente.setNome("Eny Antonianca");
        corrente.setSaldo(1000);

        // CONTA POUPANCA
        Cliente poupanca = new Cliente();
        poupanca.setNumero(2);
        poupanca.setNome("Eny Antonianca");
        poupanca.setSaldo(2000);

        // EXIBINDO SALDO INICIAL COMPLETO
        corrente.alertaSaldoCompleto(corrente, poupanca);

        // MENU DE OPCOES
        int opcao = 0;
        while (opcao != 5) {
            // RESGATA A OPCAO DO USUARIO
            opcao = corrente.opcoesDisponiveis();

            switch (opcao) {
                case 1:
                    // DEPOSITANDO VALOR
                    corrente.depositar("Digite o valor a depositar: ");
                    // MOSTRANDO SALDO
                    corrente.alertaSaldo("Corrente");
                    break;
                case 2:
                    // SACANDO VALOR
                    corrente.sacar("Digite o valor a sacar: ");
                    // MOSTRANDO SALDO
                    corrente.alertaSaldo("Corrente");
                    break;
                case 3:
                    int tipoDeTransferencia = corrente.opcoesDisponiveisTransferencia();

                    if (tipoDeTransferencia == 1) {
                        // TRANSFERENCIA DE CONTA CORRENTE PARA CONTA POUPANCA
                        corrente.transfere(corrente, poupanca);
                    }

                    if (tipoDeTransferencia == 2) {
                        // TRANSFERENCIA DE CONTA POUPANCA PARA CONTA CORRENTE
                        corrente.transfere(poupanca, corrente);
                    }

                    // MOSTRANDO SALDO COMPLETO
                    corrente.alertaSaldoCompleto(corrente, poupanca);
                    break;
                case 4:
                    // MOSTRANDO SALDO COMPLETO
                    corrente.alertaSaldoCompleto(corrente, poupanca);
                    break;
            }

        } //END WHILE

        JOptionPane.showMessageDialog(null, "Obrigado por acessar nosso sistema.");
    }

}
