package se.iths.armin.project2.view;

import java.util.List;

public interface UI {
    public String prompt(String message, String type);

    public void info(String message);

    public String menu(String title, List<String> options);

    public void scrollableList(String message);
}
