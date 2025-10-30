package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Categoria {
    private final IntegerProperty id;
    private final StringProperty nome;

    public Categoria() {
        this.id = new SimpleIntegerProperty();
        this.nome = new SimpleStringProperty();
    }

    public Categoria(String nome) {
        this();
        this.nome.set(nome);
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

    // Essencial para ComboBox
    @Override
    public String toString() {
        return getNome();
    }
}