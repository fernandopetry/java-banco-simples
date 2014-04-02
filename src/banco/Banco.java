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

        // EXIBINDO SALDO INICIAL CONTA CORRENTE
        corrente.alertaSaldo();

        // MENU DE OPCOES
        int opcao = 0;
        while (opcao != 4) {
            // RESGATA A OPCAO DO USUARIO
            opcao = corrente.opcoesDisponiveis();

            switch (opcao) {
                case 1:
                    // DEPOSITANDO VALOR
                    corrente.depositar();
                    // MOSTRANDO SALDO
                    corrente.alertaSaldo();
                    break;
                case 2:
                    // SACANDO VALOR
                    corrente.sacar();
                    // MOSTRANDO SALDO
                    corrente.alertaSaldo();
                    break;
            }

        } //END WHILE

        JOptionPane.showMessageDialog(null,"Fim");
    }

}
