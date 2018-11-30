import javax.swing.*;
import java.awt.event.ActionListener;


public class FirstForm extends JPanel {
    private JButton changeFormButton;
    private JTextField name;
    private JTextField surname;
    private JTextField patronymic;
    private JPanel rootPanel;

    public void setPerson(Person person) {
        this.name.setText(person.getName());
        this.surname.setText(person.getSurname());
        this.patronymic.setText(person.getPatronymic());
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void addListener(ActionListener listener) {
        changeFormButton.addActionListener(listener);
    }

    public Person getPerson() {
        return new Person(name.getText().trim(), surname.getText().trim(), patronymic.getText().trim());
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        rootPanel = this;
    }
}