package com.example.demo.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 1, max = 255, message = "От 1 до 255 символов")
    private String title, full_text;
    @NotNull(message = "Поле не может быть пустым")
    @DecimalMax(value = "20000.0", message = "Поле не может быть больше 20 тысяч")
    @DecimalMin(value = "0.0", message = "Поле не может быть меньше 0")
    private Double cenastat;
    @NotNull(message = "Поле не может быть пустым")
    @DecimalMax(value = "48.0", message = "Поле не может быть больше 48 часов")
    @DecimalMin(value = "1.0", message = "Поле не может быть меньше 1 минуты")
    private Float hours;

    @NotNull(message = "Не может быть пустой")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Past(message = "Дата аннонсирования не может быть будущей")
    private Date datavihoda;

    private int views;

    public Post(String title, Date datavihoda, String full_text, Double cenastat, Float hours) {
        this.title = title;
        this.datavihoda = datavihoda;
        this.full_text = full_text;
        this.cenastat = cenastat;
        this.hours = hours;
    }

    public Post() {

    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public int getViews() {
        return this.views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Date getDatavihoda() {
        return datavihoda;
    }

    public void setDatavihoda(Date datavihoda) {
        this.datavihoda = datavihoda;
    }

    public Double getCenastat() {
        return cenastat;
    }

    public void setCenastat(Double cenastat) {
        this.cenastat = cenastat;
    }

    public void setHours(Float hours) {
        this.hours = hours;
    }
    public Float getHours() {
        return hours;
    }
}
