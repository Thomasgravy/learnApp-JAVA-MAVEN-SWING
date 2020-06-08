package examen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeyActions {
    String s;
    Pattern p = Pattern.compile("[^0-9_a-z]");

    public KeyActions (KeyEvent e, JTextField t, JLabel l) {
        checkFiled(e, t, l);
    }

    public void checkFiled (KeyEvent e,JTextField t, JLabel l) {
        s = String.valueOf(e.getKeyChar());
        Matcher m = p.matcher(s);

        if (t.isEditable() == false) {
            l.setForeground(new Color(85, 85, 85));
            l.setText("Pour éditer ce champs veiller cliquer sur Reset.");
        }else{
            if(!m.find())
            {
                e.consume();
                //System.out.println(e.getKeyChar());
                l.setForeground(new Color(215, 11, 0));
                l.setText("Vous avez entré un caractère non valide.");
            }else {
                l.setForeground(new Color(85, 85, 85));
                l.setText("Attention seul les Majuscules et les caractères spéciaux sont accepté.");
            }
        }
    }
}
