package com.alan.springboot.course_first_webapp.UserSystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_entity_seq")
//    @SequenceGenerator(name = "my_entity_seq", sequenceName = "my_entity_seq", allocationSize = 1)
    private Long id;
    private String username;
    @Size(min=10, message = "Enter at least 10 characters.")
    private String description;
    private LocalDate deadline;
    boolean done;

    public Todo() {}

    public Todo(Long id, String username, String description, LocalDate deadline, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                '}';
    }
}
