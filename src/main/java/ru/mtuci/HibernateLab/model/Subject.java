package ru.mtuci.HibernateLab.model;
import javax.persistence.*;
import java.util.List;
@NamedQueries({@NamedQuery(name = Subject.GET_ALL, query = "SELECT s FROM Subject s")})
@Entity // создана аннотация
@Table(name = "subjects") // создана аннотация для привязки таблицы "SUBJECTS"
public class Subject extends BaseEntity{ // создан класс "Subject" наследник класса "BaseEntity"
    public static final String GET_ALL = "Subject.getAll";
    private String name;
    private String shortname;
    private Integer hours;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // создана аннотация для связи "многие ко многим"
    @JoinTable( // создана аннотация
            name = "groups_subjects", // указана связующая таблица
            joinColumns = @JoinColumn(name = "id_subject"), // указано связующее поле
            inverseJoinColumns = @JoinColumn(name = "id_group") // указано связующее поле
    )
    private List<Group> groups;
    public Subject() {} // создан пустой конструктор без параметров
    public Subject(Long id, String name, String shortname, Integer hours) {
        super(id); this.name = name; this.shortname = shortname; this.hours = hours;
    }  // создан конструктор по умолчанию, использовав конструктор базового класса "BaseEntity"
    /* Создадим геттеры и сеттеры */
    public String getName() { return name;}
    public void setName(String name) { this.name = name;}
    public String getShortname() { return shortname;}
    public void setShortname(String shortname) {this.shortname = shortname;}
    public Integer getHours() { return hours; }
    public void setHours(Integer hours) {this.hours = hours;}
    public List<Group> getGroups() {return groups;}
    public void setGroups(List<Group> groups) {this.groups = groups;}
    @Override // переопределим метод "toString"
    public String toString() {return "Subject{" + "id='" + getId() + '\'' + "name='" + name + '\'' +
                ", shortname='" + shortname + '\'' + ", hours='" + hours + '\'' + '}';}
}