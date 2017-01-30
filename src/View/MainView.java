package View;

import Modal.MainModal;
import distance_measurement.Controller.DistanceMeasurement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainView extends JFrame implements ActionListener {

    private JPanel textPanel;
    private JTextArea textArea;
    private JButton exitButton, processButton, howToUseButton;
    private ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
    private ArrayList<JTextField> textFields = new ArrayList<>();
    private JTextField textC11, textC12, textC13, textC14, textC15, textC16, textC17, textC18, textC19, textC20, textC21, textC22, textC23, textC24, textC25, textC26, textC27, textC28, textC29, textC30;
    private JCheckBox checkC11, checkC12, checkC13, checkC14, checkC15, checkC16, checkC17, checkC18, checkC19, checkC20, checkC21, checkC22, checkC23, checkC24, checkC25, checkC26, checkC27, checkC28, checkC29, checkC30;
    private JLabel labelC11, labelC12, labelC13, labelC14, labelC15, labelC16, labelC17, labelC18, labelC19, labelC20, labelC21, labelC22, labelC23, labelC24, labelC25, labelC26, labelC27, labelC28, labelC29, labelC30, titleLabel;

    private MainView() {

        // frame properties
        // configuring layout, title, and other prop

        setLayout(null);
        setVisible(true);
        setSize(955 , 510);
        setTitle("PT. Roti Bakar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // adding C 11 into arraylist
        // C 11 city text, check, and label

        labelC11 = new JLabel("C 11");
        labelC11.setBounds(60, 60, 50, 25);
        labelC11.setLabelFor(checkC11);
        add(labelC11);

        checkC11 = new JCheckBox();
        checkC11.setBounds(30,60, 30, 25);
        checkBoxes.add(checkC11);
        checkC11.addActionListener(this);
        add(checkC11);

        textC11 = new JTextField();
        textC11.setEditable(false);
        textFields.add(textC11);
        textC11.setName("C 11");
        textC11.setBounds(120, 60, 110, 25);
        add(textC11);

        // adding C 12 into an array list
        // C 12 city text, check, and label

        labelC12 = new JLabel("C 12");
        labelC12.setBounds(60, 90, 50, 25);
        labelC12.setLabelFor(checkC12);
        add(labelC12);

        checkC12 = new JCheckBox();
        checkBoxes.add(checkC12);
        checkC12.setBounds(30, 90, 30, 25);
        checkC12.addActionListener(this);
        add(checkC12);

        textC12 = new JTextField();
        textC12.setEditable(false);
        textFields.add(textC12);
        textC12.setName("C 12");
        textC12.setBounds(120, 90, 110, 25);
        add(textC12);

        // adding C 13 into an array list
        // C 13 city text, check, and label

        labelC13 = new JLabel("C 13");
        labelC13.setBounds(60, 120, 50, 25);
        labelC13.setLabelFor(checkC12);
        add(labelC13);

        checkC13 = new JCheckBox();
        checkBoxes.add(checkC13);
        checkC13.setBounds(30, 120, 30, 25);
        checkC13.addActionListener(this);
        add(checkC13);

        textC13 = new JTextField();
        textC13.setEditable(false);
        textFields.add(textC13);
        textC13.setName("C 13");
        textC13.setBounds(120, 120, 110, 25);
        add(textC13);

        // adding C 14 into an array list
        // C 14 city text, check, and label

        labelC14 = new JLabel("C 14");
        labelC14.setBounds(60, 150, 50, 25);
        labelC14.setLabelFor(checkC12);
        add(labelC14);

        checkC14 = new JCheckBox();
        checkBoxes.add(checkC14);
        checkC14.setBounds(30, 150, 30, 25);
        checkC14.addActionListener(this);
        add(checkC14);

        textC14 = new JTextField();
        textC14.setEditable(false);
        textFields.add(textC14);
        textC14.setName("C 14");
        textC14.setBounds(120, 150, 110, 25);
        add(textC14);

        // adding C 15 into an array list
        // C 15 city text, check, and label

        labelC15 = new JLabel("C 15");
        labelC15.setBounds(60, 180, 50, 25);
        labelC15.setLabelFor(checkC12);
        add(labelC15);

        checkC15 = new JCheckBox();
        checkBoxes.add(checkC15);
        checkC15.setBounds(30, 180, 30, 25);
        checkC15.addActionListener(this);
        add(checkC15);

        textC15 = new JTextField();
        textC15.setEditable(false);
        textFields.add(textC15);
        textC15.setName("C 15");
        textC15.setBounds(120, 180, 110, 25);
        add(textC15);

        // adding C 16 into an array list
        // C 16 city text, check, and label

        labelC16 = new JLabel("C 16");
        labelC16.setBounds(60, 210, 50, 25);
        labelC16.setLabelFor(checkC16);
        add(labelC16);

        checkC16 = new JCheckBox();
        checkBoxes.add(checkC16);
        checkC16.setBounds(30, 210, 30, 25);
        checkC16.addActionListener(this);
        add(checkC16);

        textC16 = new JTextField();
        textC16.setEditable(false);
        textFields.add(textC16);
        textC16.setName("C 16");
        textC16.setBounds(120, 210, 110, 25);
        add(textC16);

        // adding C 17 into an array list
        // C 17 city text, check, and label

        labelC17 = new JLabel("C 17");
        labelC17.setBounds(60, 240, 50, 25);
        labelC17.setLabelFor(checkC17);
        add(labelC17);

        checkC17 = new JCheckBox();
        checkBoxes.add(checkC17);
        checkC17.setBounds(30, 240, 30, 25);
        checkC17.addActionListener(this);
        add(checkC17);

        textC17 = new JTextField();
        textC17.setEditable(false);
        textFields.add(textC17);
        textC17.setName("C 17");
        textC17.setBounds(120, 240, 110, 25);
        add(textC17);

        // adding C 18 into an array list
        // C 18 city text, check, and label

        labelC18 = new JLabel("C 18");
        labelC18.setBounds(60, 270, 50, 25);
        labelC18.setLabelFor(checkC18);
        add(labelC18);

        checkC18 = new JCheckBox();
        checkBoxes.add(checkC18);
        checkC18.setBounds(30, 270, 30, 25);
        checkC18.addActionListener(this);
        add(checkC18);

        textC18 = new JTextField();
        textC18.setEditable(false);
        textFields.add(textC18);
        textC18.setName("C 18");
        textC18.setBounds(120, 270, 110, 25);
        add(textC18);

        // adding C 19 into an array list
        // C 19 city text, check, and label

        labelC19 = new JLabel("C 19");
        labelC19.setBounds(60, 300, 50, 25);
        labelC19.setLabelFor(checkC19);
        add(labelC19);

        checkC19 = new JCheckBox();
        checkBoxes.add(checkC19);
        checkC19.setBounds(30, 300, 30, 25);
        checkC19.addActionListener(this);
        add(checkC19);

        textC19 = new JTextField();
        textC19.setEditable(false);
        textFields.add(textC19);
        textC19.setName("C 19");
        textC19.setBounds(120, 300, 110, 25);
        add(textC19);

        // adding C 20 into an array list
        // C 20 city text, check, and label

        labelC20 = new JLabel("C 20");
        labelC20.setBounds(60, 330, 50, 25);
        labelC20.setLabelFor(checkC20);
        add(labelC20);

        checkC20 = new JCheckBox();
        checkBoxes.add(checkC20);
        checkC20.setBounds(30, 330, 30, 25);
        checkC20.addActionListener(this);
        add(checkC20);

        textC20 = new JTextField();
        textC20.setEditable(false);
        textFields.add(textC20);
        textC20.setName("C 20");
        textC20.setBounds(120, 330, 110, 25);
        add(textC20);

        // adding C 21 into arraylist
        // C 21 city text, check, and label

        labelC21 = new JLabel("C 21");
        labelC21.setBounds(290, 60, 50, 25);
        labelC21.setLabelFor(checkC21);
        add(labelC21);

        checkC21 = new JCheckBox();
        checkBoxes.add(checkC21);
        checkC21.setBounds(260,60, 30, 25);
        checkC21.addActionListener(this);
        add(checkC21);

        textC21 = new JTextField();
        textC21.setEditable(false);
        textFields.add(textC21);
        textC21.setName("C 21");
        textC21.setBounds(350, 60, 110, 25);
        add(textC21);

        // adding C 22 into an array list
        // C 22 city text, check, and label

        labelC22 = new JLabel("C 22");
        labelC22.setBounds(290, 90, 50, 25);
        labelC22.setLabelFor(checkC22);
        add(labelC22);

        checkC22 = new JCheckBox();
        checkBoxes.add(checkC22);
        checkC22.setBounds(260, 90, 30, 25);
        checkC22.addActionListener(this);
        add(checkC22);

        textC22 = new JTextField();
        textC22.setEditable(false);
        textFields.add(textC22);
        textC22.setName("C 22");
        textC22.setBounds(350, 90, 110, 25);
        add(textC22);

        // adding C 23 into an array list
        // C 23 city text, check, and label

        labelC23 = new JLabel("C 23");
        labelC23.setBounds(290, 120, 50, 25);
        labelC23.setLabelFor(checkC23);
        add(labelC23);

        checkC23 = new JCheckBox();
        checkBoxes.add(checkC23);
        checkC23.setBounds(260, 120, 30, 25);
        checkC23.addActionListener(this);
        add(checkC23);

        textC23 = new JTextField();
        textC23.setEditable(false);
        textFields.add(textC23);
        textC23.setName("C 23");
        textC23.setBounds(350, 120, 110, 25);
        add(textC23);

        // adding C 24 into an array list
        // C 24 city text, check, and label

        labelC24 = new JLabel("C 24");
        labelC24.setBounds(290, 150, 50, 25);
        labelC24.setLabelFor(checkC24);
        add(labelC24);

        checkC24 = new JCheckBox();
        checkBoxes.add(checkC24);
        checkC24.setBounds(260, 150, 30, 25);
        checkC24.addActionListener(this);
        add(checkC24);

        textC24 = new JTextField();
        textC24.setEditable(false);
        textFields.add(textC24);
        textC24.setName("C 24");
        textC24.setBounds(350, 150, 110, 25);
        add(textC24);

        // adding C 25 into an array list
        // C 25 city text, check, and label

        labelC25 = new JLabel("C 25");
        labelC25.setBounds(290, 180, 50, 25);
        labelC25.setLabelFor(checkC25);
        add(labelC25);

        checkC25 = new JCheckBox();
        checkBoxes.add(checkC25);
        checkC25.setBounds(260, 180, 30, 25);
        checkC25.addActionListener(this);
        add(checkC25);

        textC25 = new JTextField();
        textC25.setEditable(false);
        textFields.add(textC25);
        textC25.setName("C 25");
        textC25.setBounds(350, 180, 110, 25);
        add(textC25);

        // adding C 26 into an array list
        // C 26 city text, check, and label

        labelC26 = new JLabel("C 26");
        labelC26.setBounds(290, 210, 50, 25);
        labelC26.setLabelFor(checkC26);
        add(labelC26);

        checkC26 = new JCheckBox();
        checkBoxes.add(checkC26);
        checkC26.setBounds(260, 210, 30, 25);
        checkC26.addActionListener(this);
        add(checkC26);

        textC26 = new JTextField();
        textC26.setEditable(false);
        textFields.add(textC26);
        textC26.setName("C 26");
        textC26.setBounds(350, 210, 110, 25);
        add(textC26);

        // adding C 27 into an array list
        // C 27 city text, check, and label

        labelC27 = new JLabel("C 27");
        labelC27.setBounds(290, 240, 50, 25);
        labelC27.setLabelFor(checkC27);
        add(labelC27);

        checkC27 = new JCheckBox();
        checkBoxes.add(checkC27);
        checkC27.setBounds(260, 240, 30, 25);
        checkC27.addActionListener(this);
        add(checkC27);

        textC27 = new JTextField();
        textC27.setEditable(false);
        textFields.add(textC27);
        textC27.setName("C 27");
        textC27.setBounds(350, 240, 110, 25);
        add(textC27);

        // adding C 28 into an array list
        // C 28 city text, check, and label

        labelC28 = new JLabel("C 28");
        labelC28.setBounds(290, 270, 50, 25);
        labelC28.setLabelFor(checkC28);
        add(labelC28);

        checkC28 = new JCheckBox();
        checkBoxes.add(checkC28);
        checkC28.setBounds(260, 270, 30, 25);
        checkC28.addActionListener(this);
        add(checkC28);

        textC28 = new JTextField();
        textC28.setEditable(false);
        textFields.add(textC28);
        textC28.setName("C 28");
        textC28.setBounds(350, 270, 110, 25);
        add(textC28);

        // adding C 29 into an array list
        // C 29 city text, check, and label

        labelC29 = new JLabel("C 29");
        checkBoxes.add(checkC29);
        labelC29.setBounds(290, 300, 50, 25);
        labelC29.setLabelFor(checkC29);
        add(labelC29);

        checkC29 = new JCheckBox();
        checkC29.setBounds(260, 300, 30, 25);
        checkC29.addActionListener(this);
        add(checkC29);

        textC29 = new JTextField();
        textC29.setEditable(false);
        textFields.add(textC29);
        textC29.setName("C 29");
        textC29.setBounds(350, 300, 110, 25);
        add(textC29);

        // adding C 30 into an array list
        // C 30 city text, check, and label

        labelC30 = new JLabel("C 30");
        labelC30.setBounds(290, 330, 50, 25);
        labelC30.setLabelFor(checkC30);
        add(labelC30);

        checkC30 = new JCheckBox();
        checkBoxes.add(checkC30);
        checkC30.setBounds(260, 330, 30, 25);
        checkC30.addActionListener(this);
        add(checkC30);

        textC30 = new JTextField();
        textC30.setEditable(false);
        textFields.add(textC30);
        textC30.setName("C 30");
        textC30.setBounds(350, 330, 110, 25);
        add(textC30);

        // help button to view the basic documentation
        // this will popup a single window a basic instruction

        howToUseButton = new JButton("CARA MENGGUNAKAN");
        howToUseButton.setBounds(30, 380, 430, 25);
        howToUseButton.addActionListener(this);
        howToUseButton.setToolTipText("Tutorial cara menggunakan");
        add(howToUseButton);

        // process button to send the selected data to main program
        // this is the default button on this view

        processButton = new JButton("PROSES DATA");
        processButton.setBounds(30, 420, 200, 25);
        processButton.addActionListener(this);
        processButton.setToolTipText("Proses data");
        add(processButton);

        // exit button to exit the apps

        exitButton = new JButton("EXIT");
        exitButton.setBounds(260, 420, 200, 25);
        exitButton.addActionListener(this);
        exitButton.setToolTipText("Keluar dari aplikasi");
        add(exitButton);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        textArea.setBounds(500, 60, 430, 385);
        add(textArea);

    }

    public static void main(String[] args) {

        MainView mainView = new MainView();
        mainView.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exitButton) {
            System.exit(EXIT_ON_CLOSE);
        }

        if (e.getSource() == howToUseButton) {
            System.out.println("Tombol bantuan diklik");
            JOptionPane.showMessageDialog(null, "Cara Menggunakan" +
                    "\n\n01. Berikan tanda centang pada kota yang diinginkan" +
                    "\n02. Isikan jumlah roti yang hendak dikirikman pada kotak teks" +
                    "\n03. Klik tombol PROSES DATA untuk menjalankan program" +
                    "\n04. Hasil perhitungan akan muncul di kotak teks dibawah");
        }

        if (e.getSource() == processButton) {

            ArrayList <String> cityList = new ArrayList<>();

            int nrofCity = 0;
            MainModal modal = new MainModal();
            for (JTextField text : textFields) {
                if (text.isEditable()) {
                    nrofCity++;
                    cityList.add(text.getName());
                    modal.addCity(text.getName(), Integer.parseInt(text.getText()));
                }
            }

            try {
                DistanceMeasurement distanceMeasurement = new DistanceMeasurement();
                textArea.setText(distanceMeasurement.terpendek(cityList));
            } catch (Exception ex) {
                System.err.println("Something wrong");
                System.err.println("Error message : " + ex.getMessage());
            }

        }

        if (e.getSource() == checkC11) {
            textC11.setEditable(true);
            if (!checkC11.isEnabled()) {
                textC11.setText("");
                textC11.setEditable(false);
            }
        }

        if (e.getSource() == checkC12) {
            textC12.setEditable(true);
            if (!checkC12.isSelected()) {
                textC12.setText("");
                textC12.setEditable(false);
            }
        }

        if (e.getSource() == checkC13) {
            textC13.setEditable(true);
            if (!checkC13.isSelected()) {
                textC13.setText("");
                textC13.setEditable(false);
            }
        }

        if (e.getSource() == checkC14) {
            textC14.setEditable(true);
            if (!checkC14.isSelected()) {
                textC14.setText("");
                textC14.setEditable(false);
            }
        }

        if (e.getSource() == checkC15) {
            textC15.setEditable(true);
            if (!checkC15.isSelected()) {
                textC15.setText("");
                textC15.setEditable(false);
            }
        }

        if (e.getSource() == checkC16) {
            textC16.setEditable(true);
            if (!checkC16.isSelected()) {
                textC16.setText("");
                textC16.setEditable(false);
            }
        }

        if (e.getSource() == checkC17) {
            textC17.setEditable(true);
            if (!checkC17.isSelected()) {
                textC17.setText("");
                textC17.setEditable(false);
            }
        }

        if (e.getSource() == checkC18) {
            textC18.setEditable(true);
            if (!checkC18.isSelected()) {
                textC18.setText("");
                textC18.setEditable(false);
            }
        }

        if (e.getSource() == checkC19) {
            textC19.setEditable(true);
            if (!checkC19.isSelected()) {
                textC19.setText("");
                textC19.setEditable(false);
            }
        }

        if (e.getSource() == checkC20) {
            textC20.setEditable(true);
            if (!checkC20.isSelected()) {
                textC20.setText("");
                textC20.setEditable(false);
            }
        }

        if (e.getSource() == checkC21) {
            textC21.setEditable(true);
            if (!checkC21.isSelected()) {
                textC21.setText("");
                textC21.setEditable(false);
            }
        }

        if (e.getSource() == checkC22) {
            textC22.setEditable(true);
            if (!checkC22.isSelected()) {
                textC22.setText("");
                textC22.setEditable(false);
            }
        }

        if (e.getSource() == checkC23) {
            textC23.setEditable(true);
            if (!checkC23.isSelected()) {
                textC23.setText("");
                textC23.setEditable(false);
            }
        }

        if (e.getSource() == checkC23) {
            textC23.setEditable(true);
            if (!checkC23.isSelected()) {
                textC23.setText("");
                textC23.setEditable(false);
            }
        }

        if (e.getSource() == checkC24) {
            textC24.setEditable(true);
            if (!checkC24.isSelected()) {
                textC24.setText("");
                textC24.setEditable(false);
            }
        }

        if (e.getSource() == checkC25) {
            textC25.setEditable(true);
            if (!checkC25.isSelected()) {
                textC25.setText("");
                textC25.setEditable(false);
            }
        }

        if (e.getSource() == checkC26) {
            textC26.setEditable(true);
            if (!checkC26.isSelected()) {
                textC26.setText("");
                textC26.setEditable(false);
            }
        }

        if (e.getSource() == checkC27) {
            textC27.setEditable(true);
            if (!checkC27.isSelected()) {
                textC27.setText("");
                textC27.setEditable(false);
            }
        }

        if (e.getSource() == checkC28) {
            textC28.setEditable(true);
            if (!checkC28.isSelected()) {
                textC28.setText("");
                textC28.setEditable(false);
            }
        }

        if (e.getSource() == checkC29) {
            textC29.setEditable(true);
            if (!checkC29.isSelected()) {
                textC29.setText("");
                textC29.setEditable(false);
            }
        }

        if (e.getSource() == checkC30) {
            textC30.setEditable(true);
            if (!checkC30.isSelected()) {
                textC30.setText("");
                textC30.setEditable(false);
            }
        }

    }

    public static class MainDistance {



    }
}
