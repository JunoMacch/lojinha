package com.lojinha.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * O nome da tabela foi alterado devido Order ser um nome exclusivo do banco de dados
 * é preciso se atentar a isso quando ocorrer um erro, pois pode ser devido o nome da classe
 */
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * A partir da versão 8 do Java utiliza-se a classe Instant ao inves de Date para registrar o instante.
     */
    private Instant moment;


    /**
     * Esse é o lado muitos para um (*...1) Onde muitos pedidos podem ter 1 cliente
     * Para instruir o jpa para transformar esse atributo em uma chave estrangeira
     * colocamos a anotação @ManyToOne.
     * Completamos com a anotaçao @JoinColumn e nos parenteses dizemos
     * qual a chave estrangeira que tera no banco de dados
     */
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order() {
    }

    public Order(Long id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
