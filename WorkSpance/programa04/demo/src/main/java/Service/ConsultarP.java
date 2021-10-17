package Telas;

package Telas;

import Repository.Repositoryone;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import Principal.Model;
import Principal.Produto;

public class ConsultarP extends Telas implements TelaExibicaoDados {
  public ConsultaP (String paramString, int paramInt) {
    super(paramString, paramInt);
  }

    public void exibirDados(Scanner paramScanner, Repositoryone<Model> paramRepositorio) {
        System.out.print("Nome do produto a buscar (ENTER para todos): ");
        String str = paramScanner.nextLine();
        List list = (List) paramRepository.obterStream().filter(
                paramModel -> ((Produto) paramModel).getNome().toUpperCase().contains(paramString.toUpperCase()))
                .sorted().collect(Collectors.toList());
        if (list.isEmpty()) {
            System.out.println("\nNenhum produto localizado.");
        } else {
            System.out.println("\nProdutos encontrados:");
            System.out.println("*******");
            Objects.requireNonNull(System.out);
            list.forEach(System.out::println);
        }
    }
}
