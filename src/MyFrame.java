import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class MyFrame extends JFrame {

    private FirstForm firstForm = new FirstForm();
    private SecondForm secondForm = new SecondForm();

    public MyFrame() {

        String key = "key";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK), key);
        ActionMap actionMap = getRootPane().getActionMap();

        actionMap.put(key, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeForm();
            }
        });

        setMinimumSize(new Dimension(350, 180));
        pack();
        setTitle("JFrame experiments");
        setContentPane(firstForm.getRootPanel());
        firstForm.addListener(e -> changeForm());
        secondForm.addListener(e -> changeForm());
    }

    private void changeForm() {

        if (getContentPane() == firstForm.getRootPanel()) {
            changeToSecondForm();
        } else {
            changeToFirstForm();
        }
    }


    private void changeToFirstForm() {
        Person person = secondForm.getPerson();

        if (canChangeForm(person)) {
            firstForm.setPerson(person);
            repaintJFrame(firstForm);
        }
    }

    private void changeToSecondForm() {
        Person person = firstForm.getPerson();

        if (canChangeForm(person)) {
            secondForm.setPerson(person);
            repaintJFrame(secondForm);
        }
    }

    private void repaintJFrame(Container container) {
        setContentPane(container);
        getContentPane().revalidate();
        getContentPane().repaint();
    }


    private boolean canChangeForm(Person person) {
        boolean changeForm = false;

        if (person.nameAndSurnameCompleted()) {
            if (person.patronymicCompleted()) {
                changeForm = true;

            } else {
                String options[] = {"Да", "Нет"};

                int command =
                        JOptionPane.showOptionDialog(null, "Вы не ввели отчество, желаете продолжить", "Внимание",
                                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

                if (command == JOptionPane.YES_OPTION) {
                    changeForm = true;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Данные введны не корректно",
                    "Ошибка", JOptionPane.ERROR_MESSAGE, null);
        }
        return changeForm;
    }

}
