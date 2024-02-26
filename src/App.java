import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/*
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
            System.out.println("TAREFA " + cont + ": ");

            adicionar(novaTarefa);
            numerosTarefas.add(cont);

            System.out.println("Essa tarefa foi finalizada? (s/n): ");
            String resposta1 = novaTarefa.next();
            if (!resposta1.equalsIgnoreCase("n")) {
                tarefas.get(cont - 1).marcar();
            }

            System.out.print("Deseja adicionar outra tarefa? (s/n): ");
            String resposta = novaTarefa.next();

            if (!resposta.equalsIgnoreCase("s")) {
                break;
            }

            cont += 1;
            novaTarefa.nextLine(); // Limpa o buffer do scanner
        }

        Scanner estado = new Scanner(System.in);
        System.out.println("Quais terefas desejas visualizar? (Digite o NÚMERO):\n" + "1 - Exibir TODAS as tarefas" + "\n2 - Exibir tarefas pendentes" + "\n3 - Exibir tarefas finalizadas.");
        int n = estado.nextInt();

        for (int i = 0; i < tarefas.size(); i++) {
            String consulta = tarefas.get(i).consultar(n);
            if (consulta != null) {
                System.out.println("TAREFA " + numerosTarefas.get(i) + "\n");
                System.out.println(consulta + "\n");

            }
        }
        String s2;
        int n2;
        do {
            s2 = "Algo mais? (Digite o NÚMERO):\n" + "1 - Consultar novamente\n2 - Marcar tarefas como concluídas\n3 - Desmarcar tarefas \n4 - Filtrar por categoria \n5 - Não. Até mais!";
            System.out.println(s2);
            n2 = estado.nextInt();

            switch (n2) {
                case 1:
                    System.out.println("Quais tarefas desejas visualizar? (Digite o NÚMERO):\n" + "1 - Exibir TODAS as tarefas" + "\n2 - Exibir tarefas pendentes" + "\n3 - Exibir tarefas finalizadas.");
                    int n3 = estado.nextInt();

                    for (int i = 0; i < tarefas.size(); i++) {
                        String consulta = tarefas.get(i).consultar(n3);
                        if (consulta != null) {
                            System.out.println("TAREFA " + numerosTarefas.get(i) + "\n");
                            System.out.println(consulta + "\n");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Título da tarefa a ser MARCADA:");
                    String tituloTarefa = estado.next();

                    for (Tarefa tarefa : tarefas) {
                        if (tarefa.getTitulo().equals(tituloTarefa)) {
                            tarefa.marcar();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Título da tarefa a ser DESMARCADA:");

                    String tituloTarefaDes = estado.next();

                    for (Tarefa tarefa : tarefas) {
                        if (tarefa.getTitulo().equals(tituloTarefaDes)) {
                            tarefa.desmarcar();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Digite o NÚMERO da categoria:\n" + "1 - Trabalho;\n" + "2 - Casa;\n" + "3 - Saúde e bem estar;\n" + "4 - Estudos;\n" + "5 - Religião;\n" + "6 - Lazer;\n" + "7 - Outros.");
                    int catNum = estado.nextInt();
                    for (int i = 0; i < tarefas.size(); i++) {
                       if (tarefas.get(i).categoria == catNum) {
                           System.out.println(tarefas.get(i).getTitulo() + " - " + tarefas.get(i).getCategoria());
                       }else{
                           System.out.println("Nenhuma tarefa encontrada.");
                       }
                    }
                    break;
                case 5:
                    System.out.println("Até mais! :)");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, digite outro número.");
            }
        } while (n2!=5);
    }

}

