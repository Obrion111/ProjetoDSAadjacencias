import javax.swing.*;
import java.util.List;

public class SuggestionWindow extends JFrame {

    private JTextArea suggestionArea;

    public SuggestionWindow() {
        suggestionArea = new JTextArea();
        suggestionArea.setEditable(false);

        add(new JScrollPane(suggestionArea));

        setTitle("Sugestões");
        setSize(300,300);
        setLocation(450,100);
        setVisible(true);
    }

    public void mostrarSugestoes(List<String> sugestoes){
        StringBuilder sb = new StringBuilder();
        for (String s: sugestoes){
            sb.append(s).append("\n");
        }
        suggestionArea.setText(sb.toString());
    }
}
