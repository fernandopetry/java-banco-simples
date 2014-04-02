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
}
