package ru.mtuci.HibernateLab.model;
import org.hibernate.Hibernate;
import javax.persistence.*;
@MappedSuperclass // создадана аннотация (наш класс является супеклассом для всех остальных)
@Access(AccessType.FIELD) // создана аннотация (регулирование доступа к полям)
public class BaseEntity implements HasId{ // создан класс "BaseEntity"
    @Id // создана аннотация (генерация ID. поле "Id" будет отвечать за идентификаторы.
    // в каждом классе эта аннотация будет использоваться, т.к. этот класс "BaseEntity" родительский)
    /* создана аннотация "@SequenceGenerator", назовем последовательность, как в нашей БД */
    @SequenceGenerator(name = "sequence1", sequenceName = "sequence1", allocationSize = 1, initialValue = 100000)
    /* создана аннотация "@GeneratedValue" для генерации критериев */
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence1")
    @Access(value = AccessType.PROPERTY) // создана аннотация "@Access" типа доступа к полю
    private Long id;
    /* Следуем требованиям JavaBeans */
    public BaseEntity() {} // создан пустой конструктор без параметров
    public BaseEntity(Long id) {this.id = id;} // создан конструктор по умолчанию
    public Long getId() {return id;} // создан геттер для поля "id"
    public void setId(Long id) {this.id = id;} // создан сеттер для поля "id"
    @Override // переопределен метод "equals"
    public boolean equals(Object o) {if (this == o) {return true; }
        if (o == null || !getClass().equals(Hibernate.getClass(o))) {return false;}
        BaseEntity that = (BaseEntity) o; return getId() != null && getId().equals(that.getId());}
    @Override // переопределен метод "hashCode"
    public int hashCode() {return id != null ? id.hashCode() : 0;}
    @Override // переопределен и переписан метод "toString"
    public String toString() {return String.format("Entity of type %s with id: %s", getClass().getName(),getId());}
}