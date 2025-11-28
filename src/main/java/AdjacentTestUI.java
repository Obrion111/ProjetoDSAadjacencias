import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class AdjacentTestUI extends JFrame {



    private JTextField inputField;
    private JTextArea outputArea;
    private KeyboardAdjacency kb;

    public AdjacentTestUI(){

        kb = new KeyboardAdjacency();

        inputField = new JTextField();
        outputArea = new JTextArea();
            outputArea.setEditable(false);


        setLayout(new java.awt.BorderLayout());
        add(inputField, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // keylistener
       inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                mostrarAdjacentes();
            }
        });


        setTitle("Testar Adjacencias");
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }


    private void mostrarAdjacentes(){
        String texto = inputField.getText().toLowerCase();

        if(texto.isEmpty()){
            outputArea.setText("");
            return;
        }


        StringBuilder sb = new StringBuilder();

        // Última letra que o utilizador escreveu
        for(int i = 0; i< texto.length(); i++){



        char c = texto.charAt(i);

        List<Character> adj = kb.getPossibleChars(c);

        sb.append("Letra '").append(c).append("' → ").append(adj).append("\n");
        }



        outputArea.setText(sb.toString());
    }

        }




