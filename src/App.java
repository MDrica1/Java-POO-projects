import java.util.ArrayList;
import java.util.Scanner;


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

        int cont = 1;
        ArrayList<Integer> numerosTarefas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String s2;
        int n2;
        do {
            s2 = "O que deseja fazer? (Digite o NÚMERO):\n" + "1 - Adicionar tarefas\n2 - Consultar tarefas\n3 - Marcar tarefas como concluídas\n4 - Desmarcar tarefas\n5 - Filtrar tarefas por categorias\n6 - Remover tarefa\n7 - Sair da aplicação";
            System.out.println(s2);
            n2 = sc.nextInt();
            sc.nextLine();

            switch (n2) {
                case 1:

                    while (true) {
                        System.out.println("TAREFA " + cont + ": ");

                        adicionar(sc);
                        numerosTarefas.add(cont);



                        System.out.println("Essa tarefa foi finalizada? (s/n): ");
                        String resposta1 = sc.next();
                        //novaTarefa.nextLine();
                        if (!resposta1.equalsIgnoreCase("n")) {
                            tarefas.get(cont - 1).marcar();
                        }

                        System.out.print("Deseja adicionar outra tarefa? (s/n): ");
                        String resposta = sc.next();
                        //novaTarefa.nextLine();

                        if (!resposta.equalsIgnoreCase("s")) {
                            break;
                        }

                        cont += 1;
                        sc.nextLine();
                    }

                    break;
                case 2:

                    if (tarefas.isEmpty()) {
                        System.out.println("Não há tarefas a consultar.");
                        break;
                    }

                    System.out.println("Quais tarefas deseja visualizar? (Digite o NÚMERO):\n" + "1 - Exibir TODAS as tarefas" + "\n2 - Exibir tarefas pendentes" + "\n3 - Exibir tarefas finalizadas.");
                    int n3 = sc.nextInt();

                    boolean haSelecionadas = false;
                    for (Tarefa tarefa : tarefas) {
                        if (n3 == 2 && tarefa.getStatus().equals("Pendente")) {
                            haSelecionadas = true;
                            break;
                        } else if (n3 == 3 && tarefa.getStatus().equals("Finalizada")) {
                            haSelecionadas = true;
                            break;
                        }
                    }


                    if (n3 != 1 && !haSelecionadas) {
                        if (n3 == 2) {
                            System.out.println("Não há tarefas pendentes.");
                        } else if (n3 == 3) {
                            System.out.println("Não há tarefas finalizadas.");
                        }

                    } else {
                        for (int i = 0; i < tarefas.size(); i++) {
                            String consulta = tarefas.get(i).consultar(n3);
                            if (consulta != null) {
                                System.out.println("TAREFA " + numerosTarefas.get(i) + "\n");
                                System.out.println(consulta + "\n");
                            }
                        }
                    }


                    break;
                case 3:
                    boolean haTarefasPendentes = false;
                    for (Tarefa tarefa : tarefas) {
                        if (tarefa.getStatus().equals("Pendente")) {
                            haTarefasPendentes = true;
                            break;
                        }
                    }

                    if (!haTarefasPendentes) {
                        System.out.println("Não há tarefas a serem marcadas. Todas foram finalizadas.");
                        } else {
                        System.out.println("Título da tarefa a ser MARCADA:");
                        String tituloTarefa = sc.nextLine();

                        for (Tarefa tarefa : tarefas) {
                            if (tarefa.getTitulo().equals(tituloTarefa)) {
                                tarefa.marcar();
                            }
                        }
                    }

                    break;
                case 4:

                    boolean haTarefasFinalizadas = false;
                    for (Tarefa tarefa : tarefas) {
                        if (tarefa.getStatus().equals("Finalizada")) {
                            haTarefasFinalizadas = true;
                            break;
                        }
                    }

                    if (!haTarefasFinalizadas) {
                        System.out.println("Não há tarefas a serem desmarcadas. Todas estão pendentes.");
                        } else {
                        System.out.println("Título da tarefa a ser DESMARCADA:");

                        String tituloTarefaDes = sc.nextLine();

                        for (Tarefa tarefa : tarefas) {
                            if (tarefa.getTitulo().equals(tituloTarefaDes)) {
                                tarefa.desmarcar();
                            }
                        }
                    }

                    break;

                case 5:

                    System.out.println("Digite o NÚMERO da categoria:\n" + "1 - Trabalho;\n" + "2 - Casa;\n" + "3 - Saúde e bem estar;\n" + "4 - Estudos;\n" + "5 - Religião;\n" + "6 - Lazer;\n" + "7 - Outros.");
                    int catNum = sc.nextInt();
                    boolean haTarefa = false;
                    for (int i = 0; i < tarefas.size(); i++) {
                        if (tarefas.get(i).categoria == catNum) {
                            System.out.println(tarefas.get(i).getTitulo() + " - " + tarefas.get(i).getCategoria());
                            haTarefa = true;
                        }
                    }
                    if (!haTarefa) {
                        System.out.println("Nenhuma tarefa encontrada nessa categoria.");
                    }
                    break;

                case 6:

                    if (tarefas.isEmpty()) {
                        System.out.println("Não há tarefas a remover.");
                    } else {
                        System.out.println("Qual o TÍTULO da tarefa que deseja remover?");
                        String tarefaRemover = sc.nextLine();

                        ArrayList<Tarefa> copiaTarefas = new ArrayList<>(tarefas);

                        for (int i = 0; i < tarefas.size(); i++) {
                            Tarefa tarefa = tarefas.get(i);
                            if (tarefa.getTitulo().equals(tarefaRemover)) {
                                tarefas.remove(tarefa);
                                numerosTarefas.remove(Integer.valueOf(i + 1));
                                System.out.println("Tarefa removida com sucesso!");
                            }
                        }
                    }

                    break;

                case 7:
                    System.out.println("Até mais! :)");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, digite outro número.");
            }
        } while (n2!=7);




    }

}
