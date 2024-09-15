interface Pagamento {
    void pagar(double valor);
}

class PagamentoInterno implements Pagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Processando pagamento de R$ " + valor + " através do sistema interno.");
    }
}

class PagamentoExternoAPI {
    public void realizarTransacao(String nomeCliente, double montante) {
        System.out.println("Pagamento de R$ " + montante + " processado para " + nomeCliente + " via API externa.");
    }
}

class PagamentoAdapter implements Pagamento {
    private PagamentoExternoAPI pagamentoExternoAPI;
    private String nomeCliente;

    public PagamentoAdapter(PagamentoExternoAPI pagamentoExternoAPI, String nomeCliente) {
        this.pagamentoExternoAPI = pagamentoExternoAPI;
        this.nomeCliente = nomeCliente;
    }

    @Override
    public void pagar(double valor) {
        pagamentoExternoAPI.realizarTransacao(nomeCliente, valor);
    }
}

public class Main {
    public static void main(String[] args) {
        Pagamento pagamentoInterno = new PagamentoInterno();
        pagamentoInterno.pagar(100.0);

        PagamentoExternoAPI apiExterna = new PagamentoExternoAPI();
        Pagamento pagamentoAdaptado = new PagamentoAdapter(apiExterna, "João Silva");
        pagamentoAdaptado.pagar(200.0);
    }
}
