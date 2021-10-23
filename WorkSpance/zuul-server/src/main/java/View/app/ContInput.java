package app;

import Repository.Repositoryone;
import clojure.lang.Delay;

import java.util.Scanner;
import controlador.Telas;
import controlador.TelasED;
import controlador.LeituradeDados;

public final class ContInput {
    private static Scanner in;

    private static ContInput instancia;

    private ContInput() {
        in = new Scanner(System.in);
    }

    public static ContInputobterInstancia(){
        if(instancia ==null)
        intancia = new
        ContInput();
        return instancia;
    }

    void loopPrincipal(){
        ContTelas contTelas= ContTelas.obterInstancia();
        Delay tela =

    contTelas.obterProxima Tela("00");
        String str = "00";
        do{
            Telas tela1;
            limparTela();
            System.out.print(tela.getTexto());
            if (tela instanceof TelaLeituraDados) {
              try {
                Model model = ((TelaLeituraDados)tela).lerDados(in);
                if (model != null) {
                  Repositorio<Model> repositorio = controladorTelas.obterRepositorio(tela.getId());
                  repositorio.adicionar(model);
                } 
                System.out.print("\nOperarealizada com sucesso!");
              } catch (Exception exception) {
                if (in.hasNext())
                  in.nextLine(); 
                System.out.println("\nErro na entrada de dados. Tente novamente.");
              } 
              voltarMenu();
              tela1 = controladorTelas.obterProximaTela("00");
            } else if (tela instanceof TelaExibicaoDados) {
              Repositorio<Model> repositorio = controladorTelas.obterRepositorio(tela.getId());
              ((TelaExibicaoDados)tela).exibirDados(in, repositorio);
              voltarMenu();
              tela1 = controladorTelas.obterProximaTela("00");
            } else {
              str = tela.getId() + in.nextLine();
              tela1 = controladorTelas.obterProximaTela(str);
            } 
            if (tela1 != null) {
              tela = tela1;
            } else {
              System.out.print("\nOpinv");
              voltarMenu();
            } 
          } while (!str.equals("00"));
          System.out.println("\nFim do programa!");
          in.close();
        }

    public void limparTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                (new ProcessBuilder(new String[] { "cmd", "/c", "cls" })).inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
            }
        } catch (Exception exception) {
        }
    }

    private void voltarMenu() {
        System.out.print("\nPressione ENTER para continuar...");
        in.nextLine();
        limparTela();
        System.out.flush();
    }
}
