package ru.rassafel.todo.model;

public interface IToDoCard {
    Long getId();
    String getSummary();
    String getDescription();
    Long getParentId();
}
