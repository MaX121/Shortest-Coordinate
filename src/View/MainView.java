package View;

import Modal.MainModal;
import distance_measurement.Controller.DistanceMeasurement;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class MainView extends JFrame implements ActionListener {

    private JButton exitButton, processButton, howToUseButton;
    private ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
    private HashMap<String, String> changeName = new HashMap<>();
    private ArrayList<JLabel> labelCollection = new ArrayList<>();
    private JCheckBox checkC11, checkC12, checkC13, checkC14, checkC15, checkC16, checkC17, checkC18, checkC19, checkC20, checkC21, checkC22, checkC23, checkC24, checkC25, checkC26, checkC27, checkC28, checkC29, checkC30, checkC31, checkC32, checkC33, checkC34, checkC35, checkC36, checkC37, checkC38, checkC39, checkC40;
    private JLabel labelC11, labelC12, labelC13, labelC14, labelC15, labelC16, labelC17, labelC18, labelC19, labelC20, labelC21, labelC22, labelC23, labelC24, labelC25, labelC26, labelC27, labelC28, labelC29, labelC30, labelC31, labelC32, labelC33, labelC34, labelC35, labelC36, labelC37, labelC38, labelC39, labelC40, titleLabel;

    public MainView() {

        // frame properties
        // configuring layout, title, and other prop

        setLayout(null);
        setVisible(true);
        setSize(630 , 510);
        setTitle("Finnua Bakery");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        labelC11 = new JLabel("BT PN");
        labelC11.setBounds(60, 60, 250, 25);
        labelC11.setLabelFor(checkC11);
        labelCollection.add(labelC11);
        add(labelC11);

        checkC11 = new JCheckBox();
        checkC11.setBounds(30,60, 30, 25);
        checkBoxes.add(checkC11);
        checkC11.setToolTipText("C 11");
        add(checkC11);

        labelC12 = new JLabel("Bu Ripto");
        labelC12.setBounds(60, 90, 250, 25);
        labelC12.setLabelFor(checkC12);
        labelCollection.add(labelC12);
        add(labelC12);

        checkC12 = new JCheckBox();
        checkBoxes.add(checkC12);
        checkC12.setToolTipText("C 12");
        checkC12.setBounds(30, 90, 30, 25);
        add(checkC12);

        labelC13 = new JLabel("Bu Endah");
        labelC13.setBounds(60, 120, 250, 25);
        labelC13.setLabelFor(checkC13);
        labelCollection.add(labelC13);
        add(labelC13);

        checkC13 = new JCheckBox();
        checkBoxes.add(checkC13);
        checkC13.setToolTipText("C 13");
        checkC13.setBounds(30, 120, 30, 25);
        add(checkC13);

        labelC14 = new JLabel("Bu Mamik");
        labelC14.setBounds(60, 150, 250, 25);
        labelC14.setLabelFor(checkC14);
        labelCollection.add(labelC14);
        add(labelC14);

        checkC14 = new JCheckBox();
        checkBoxes.add(checkC14);
        checkC14.setToolTipText("C 14");
        checkC14.setBounds(30, 150, 30, 25);
        add(checkC14);

        labelC15 = new JLabel("Bu Heni");
        labelC15.setBounds(60, 180, 250, 25);
        labelC15.setLabelFor(checkC15);
        labelCollection.add(labelC15);
        add(labelC15);

        checkC15 = new JCheckBox();
        checkBoxes.add(checkC15);
        checkC15.setToolTipText("C 15");
        checkC15.setBounds(30, 180, 30, 25);
        add(checkC15);

        labelC16 = new JLabel("Pak Mujiono");
        labelC16.setBounds(60, 210, 250, 25);
        labelC16.setLabelFor(checkC16);
        labelCollection.add(labelC16);
        add(labelC16);

        checkC16 = new JCheckBox();
        checkBoxes.add(checkC16);
        checkC16.setToolTipText("C 16");
        checkC16.setBounds(30, 210, 30, 25);
        add(checkC16);

        labelC17 = new JLabel("Mbak Ismi");
        labelC17.setBounds(60, 240, 250, 25);
        labelC17.setLabelFor(checkC17);
        labelCollection.add(labelC17);
        add(labelC17);

        checkC17 = new JCheckBox();
        checkBoxes.add(checkC17);
        checkC17.setToolTipText("C 17");
        checkC17.setBounds(30, 240, 30, 25);
        add(checkC17);

        labelC18 = new JLabel("Mbak Miranda");
        labelC18.setBounds(60, 270, 250, 25);
        labelC18.setLabelFor(checkC18);
        labelCollection.add(labelC18);
        add(labelC18);

        checkC18 = new JCheckBox();
        checkBoxes.add(checkC18);
        checkC18.setToolTipText("C 18");
        checkC18.setBounds(30, 270, 30, 25);
        add(checkC18);

        labelC19 = new JLabel("Happy Juice");
        labelC19.setBounds(60, 300, 250, 25);
        labelC19.setLabelFor(checkC19);
        labelCollection.add(labelC19);
        add(labelC19);

        checkC19 = new JCheckBox();
        checkBoxes.add(checkC19);
        checkC19.setToolTipText("C 19");
        checkC19.setBounds(30, 300, 30, 25);
        add(checkC19);

        labelC20 = new JLabel("Potong Rambut");
        labelC20.setBounds(60, 330, 250, 25);
        labelC20.setLabelFor(checkC20);
        labelCollection.add(labelC20);
        add(labelC20);

        checkC20 = new JCheckBox();
        checkBoxes.add(checkC20);
        checkC20.setToolTipText("C 20");
        checkC20.setBounds(30, 330, 30, 25);
        add(checkC20);

        labelC21 = new JLabel("Bu Sulami");
        labelC21.setBounds(290, 60, 250, 25);
        labelC21.setLabelFor(checkC21);
        labelCollection.add(labelC21);
        add(labelC21);

        checkC21 = new JCheckBox();
        checkBoxes.add(checkC21);
        checkC21.setToolTipText("C 21");
        checkC21.setBounds(260,60, 30, 25);
        add(checkC21);

        labelC22 = new JLabel("Bu Wiwik");
        labelC22.setBounds(290, 90, 250, 25);
        labelC22.setLabelFor(checkC22);
        labelCollection.add(labelC22);
        add(labelC22);

        checkC22 = new JCheckBox();
        checkBoxes.add(checkC22);
        checkC22.setToolTipText("C 22");
        checkC22.setBounds(260, 90, 30, 25);
        add(checkC22);

        labelC23 = new JLabel("Ny Suyatmin");
        labelC23.setBounds(290, 120, 250, 25);
        labelC23.setLabelFor(checkC23);
        labelCollection.add(labelC23);
        add(labelC23);

        checkC23 = new JCheckBox();
        checkBoxes.add(checkC23);
        checkC23.setToolTipText("C 23");
        checkC23.setBounds(260, 120, 30, 25);
        add(checkC23);

        labelC24 = new JLabel("Bu Yayuk");
        labelC24.setBounds(290, 150, 250, 25);
        labelC24.setLabelFor(checkC24);
        labelCollection.add(labelC24);
        add(labelC24);

        checkC24 = new JCheckBox();
        checkBoxes.add(checkC24);
        checkC24.setToolTipText("C 24");
        checkC24.setBounds(260, 150, 30, 25);
        add(checkC24);

        labelC25 = new JLabel("Bu Suhari");
        labelC25.setBounds(290, 180, 250, 25);
        labelC25.setLabelFor(checkC25);
        labelCollection.add(labelC25);
        add(labelC25);

        checkC25 = new JCheckBox();
        checkBoxes.add(checkC25);
        checkC25.setToolTipText("C 25");
        checkC25.setBounds(260, 180, 30, 25);
        add(checkC25);

        labelC26 = new JLabel("Bu Nita");
        labelC26.setBounds(290, 210, 250, 25);
        labelC26.setLabelFor(checkC26);
        labelCollection.add(labelC26);
        add(labelC26);

        checkC26 = new JCheckBox();
        checkBoxes.add(checkC26);
        checkC26.setToolTipText("C 26");
        checkC26.setBounds(260, 210, 30, 25);
        add(checkC26);

        labelC27 = new JLabel("Pak Adam");
        labelC27.setBounds(290, 240, 250, 25);
        labelC27.setLabelFor(checkC27);
        labelCollection.add(labelC27);
        add(labelC27);

        checkC27 = new JCheckBox();
        checkBoxes.add(checkC27);
        checkC27.setToolTipText("C 27");
        checkC27.setBounds(260, 240, 30, 25);
        add(checkC27);

        labelC28 = new JLabel("Bu Karni");
        labelC28.setBounds(290, 270, 250, 25);
        labelC28.setLabelFor(checkC28);
        labelCollection.add(labelC28);
        add(labelC28);

        checkC28 = new JCheckBox();
        checkBoxes.add(checkC28);
        checkC28.setToolTipText("C 28");
        checkC28.setBounds(260, 270, 30, 25);
        add(checkC28);

        labelC29 = new JLabel("Bu Sugiyem");
        labelC29.setBounds(290, 300, 250, 25);
        labelC29.setLabelFor(checkC29);
        labelCollection.add(labelC29);
        add(labelC29);

        checkC29 = new JCheckBox();
        checkBoxes.add(checkC29);
        checkC29.setToolTipText("C 29");
        checkC29.setBounds(260, 300, 30, 25);
        add(checkC29);

        labelC30 = new JLabel("Mbak Septi");
        labelC30.setBounds(290, 330, 250, 25);
        labelC30.setLabelFor(checkC30);
        labelCollection.add(labelC30);
        add(labelC30);

        checkC30 = new JCheckBox();
        checkBoxes.add(checkC30);
        checkC30.setToolTipText("C 30");
        checkC30.setBounds(260, 330, 30, 25);
        add(checkC30);

        labelC31 = new JLabel("Bu Surip");
        labelC31.setBounds(490, 330, 250, 25);
        labelC31.setLabelFor(checkC31);
        labelCollection.add(labelC31);
        add(labelC31);

        checkC31 = new JCheckBox();
        checkBoxes.add(checkC31);
        checkC31.setToolTipText("C 31");
        checkC31.setBounds(460, 330, 30, 25);
        add(checkC31);

        labelC32 = new JLabel("Bu Waluyo");
        labelC32.setBounds(490, 60, 250, 25);
        labelC32.setLabelFor(checkC32);
        labelCollection.add(labelC32);
        add(labelC32);

        checkC32 = new JCheckBox();
        checkBoxes.add(checkC32);
        checkC32.setToolTipText("C 32");
        checkC32.setBounds(460, 60, 30, 25);
        add(checkC32);

        labelC33 = new JLabel("Mas Ragil");
        labelC33.setBounds(490, 90, 250, 25);
        labelC33.setLabelFor(checkC33);
        labelCollection.add(labelC33);
        add(labelC33);

        checkC33 = new JCheckBox();
        checkBoxes.add(checkC33);
        checkC33.setToolTipText("C 33");
        checkC33.setBounds(460, 90, 30, 25);
        add(checkC33);

        labelC34 = new JLabel("Bu Jum");
        labelC34.setBounds(490, 120, 250, 25);
        labelC34.setLabelFor(checkC34);
        labelCollection.add(labelC34);
        add(labelC34);

        checkC34 = new JCheckBox();
        checkBoxes.add(checkC34);
        checkC34.setToolTipText("C 34");
        checkC34.setBounds(460, 120, 30, 25);
        add(checkC34);

        labelC35 = new JLabel("Bu Murni");
        labelC35.setBounds(490, 150, 250, 25);
        labelC35.setLabelFor(checkC35);
        labelCollection.add(labelC35);
        add(labelC35);

        checkC35 = new JCheckBox();
        checkBoxes.add(checkC35);
        checkC35.setToolTipText("C 35");
        checkC35.setBounds(460, 150, 30, 25);
        add(checkC35);

        labelC36 = new JLabel("Bu Maryani");
        labelC36.setBounds(490, 180, 250, 25);
        labelC36.setLabelFor(checkC36);
        labelCollection.add(labelC36);
        add(labelC36);

        checkC36 = new JCheckBox();
        checkBoxes.add(checkC36);
        checkC36.setToolTipText("C 36");
        checkC36.setBounds(460, 180, 30, 25);
        add(checkC36);

        labelC37 = new JLabel("Bu Sri Sukarti");
        labelC37.setBounds(490, 210, 250, 25);
        labelC37.setLabelFor(checkC37);
        labelCollection.add(labelC37);
        add(labelC37);

        checkC37 = new JCheckBox();
        checkBoxes.add(checkC37);
        checkC37.setToolTipText("C 37");
        checkC37.setBounds(460, 210, 30, 25);
        add(checkC37);

        labelC38 = new JLabel("Mas Damar");
        labelC38.setBounds(490, 240, 250, 25);
        labelC38.setLabelFor(checkC38);
        labelCollection.add(labelC38);
        add(labelC38);

        checkC38 = new JCheckBox();
        checkBoxes.add(checkC38);
        checkC38.setToolTipText("C 38");
        checkC38.setBounds(460, 240, 30, 25);
        add(checkC38);

        labelC39 = new JLabel("Bu Supardi");
        labelC39.setBounds(490, 270, 250, 25);
        labelC39.setLabelFor(checkC39);
        labelCollection.add(labelC39);
        add(labelC39);

        checkC39 = new JCheckBox();
        checkBoxes.add(checkC39);
        checkC39.setToolTipText("C 39");
        checkC39.setBounds(460, 270, 30, 25);
        add(checkC39);

        labelC40 = new JLabel("Pak Broto");
        labelC40.setBounds(490, 300, 250, 25);
        labelC40.setLabelFor(checkC40);
        labelCollection.add(labelC40);
        add(labelC40);

        checkC40 = new JCheckBox();
        checkBoxes.add(checkC40);
        checkC40.setToolTipText("C 40");
        checkC40.setBounds(460, 300, 30, 25);
        add(checkC40);

        // help button to view the basic documentation
        // this will popup a single window a basic instruction

        howToUseButton = new JButton("CARA MENGGUNAKAN");
        howToUseButton.setBounds(30, 380, 555, 25);
        howToUseButton.addActionListener(this);
        howToUseButton.setToolTipText("Tutorial cara menggunakan");
        add(howToUseButton);

        // process button to send the selected data to main program
        // this is the default button on this view

        processButton = new JButton("PROSES DATA");
        processButton.setBounds(30, 420, 250, 25);
        processButton.addActionListener(this);
        processButton.setToolTipText("Proses data");
        add(processButton);

        // exit button to exit the apps

        exitButton = new JButton("EXIT");
        exitButton.setBounds(335, 420, 250, 25);
        exitButton.addActionListener(this);
        exitButton.setToolTipText("Keluar dari aplikasi");
        add(exitButton);

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
            JOptionPane.showMessageDialog(null, "Cara Menggunakan" +
                    "\n01. Berikan tanda centang pada kota yang diinginkan" +
                    "\n02. Klik tombol PROSES DATA untuk menjalankan program" +
                    "\n04. Route yang akan dilalui akan muncul pada kotak dialog");
        }

        if (e.getSource() == processButton) {

            // set the cityList value to perform the calc
            int nrofCity = 0;
            MainModal mainModal = new MainModal();
            ArrayList<String> cityList = new ArrayList<>();
            for (JCheckBox visitedCity : checkBoxes) {
                if (visitedCity.isSelected()) {
                    nrofCity++;
                    cityList.add(visitedCity.getToolTipText());
                    mainModal.addCity(visitedCity.getToolTipText(), 0);
                }
            }

            try {
                DistanceMeasurement distanceMeasurement = new DistanceMeasurement();
                JOptionPane.showMessageDialog(null, distanceMeasurement.terpendek(cityList));
            } catch (Exception ex) {
                ex.printStackTrace();
                System.err.println("Something wrong");
                System.err.println("Error message : " + ex.getMessage());
                JOptionPane.showMessageDialog(null, "Something wrong");
            } finally {
                cityList.clear(); // clear all values caught in cityList ArrayList
            }
        }
    }

}
