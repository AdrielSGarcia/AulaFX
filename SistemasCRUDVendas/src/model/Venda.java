package model;

import java.time.LocalDate;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Venda {
    private final IntegerProperty id;
    private final ObjectProperty<Cliente> cliente;
    private final ObjectProperty<LocalDate> dataVenda;
    private final DoubleProperty valorTotal;

    public Venda() {
        this.id = new SimpleIntegerProperty();
        this.cliente = new SimpleObjectProperty<>();
        this.dataVenda = new SimpleObjectProperty<>(LocalDate.now()); // Default para hoje
        this.valorTotal = new SimpleDoubleProperty();
    }

    // --- Getters e Setters ---
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public Cliente getCliente() {
        return cliente.get();
    }

    public void setCliente(Cliente cliente) {
        this.cliente.set(cliente);
    }

    public ObjectProperty<Cliente> clienteProperty() {
        return cliente;
    }

    public LocalDate getDataVenda() {
        return dataVenda.get();
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda.set(dataVenda);
    }

    public ObjectProperty<LocalDate> dataVendaProperty() {
        return dataVenda;
    }

    public double getValorTotal() {
        return valorTotal.get();
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal.set(valorTotal);
    }

    public DoubleProperty valorTotalProperty() {
        return valorTotal;
    }
    
    @Override
    public String toString() {
        return "Venda #" + getId() + " - " + getCliente().getNome();
    }
}