public class Person {
    private String name;
    private String surname;
    private String patronymic;

    public Person(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public boolean nameAndSurnameCompleted(){
        return !( getName().equals("") || getSurname().equals("") );
    }

    public boolean patronymicCompleted(){
        return !getPatronymic().equals("");
    }

    public String getFullName() {
        return  getSurname() + " " + getName() + " " +getPatronymic();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }
}
