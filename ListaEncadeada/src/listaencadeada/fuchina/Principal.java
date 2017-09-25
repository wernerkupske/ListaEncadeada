package listaencadeada.fuchina;
 
public class Principal {
 
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
   
    Alunos inicio = null;
    Alunos termino = null;
    Alunos aluno = new Alunos();
 
    //- Incluir um objeto no início na lista:
    public void incluirNoInicio() {
        int cod = aluno.pedeInteiro("Informe o código do aluno: ", 0, 10);
        String nome = aluno.pedeNome();
        Alunos novoAluno = new Alunos(cod, nome, inicio);
        inicio = novoAluno;
        if (termino == null) {
            termino = novoAluno;
            termino.proximo = null;
        }
    }
 
    //- Incluir um objeto no final da lista:
    public void incluirNoFinal() {
        int cod = aluno.pedeInteiro("Informe o código do aluno: ", 0, 10);
        String nome = aluno.pedeNome();
        Alunos novoAluno = new Alunos(cod, nome, termino);
        if (inicio == null) {
            inicio = novoAluno;
            termino = novoAluno;
        } else {
            termino.proximo = novoAluno;
            termino = novoAluno;
        }
        termino.proximo = null;
    }
 
    //- Verificar se um objeto específico está na lista:
    public void verificaAluno() {
        Alunos atual = inicio;
        boolean existe = false;
        int aux = aluno.pedeInteiro("Informe o código do aluno: ", 0, 10);
        while (atual != null) {
            if (atual.codigo == aux) {
                existe = true;
            }
            atual = atual.proximo;
        }
        if (existe) {
            System.out.println("O aluno está na lista.");
        } else {
            System.out.println("Não há aluno com esse código na lista.");
        }
    }
 
    //- Remover um objeto específico da lista:
    public void removeAluno() {
        Alunos atual = inicio;
        Alunos aux2;
        boolean existe = false;
        int aux = aluno.pedeInteiro("Informe o código do aluno: ", 0, 10);
        if (aux == inicio.codigo) {
            removePrimeiroAluno();
            existe = true;
        } else if (aux == termino.codigo) {
            removeUltimoAluno();
            existe = true;
        } else {
            while (atual != null) {
                if (atual.codigo == aux) {
                    aux2 = encontrarAlunoAnterior(atual);
                    aux2.proximo = atual.proximo;
                    atual.proximo = null;
                    existe = true;
                }
                atual = atual.proximo;
            }
        }
        if (existe) {
            System.out.println("Aluno removido com sucesso.");
        } else {
            System.out.println("Não existe aluno com esse código na lista.");
        }
    }
 
    //- Remover o primeiro objeto da lista:
    public void removePrimeiroAluno() {
        if (inicio == null) {
            System.out.println("Não há alunos na lista.");
        } else {
            inicio = inicio.proximo;
        }
    }
 
    //- Remover o último objeto da lista:
    public void removeUltimoAluno() {
        if (termino == null) {
            System.out.println("Não há alunos na lista.");
        } else {
            if (inicio == termino) {
                inicio = null;
                termino = null;
            } else {
                Alunos atual = inicio;
                while (atual != null) {
                    if (atual.proximo == termino) {
                        atual.proximo = null;
                        termino = atual;
                    }
                    atual = atual.proximo;
                }
            }
        }
    }
 
    //- Mostrar todos os objetos da lista na ordem do primeiro para o último:
    public void mostraListaCrescente() {
        if (inicio == null) {
            System.out.println("Não há alunos na lista.");
        } else {
            Alunos atual = inicio;
            do {
                System.out.println("Código: "+atual.codigo + " Nome: " + atual.nome);
                atual = atual.proximo;
            } while (atual != null);
        }
    }
 
    public Alunos encontrarAlunoAnterior(Alunos aluno) {
        this.aluno = inicio;
        while (this.aluno.proximo != aluno) {
            this.aluno = this.aluno.proximo;
        }
        return this.aluno;
    }
 
    public void mostraOpcoes() {
        int aux;
        do {
            aux = aluno.pedeInteiro("Informe o que deseja fazer: \n"
                    + "1 - Inserir objeto no início da lista. \n"
                    + "2 - Inserir objeto no final da lista. \n"
                    + "3 - Verifica objeto específico na lista. \n"
                    + "4 - Remove objeto específico da lista. \n"
                    + "5 - Remove primeiro objeto da lista. \n"
                    + "6 - Remove último objeto da lista. \n"
                    + "7 - Mostrar do primeiro ao último objeto. \n"
                    + "8 - Sair.", 1, 8);
            switch (aux) {
                case 1:
                    incluirNoInicio();
                    break;
                case 2:
                    incluirNoFinal();
                    break;
                case 3:
                    verificaAluno();
                    break;
                case 4:
                    removeAluno();
                    break;
                case 5:
                    removePrimeiroAluno();
                    break;
                case 6:
                    removeUltimoAluno();
                    break;
                case 7:
                    mostraListaCrescente();
                    break;
            }
        } while (aux != 8);
    }
 
    public static void main(String[] args) {
        Principal p = new Principal();
        p.mostraOpcoes();
    }
}