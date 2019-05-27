package ru.mtuci.HibernateLab;
import ru.mtuci.HibernateLab.dao.GroupRepository;
import ru.mtuci.HibernateLab.dao.StudentRepository;
import ru.mtuci.HibernateLab.model.Group;
import ru.mtuci.HibernateLab.model.Student;
public class Main { // создан главный класс
    public static void main(String[] args) { // создан главный метод
        /* Создадим экземпляры классов и передадим значения в параметры конструкторов */
        Student student = new Student(null, "Иванов", "Иван", "Иванович");
        Group group = new Group(null,"Тествая");
        GroupRepository groupRepository = new GroupRepository(); // создан репозиторий группы
        Group createdGroup = groupRepository.save(group); // сохранение группы
        student.setGroup(createdGroup); // присвоение группы студенту
        StudentRepository studentRepository = new StudentRepository(); // создан репозиторий студента
        studentRepository.save(student); // сохранение студента
    } // конец метода "main"
} // конец класса "Main"