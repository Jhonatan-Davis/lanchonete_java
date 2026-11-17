package lanchonete;

public class PedidoNode {
    private int idPedido;
    private String nomeCliente;
    private String item;
    private int quantidade;
    private double valor;
    private TipoPedido tipo;
    private PedidoNode proximo;

    public PedidoNode(int idPedido, String nomeCliente, String item, int quantidade, double valorBase, TipoPedido tipo) {
        this.idPedido = idPedido;
        this.nomeCliente = nomeCliente;
        this.item = item;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.proximo = null;
        
        calcularValorComAcrescimo(valorBase);
    }

    private void calcularValorComAcrescimo(double valorBase) {
        if (this.tipo == TipoPedido.PRIORITARIO) {
            this.valor = valorBase * 1.10;
        } else if (this.tipo == TipoPedido.URGENTE) {
            this.valor = valorBase * 1.20;
        } else {
            this.valor = valorBase;
        }
    }

    public int getIdPedido() { return idPedido; }
    public String getNomeCliente() { return nomeCliente; }
    public String getItem() { return item; }
    public int getQuantidade() { return quantidade; }
    public double getValor() { return valor; }
    public TipoPedido getTipo() { return tipo; }
    
    public PedidoNode getProximo() { return proximo; }
    public void setProximo(PedidoNode proximo) { this.proximo = proximo; }

    @Override
    public String toString() {
        return String.format("[ID: %d | Cliente: %s | %s (%dx) | Tipo: %s | Valor: R$%.2f]", 
                idPedido, nomeCliente, item, quantidade, tipo, valor);
    }
}