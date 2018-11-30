import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;


public class SecondForm extends JPanel {
    private JTextField fullName;
    private JButton changeFormButton;
    private JPanel rootPanel;
    private JProgressBar nameProgressBar;
    private static final int MAX_FULL_NAME_SIZE = 30;


    public SecondForm() {
        nameProgressBar.setMaximum(MAX_FULL_NAME_SIZE);
        fullName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setNameProgressBar(fullName.getText().length());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setNameProgressBar(fullName.getText().length());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void addListener(ActionListener listener) {
        changeFormButton.addActionListener(listener);
    }

    public void setPerson(Person person) {
        String name = person.getFullName();
        this.fullName.setText(name);
    }

    public Person getPerson() {
        String namesArray[] = fullName.getText().trim().split("\\s+");
        String name = "", surname = "", patronymic = "";

        try {
            name = namesArray[1];
            surname = namesArray[0];
            patronymic = namesArray[2];
        } catch (ArrayIndexOutOfBoundsException e) {
            // обрабатывается позже в MyFrame в диалоге
        }

        return new Person(name, surname, patronymic);
    }

    private void setNameProgressBar(int textSize) {

        nameProgressBar.setValue(textSize);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        rootPanel = this;
    }

}
