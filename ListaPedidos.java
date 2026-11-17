package lanchonete;

public class ListaPedidos {
    private PedidoNode cabeca;
    private PedidoNode cauda;
    private int tamanho;

    public ListaPedidos() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    public void inserirPedido(PedidoNode novoPedido) {
        if (novoPedido.getTipo() == TipoPedido.URGENTE) {
            inserirNoInicio(novoPedido);
        } else if (novoPedido.getTipo() == TipoPedido.NORMAL) {
            inserirNoFim(novoPedido);
        } else if (novoPedido.getTipo() == TipoPedido.PRIORITARIO) {
            inserirNoMeio(novoPedido);
        }
    }

    private void inserirNoInicio(PedidoNode pedido) {
        if (estaVazia()) {
            cabeca = cauda = pedido;
        } else {
            pedido.setProximo(cabeca);
            cabeca = pedido;
        }
        tamanho++;
    }

    private void inserirNoFim(PedidoNode pedido) {
        if (estaVazia()) {
            cabeca = cauda = pedido;
        } else {
            cauda.setProximo(pedido);
            cauda = pedido;
        }
        tamanho++;
    }

    private void inserirNoMeio(PedidoNode pedido) {
        if (estaVazia() || tamanho == 1) {
            inserirNoInicio(pedido);
            return;
        }
        
        int posicaoMeio = tamanho / 2;
        PedidoNode atual = cabeca;
        
        for (int i = 0; i < posicaoMeio - 1; i++) {
            atual = atual.getProximo();
        }
        
        pedido.setProximo(atual.getProximo());
        atual.setProximo(pedido);
        tamanho++;
    }

    public PedidoNode removerDoInicio() {
        if (estaVazia()) return null;
        PedidoNode removido = cabeca;
        cabeca = cabeca.getProximo();
        tamanho--;
        if (estaVazia()) cauda = null;
        
        removido.setProximo(null); // Desconecta o nó da lista (boa prática de memória)
        return removido;
    }

    public PedidoNode removerDoFim() {
        if (estaVazia()) return null;
        if (tamanho == 1) return removerDoInicio();

        PedidoNode atual = cabeca;
        while (atual.getProximo() != cauda) {
            atual = atual.getProximo();
        }
        
        PedidoNode removido = cauda;
        cauda = atual;
        cauda.setProximo(null);
        tamanho--;
        return removido;
    }

    public PedidoNode removerDaPosicao(int k) {
        if (k < 0 || k >= tamanho) return null;
        if (k == 0) return removerDoInicio();
        if (k == tamanho - 1) return removerDoFim();

        PedidoNode atual = cabeca;
        for (int i = 0; i < k - 1; i++) {
            atual = atual.getProximo();
        }
        
        PedidoNode removido = atual.getProximo();
        atual.setProximo(removido.getProximo());
        removido.setProximo(null);
        tamanho--;
        return removido;
    }

    public PedidoNode buscarPorId(int id) {
        PedidoNode atual = cabeca;
        while (atual != null) {
            if (atual.getIdPedido() == id) return atual;
            atual = atual.getProximo();
        }
        return null;
    }

    public void buscarPorPosicao(int n) {
        System.out.println("--- Próximos " + n + " pedidos ---");
        PedidoNode atual = cabeca;
        int count = 0;
        while (atual != null && count < n) {
            System.out.println((count + 1) + "º -> " + atual);
            atual = atual.getProximo();
            count++;
        }
    }

    public void imprimirLista() {
        System.out.println("=== LISTA DE PEDIDOS (" + tamanho + " pedidos) ===");
        PedidoNode atual = cabeca;
        int pos = 0;
        while (atual != null) {
            System.out.println("Pos " + pos + ": " + atual);
            atual = atual.getProximo();
            pos++;
        }
        System.out.println("===============================\n");
    }

    public int getTamanho() { return tamanho; }
    public boolean estaVazia() { return tamanho == 0; }
    public PedidoNode obterCabeca() { return cabeca; }
    public PedidoNode obterCauda() { return cauda; }
}
