package telas;

import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import Principal.Venda;
import Telas.apoio.ItemVendaConsolidadaHelper;

public class RelatorioC extends RelatorioVendaDetalhado {
    public RelatorioC(String paramString, int paramInt) {
        super(paramString, paramInt);
    }

    protected void imprimirRelatorio(LocalDate[] paramArrayOfLocalDate, List<Model> paramList) {
        imprimirCabecalhoRelatorio(paramArrayOfLocalDate);
        Map map = (Map) paramList.stream().collect(Collectors.toMap(paramModel -> ((Venda) paramModel).getData(),
                ItemVendaConsolidadaHelper::new, ItemVendaConsolidadaHelper::merge));
        System.out.printf("\n%10s\t%15s\t%20s\n", new Object[] { "Data", "Quantidade", "Valor total (R$)" });
        System.out.println("---------------------------------------------------------------");
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(paramEntry -> System.out.printf("%10s\t%15d\t%20.2f\n",
                        new Object[] { this.df.format((TemporalAccessor) paramEntry.getKey()),
                                Integer.valueOf(((ItemVendaConsolidadaHelper) paramEntry.getValue()).getQuantidade()),
                                Double.valueOf(((ItemVendaConsolidadaHelper) paramEntry.getValue()).getValor()) }));
        double d = map.values().stream().mapToDouble(ItemVendaConsolidadaHelper::getValor).average().getAsDouble();
        System.out.println("---------------------------------------------------------------");
        System.out.printf("Valor mdino perR$ %.2f\n", new Object[] { Double.valueOf(d) });
    }

    protected void imprimirTitulo() {
        System.out.println("***************");
        System.out.println("** RELATDE VENDAS - CONSOLIDADO **");
        System.out.println("***************");
    }
}
