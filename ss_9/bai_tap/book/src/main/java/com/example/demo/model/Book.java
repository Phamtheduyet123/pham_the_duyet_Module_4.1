package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
@Entity(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_Book" ,columnDefinition = "VARCHAR(20)")
    private String namebook;

    @Min(value = 0,message = "loi roi")
   private Integer number;

    @Min(value = 5,message = "loi random")
    private Integer randomNumber;

    public Book() {
    }

    public Book(Integer id, String namebook, @Min(value = 0, message = "loi roi") Integer number, @Size(min = 5, message = "loi random") Integer randomNumber) {
        this.id = id;
        this.namebook = namebook;
        this.number = number;
        this.randomNumber = randomNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamebook() {
        return namebook;
    }

    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Integer getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(Integer randomNumber) {
        this.randomNumber = randomNumber;
    }
}
