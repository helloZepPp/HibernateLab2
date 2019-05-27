package ru.mtuci.HibernateLab.model;
import javax.persistence.*;
@NamedQueries({@NamedQuery(name = Student.GET_ALL, query = "SELECT s FROM Student s")})
@Entity // создана аннотация
@Table(name = "students") // создана аннотация для привязки таблицы "STUDENTS"
public class Student extends BaseEntity{ // создан класс "Student" наследник класса "BaseEntity"
    public static final String GET_ALL = "Student.getAll";
    private String lastname;
    private String firstname;
    private String patronym;
    @ManyToOne(fetch = FetchType.EAGER) // создана аннотация для связи "многие к одному"
    /* создана аннотация "@JoinColumn" для указания объекта, к которому склоняется внешний ключ */
    @JoinColumn(name = "id_group", nullable = false)
    private Group group;
    public Student() {} // создан пустой конструктор без параметров
    public Student(Long id, String lastname, String firstname, String patronym) {
        super(id); this.lastname = lastname; this.firstname = firstname; this.patronym = patronym;
    } // создан конструктор по умолчанию, использовав конструктор базового класса "BaseEntity"
    /* Создадим геттеры и сеттеры */
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname;}
    public String getFirstname() {return firstname; }
    public void setFirstname(String firstname) {this.firstname = firstname; }
    public String getPatronym() { return patronym; }
    public void setPatronym(String patronym) {this.patronym = patronym;}
    public Group getGroup() {return group;}
    public void setGroup(Group group) {this.group = group;}
    /* Методы "equals" и "hashCode" переопределять не будем, т.к. унаследуем их от класса "BaseEntity" */
    @Override // переопределим метод "toString"
    public String toString() {return "Student{"+"id='" + getId() + '\''+"  lastname='"
            +lastname+'\''+", firstname='"+firstname+'\''+", patronym='"+patronym+'\''+'}';}
}
