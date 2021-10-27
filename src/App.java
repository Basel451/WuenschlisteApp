import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

public class App extends JFrame{
    private JTextField inputfield;
    private JButton clearb;
    private JButton addb;
    private JLabel lable;
    private JLabel Tabletitel;
    private JList list1;
    private JPanel content;
    private JPanel lablespace;
    private JButton showb;
    private JButton removeb;
    private JButton updateb;
    private JButton sortb;
    private String auswahl = "";
    private ArrayList<String> liste;


    public App() {
        this.setContentPane(content);
        this.setTitle("Ihr Wünschliste");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setMaximumSize(new Dimension(700, 600));
        this.setMinimumSize(new Dimension(100, 100));
        liste = new ArrayList<>();
        this.pack();
        setVisible(true);
        // die Listener für die Button
        showb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list1.setListData(liste.toArray());
                lable.setText("Es wurden "+ liste.size()+" Elemente angezeigt!");
                Tabletitel.setText("Es sind "+ liste.size()+" Elemente vorhanden!");
            }
        });
        addb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!inputfield.getText().equals("")){
                    liste.add(inputfield.getText());
                    list1.setListData(liste.toArray());
                    lable.setText(inputfield.getText() +" wurde Elemente eingefügt!");
                    Tabletitel.setText("Es sind "+ liste.size()+" Elemente vorhanden!");
                    inputfield.setText("");
                }else{
                    lable.setText("Sie sollten etwas eingebn!!");
                }
            }
        });
        removeb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!inputfield.getText().equals("")){
                    if(liste.contains(inputfield.getText())){
                        liste.remove(inputfield.getText());
                        list1.setListData(liste.toArray());
                        lable.setText(inputfield.getText() +" wurde Elemente gelöscht!");
                        Tabletitel.setText("Es sind "+ liste.size()+" Elemente vorhanden!");
                        inputfield.setText("");
                    }else{
                        lable.setText(inputfield.getText() +" gibt in der Liste nicht!");
                        inputfield.setText("");
                    }
                }else{
                    lable.setText("Sie sollten etwas eingebn!!");
                }
            }
        });

        updateb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!inputfield.getText().equals("") ){
                    if(!auswahl.equals("")){
                        liste.set(liste.indexOf(auswahl), inputfield.getText());
                        lable.setText(auswahl+" wurde zu "+ inputfield.getText() + " geändert!");
                        inputfield.setText("");
                        list1.setListData(liste.toArray());
                    }else{
                        lable.setText("Sie sollten etwas aus der Liste auswählen!!");
                    }
                }else{
                    lable.setText("Sie sollten etwas eingebn!!");
                }
            }
        });
        sortb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liste.sort(Comparator.naturalOrder());
                list1.setListData(liste.toArray());
                lable.setText("Die Liste wurde sortiert!");
                Tabletitel.setText("Es sind "+ liste.size()+" Elemente vorhanden!");
            }
        });
        clearb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liste.clear();
                list1.setListData(liste.toArray());
                lable.setText("Es wurden "+ liste.size()+" Elemente gelöscht!");
                Tabletitel.setText("Es sind "+ liste.size()+" Elemente vorhanden!");
            }
        });

        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                auswahl = (String) list1.getSelectedValue().toString();
            }
        });
    }
    public static void main(String[] args) {
        App app = new App();
    }
}
