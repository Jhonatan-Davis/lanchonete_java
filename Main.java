package lanchonete;

public class Main {
    public static void main(String[] args) {
        ListaPedidos fila = new ListaPedidos();

        PedidoNode[] chegadas = {
            new PedidoNode(1, "João", "Hambúrguer", 2, 20.0, TipoPedido.NORMAL),
            new PedidoNode(2, "Maria", "Batata Frita", 1, 15.0, TipoPedido.PRIORITARIO),
            new PedidoNode(3, "Carlos", "Refrigerante", 3, 5.0, TipoPedido.NORMAL),
            new PedidoNode(4, "Ana", "X-Tudo", 1, 25.0, TipoPedido.URGENTE),
            new PedidoNode(5, "Pedro", "Milkshake", 2, 12.0, TipoPedido.NORMAL),
            new PedidoNode(6, "Lucas", "Suco", 1, 8.0, TipoPedido.NORMAL),
            new PedidoNode(7, "Julia", "Cachorro Quente", 2, 10.0, TipoPedido.PRIORITARIO),
            new PedidoNode(8, "Marcos", "Pizza", 1, 40.0, TipoPedido.NORMAL),
            new PedidoNode(9, "Fernanda", "Porção Mista", 1, 35.0, TipoPedido.URGENTE),
            new PedidoNode(10, "Rafael", "Água", 2, 3.0, TipoPedido.NORMAL),
            new PedidoNode(11, "Aline", "X-Bacon", 1, 22.0, TipoPedido.PRIORITARIO),
            new PedidoNode(12, "Bruno", "Pastel", 4, 6.0, TipoPedido.NORMAL),
            new PedidoNode(13, "Carla", "Sorvete", 1, 10.0, TipoPedido.PRIORITARIO),
            new PedidoNode(14, "Diego", "Açaí", 1, 18.0, TipoPedido.URGENTE),
            new PedidoNode(15, "Elisa", "Café", 1, 4.0, TipoPedido.NORMAL)
        };

        for (PedidoNode p : chegadas) {
            fila.inserirPedido(p);
        }

        fila.imprimirLista();
        fila.buscarPorPosicao(3); 
        
        System.out.println("\n-> Atendendo pedido (Removendo do Início):");
        System.out.println(fila.removerDoInicio());
        
        System.out.println("\n-> Cancelando último pedido (Removendo do Fim):");
        System.out.println(fila.removerDoFim());
        
        System.out.println("\n-> Cancelando pedido na posição 4 (Removendo k):");
        System.out.println(fila.removerDaPosicao(4));
        
        System.out.println("\n-> Buscando pedido específico (ID 11):");
        System.out.println(fila.buscarPorId(11));
        
        System.out.println("\n--- Lista Final após operações ---");
        fila.imprimirLista();
    }
}