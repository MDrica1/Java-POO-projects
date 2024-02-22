import java.util.ArrayList;
import java.util.Scanner;

/*
FALTA:

1. Possibilitar que o consultar( ) retorne todos, só marcados ou só não marcados.
2. Método filtrar() por categorias.

 */
public class App {
    static ArrayList<Tarefa> tarefas = new ArrayList<>();



    public static void adicionar(Scanner novaTarefa) {
        System.out.print("Título da tarefa: ");
        String titulo = novaTarefa.nextLine();

        System.out.print("Descrição: ");
        String descricao = novaTarefa.nextLine();

        System.out.println("Digite o NÚMERO da categoria:\n" + "1 - Trabalho;\n" + "2 - Casa;\n" + "3 - Saúde e bem estar;\n" + "4 - Estudos;\n" + "5 - Religião;\n" + "6 - Lazer;\n" + "7 - Outros.");
        int categoria = novaTarefa.nextInt();

        Tarefa t1 = new Tarefa(titulo, descricao, categoria);
        tarefas.add(t1);
    }

    public static void remover(Tarefa t1) {
        tarefas.remove(t1);
    }


    public static void main(String[] args) {

        Scanner novaTarefa = new Scanner(System.in);
        int cont = 1;
        ArrayList<Integer> numerosTarefas = new ArrayList<>();

        while (true) {
            System.out.println("TAREFA "+cont+": ");

            adicionar(novaTarefa);
            numerosTarefas.add(cont);

            System.out.println("Essa tarefa foi finalizada? (s/n)");
            String resposta1 = novaTarefa.next();
            if (resposta1.equalsIgnoreCase("s")) {
                tarefas.get(cont - 1).marcar();
            } else {
                tarefas.get(cont - 1).desmarcar();
            }

            System.out.print("Deseja adicionar outra tarefa? (s/n): ");
            String resposta = novaTarefa.next();

            if (!resposta.equalsIgnoreCase("s")) {
                break; // Sai do loop se a resposta não for "s"
            }

            cont +=1;
            novaTarefa.nextLine(); // Limpa o buffer do scanner
        }

        //t1.marcar();
        //t1.desmarcar();

        for (int i = 0; i < tarefas.size(); i++){
            System.out.println("TAREFA " + numerosTarefas.get(i) + "\n");
            System.out.println(tarefas.get(i).consultar()+"\n");
        }
    }
}
