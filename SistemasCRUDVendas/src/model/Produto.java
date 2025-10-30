package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produto {
    private final IntegerProperty id;
    private final StringProperty nome;
    private final StringProperty descricao;
    private final DoubleProperty preco;
    private final IntegerProperty estoque;
    private final ObjectProperty<Categoria> categoria;

    public Produto() {
        this.id = new SimpleIntegerProperty();
        this.nome = new SimpleStringProperty();
        this.descricao = new SimpleStringProperty();
        this.preco = new SimpleDoubleProperty();
        this.estoque = new SimpleIntegerProperty();
        this.categoria = new SimpleObjectProperty<>();
    }

    public Produto(String nome, String descricao, double preco, int estoque, Categoria categoria) {
        this();
        this.nome.set(nome);
        this.descricao.set(descricao);
        this.preco.set(preco);
        this.estoque.set(estoque);
        this.categoria.set(categoria);
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

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public String getDescricao() {
        return descricao.get();
    }

    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }

    public StringProperty descricaoProperty() {
        return descricao;
    }

    public double getPreco() {
        return preco.get();
    }

    public void setPreco(double preco) {
        this.preco.set(preco);
    }

    public DoubleProperty precoProperty() {
        return preco;
    }

    public int getEstoque() {
        return estoque.get();
    }

    public void setEstoque(int estoque) {
        this.estoque.set(estoque);
    }

    public IntegerProperty estoqueProperty() {
        return estoque;
    }

    public Categoria getCategoria() {
        return categoria.get();
    }

    public void setCategoria(Categoria categoria) {
        this.categoria.set(categoria);
    }

    public ObjectProperty<Categoria> categoriaProperty() {
        return categoria;
    }

    @Override
    public String toString() {
        return getNome() + " - R$ " + getPreco();
    }
}