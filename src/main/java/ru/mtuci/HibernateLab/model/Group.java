package ru.mtuci.HibernateLab.model;
import javax.persistence.*;
import java.util.List;
@NamedQueries({@NamedQuery(name = Group.GET_ALL, query = "SELECT g FROM Group g")})
@Entity // создана аннотация
@Table(name = "groups") // создана аннотация "@Table" для привязки таблицы "GROUPS"
public class Group extends BaseEntity { // создан класс "Group" наследник класса "BaseEntity"
    public static final String GET_ALL = "Group.getAll";
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group") // создана аннотация для связи "один ко многим"
    private List<Student> students;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // создана аннотация для связи "многие ко многим"
    @JoinTable( // создана аннотация
            name = "groups_subjects", // указана связующая таблица
            joinColumns = @JoinColumn(name = "id_group"), // указано связующее поле для ключа
            inverseJoinColumns = @JoinColumn(name = "id_subject") // указано связующее поле для ключа
    )
    private List<Subject> subjects;
    public Group() {} // создан пустой конструктор без параметров
    public Group(Long id, String name) {super(id); this.name = name;
    } // создан конструктор по умолчанию, использовав конструктор базового класса "BaseEntity"
    /* Создадим геттеры и сеттеры */
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public List<Student> getStudents() {return students;}
    public void setStudents(List<Student> students) {this.students = students;}
    public List<Subject> getSubjects() { return subjects; }
    public void setSubjects(List<Subject> subjects) {this.subjects = subjects;}
    @Override // переопределим метод "toString"
    public String toString(){return "Group{" + "id='" + getId() + '\'' + "name='" + name + '\'' + '}';}
}