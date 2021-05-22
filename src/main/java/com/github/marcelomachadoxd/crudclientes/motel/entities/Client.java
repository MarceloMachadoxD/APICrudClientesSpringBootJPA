package com.github.marcelomachadoxd.crudclientes.motel.entities;


import java.time.Instant;
import java.util.Objects;

public class Client {

    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private Instant birtDate;
    private Integer children;


    public Client() {
    }

    public Client(Long id, String name, String cpf, Double income, Instant birtDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birtDate = birtDate;
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Instant getBirtDate() {
        return birtDate;
    }

    public void setBirtDate(Instant birtDate) {
        this.birtDate = birtDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(cpf, client.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }


    @Override
    public String toString() {
        return "Client{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", cpf='" + cpf + '\'' +
            ", income=" + income +
            ", birtDate=" + birtDate +
            ", children=" + children +
            '}';
    }



}
