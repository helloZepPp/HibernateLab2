package ru.mtuci.HibernateLab.model;
public interface HasId {Long getId(); void setId(Long id);default boolean isNew() {return (getId() == null);}}
