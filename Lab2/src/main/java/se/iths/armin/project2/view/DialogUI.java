package se.iths.armin.project2.view;

import javax.swing.*;
import java.util.List;

public class DialogUI implements UI {

    @Override
    public String prompt(String message, String type) {
        return JOptionPane.showInputDialog(null, message, type, JOptionPane.QUESTION_MESSAGE);
    }

    @Override
    public void info(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    public String menu(String title, List<String> options) {
        Object[] opts = options.toArray();
        int index = JOptionPane.showOptionDialog(
                null,
                title,
                title,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opts,
                opts.length > 0 ? opts[0] : null
        );
        if (index == JOptionPane.CLOSED_OPTION || index < 0) {
            return null;
        }
        return options.get(index);
    }

    public void scrollableList(String message) {
        JTextArea textArea = new JTextArea(message, 20, 40);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane, "Product List", JOptionPane.INFORMATION_MESSAGE);

    }
}
