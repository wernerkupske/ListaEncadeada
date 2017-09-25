/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaencadeada;

import java.util.Scanner;

/**
 *
 * @author informatica
 */

/*
    Fazer um programa para a realização das seguintes operações com uma lista encadeada simples não circular:

        - incluir um objeto no início na lista

        - incluir um objeto no final da lista

        - verificar se um objeto específico está na lista

        - remover um objeto específico da lista

        - remover o primeiro objeto da lista

        - remover o último objeto da lista

        - mostrar todos os objetos da lista na ordem do primeiro para o último

        - mostrar todos os objetos da lista na ordem do último para o primeiro
 */
public class Metodos {

    Scanner tec = new Scanner(System.in);

    public void insereInicio() {
        Aluno a1 = new Aluno("Augusto", 10);
        Aluno inicio = a1;
        Aluno novo = new Aluno();
        novo.proximo = inicio;
        inicio = novo;
    }

    public void InsereFim() {

    }

    public void verificaLista() {
        System.out.println("Digite o código do aluno: ");
        int cod = 0;
        cod = tec.nextInt();
    }

    public void removeDaLista() {

    }

    public void removePrimeiro() {

    }

    public void removeUltimo() {

    }

    public void mostraListaPrimeiroUltimo() {

    }

    public void mostraListaUltimoPrimeiro() {

    }
}
