package exercices.work.EX_05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/* Ex05_fen08:
    une zone de texte affichant 0
    un bouton "-" pour diminuer la valeur du nombre affiché
    un bouton "+" pour augmenter la valeur du nombre affiché
    un bouton "Reset" pour remettre le nombre à 0 */
public class Ex05_fen08 extends JFrame {
    private JFrame jFrame = new JFrame(getClass().getName());
    private JPanel jpanel = new JPanel();

    private String textFeildContent = "0";
    private JTextField textFeild = new JTextField(3);
    private String textBtnAdd = "+";
    private JButton btnAdd = new JButton(textBtnAdd);
    private String textBtnMin = "-";
    private JButton btnMin = new JButton(textBtnMin);

    public Ex05_fen08() {

        jFrame.setSize(300, 60);
        setBounds(100, 400, 300, 100);

        Ex05_fen08_content();

        jFrame.getContentPane().add(jpanel);
        jFrame.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    public void Ex05_fen08_content() {
        textFeild.setText(textFeildContent);

        jpanel.add(btnMin);
        jpanel.add(textFeild);
        jpanel.add(btnAdd);

        btnMin.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        actionNbr(e);
                    }
                }
        );

        btnAdd.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        actionNbr(e);
                    }
                }
        );
    }

    private void actionNbr(ActionEvent e) {
        String buttonText = ((JButton) e.getSource()).getActionCommand();
        int nbr = Integer.parseInt(textFeild.getText());

        if (buttonText.equals(textBtnMin)) {
            if (nbr > 0) {
                nbr = nbr - 1;
                textFeild.setText(String.valueOf(nbr));
            }
        }

        if (buttonText.equals(textBtnAdd)) {
            nbr = nbr + 1;
            textFeild.setText(String.valueOf(nbr));
        }

    }

    public static void main(String[] args) {
        JFrame jframe = new Ex05_fen08();
    }

}
