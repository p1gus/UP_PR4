package com.example.demo.models;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
@Entity
@Table(name = "jornalisti")
public class Jornalisti {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 1, max = 255, message = "От 1 до 255 символов")
    private String name, fam;
    @NotNull(message = "Поле не может быть пустым")
    @DecimalMax(value = "20000.0", message = "Поле не может быть больше 20 тысяч")
    @DecimalMin(value = "0.0", message = "Поле не может быть меньше 0")
    private Double cena;
    @NotNull(message = "Не может быть пустым")
    @Range(min=0, max=90, message = "Диапазон от 0 до 90")
    private Integer kolvastat;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Не может быть пустой")
    @Temporal(TemporalType.DATE)
    @PastOrPresent(message = "Дата аннонсирования не может быть будущей")
    private Date denroj;

    private int views;

    public Jornalisti(String name, String fam, Integer kolvastat, Date denroj, Double cena) {
        this.name = name;
        this.fam = fam;
        this.kolvastat = kolvastat;
        this.denroj = denroj;
        this.cena = cena;
    }

    public Jornalisti() {

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

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }


    public Date getDenroj() {
        return denroj;
    }

    public void setDenroj(Date denroj) {
        this.denroj = denroj;
    }


    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Integer getKolvastat() {
        return kolvastat;
    }

    public void setKolvastat(Integer kolvastat) {
        this.kolvastat = kolvastat;
    }
}
