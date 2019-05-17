/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Image;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

/**
 *
 * @author Aspire
 */
public class Juego extends javax.swing.JFrame {

    /**
     * Creates new form Juego
     */
    public Juego() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaActions = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jPanelUp = new javax.swing.JPanel();
        jPanelCards = new javax.swing.JPanel();
        jLabelCard1 = new javax.swing.JLabel();
        jLabelCard2 = new javax.swing.JLabel();
        jLabelBestCard1 = new javax.swing.JLabel();
        jLabelBestCard2 = new javax.swing.JLabel();
        jLabelBestCard3 = new javax.swing.JLabel();
        jLabelBestCard4 = new javax.swing.JLabel();
        jLabelBestCard5 = new javax.swing.JLabel();
        jButtonCall = new javax.swing.JButton();
        jButtonRaise = new javax.swing.JButton();
        jButtonCall1 = new javax.swing.JButton();
        jButtonCall2 = new javax.swing.JButton();
        jButtonCall3 = new javax.swing.JButton();
        jButtonCall4 = new javax.swing.JButton();
        jTextFieldCards = new javax.swing.JTextField();
        jTextFieldCards1 = new javax.swing.JTextField();
        jTextFieldCards2 = new javax.swing.JTextField();
        jTextFieldCards3 = new javax.swing.JTextField();
        jPanelDown = new javax.swing.JPanel();
        jPanelLeft = new javax.swing.JPanel();
        jPanelRight = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(27, 2, 2));
        setFont(new java.awt.Font("Agency FB", 2, 18)); // NOI18N
        setForeground(new java.awt.Color(153, 153, 0));
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Spades.jpg")).getImage());
        setResizable(false);

        jPanelTable.setBackground(new java.awt.Color(1, 115, 22));
        jPanelTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 2, 2), 10));
        jPanelTable.setMaximumSize(new java.awt.Dimension(400, 250));
        jPanelTable.setMinimumSize(new java.awt.Dimension(400, 250));
        jPanelTable.setPreferredSize(new java.awt.Dimension(400, 200));

        javax.swing.GroupLayout jPanelTableLayout = new javax.swing.GroupLayout(jPanelTable);
        jPanelTable.setLayout(jPanelTableLayout);
        jPanelTableLayout.setHorizontalGroup(
            jPanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        jPanelTableLayout.setVerticalGroup(
            jPanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTextAreaActions.setBackground(new java.awt.Color(250, 255, 234));
        jTextAreaActions.setColumns(20);
        jTextAreaActions.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jTextAreaActions.setForeground(new java.awt.Color(255, 53, 53));
        jTextAreaActions.setLineWrap(true);
        jTextAreaActions.setRows(5);
        jTextAreaActions.setText("Game Actions\n");
        jTextAreaActions.setWrapStyleWord(true);
        jTextAreaActions.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(250, 255, 234), 10, true));
        jTextAreaActions.setCaretColor(new java.awt.Color(27, 2, 2));
        jTextAreaActions.setMargin(new java.awt.Insets(20, 20, 20, 20));
        jTextAreaActions.setMaximumSize(new java.awt.Dimension(400, 40000));
        jTextAreaActions.setMinimumSize(new java.awt.Dimension(200, 400));
        jTextAreaActions.setSelectedTextColor(new java.awt.Color(255, 53, 53));
        jTextAreaActions.setSelectionColor(new java.awt.Color(27, 2, 2));
        jScrollPane1.setViewportView(jTextAreaActions);

        jPanelUp.setBackground(new java.awt.Color(60, 2, 2));
        jPanelUp.setPreferredSize(new java.awt.Dimension(600, 100));

        javax.swing.GroupLayout jPanelUpLayout = new javax.swing.GroupLayout(jPanelUp);
        jPanelUp.setLayout(jPanelUpLayout);
        jPanelUpLayout.setHorizontalGroup(
            jPanelUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanelUpLayout.setVerticalGroup(
            jPanelUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelCards.setBackground(new java.awt.Color(250, 255, 234));
        jPanelCards.setPreferredSize(new java.awt.Dimension(800, 100));

        jLabelCard1.setBackground(new java.awt.Color(250, 255, 234));
        jLabelCard1.setText("Carta1");
        jLabelCard1.setMaximumSize(new java.awt.Dimension(50, 72));
        jLabelCard1.setMinimumSize(new java.awt.Dimension(50, 72));
        jLabelCard1.setPreferredSize(new java.awt.Dimension(50, 72));

        jLabelCard2.setBackground(new java.awt.Color(250, 255, 234));
        jLabelCard2.setText("Carta2");
        jLabelCard2.setMaximumSize(new java.awt.Dimension(50, 72));
        jLabelCard2.setMinimumSize(new java.awt.Dimension(50, 72));
        jLabelCard2.setPreferredSize(new java.awt.Dimension(50, 72));

        jLabelBestCard1.setBackground(new java.awt.Color(250, 255, 234));
        jLabelBestCard1.setText("jLabel3");
        jLabelBestCard1.setMaximumSize(new java.awt.Dimension(50, 72));
        jLabelBestCard1.setMinimumSize(new java.awt.Dimension(50, 72));
        jLabelBestCard1.setPreferredSize(new java.awt.Dimension(50, 72));

        jLabelBestCard2.setBackground(new java.awt.Color(250, 255, 234));
        jLabelBestCard2.setText("jLabel4");
        jLabelBestCard2.setMaximumSize(new java.awt.Dimension(50, 72));
        jLabelBestCard2.setMinimumSize(new java.awt.Dimension(50, 72));
        jLabelBestCard2.setPreferredSize(new java.awt.Dimension(50, 72));

        jLabelBestCard3.setBackground(new java.awt.Color(250, 255, 234));
        jLabelBestCard3.setText("jLabel5");
        jLabelBestCard3.setMaximumSize(new java.awt.Dimension(50, 72));
        jLabelBestCard3.setMinimumSize(new java.awt.Dimension(50, 72));
        jLabelBestCard3.setPreferredSize(new java.awt.Dimension(50, 72));

        jLabelBestCard4.setBackground(new java.awt.Color(250, 255, 234));
        jLabelBestCard4.setText("jLabel6");
        jLabelBestCard4.setMaximumSize(new java.awt.Dimension(50, 72));
        jLabelBestCard4.setMinimumSize(new java.awt.Dimension(50, 72));
        jLabelBestCard4.setPreferredSize(new java.awt.Dimension(50, 72));

        jLabelBestCard5.setBackground(new java.awt.Color(250, 255, 234));
        jLabelBestCard5.setText("jLabel7");
        jLabelBestCard5.setMaximumSize(new java.awt.Dimension(50, 72));
        jLabelBestCard5.setMinimumSize(new java.awt.Dimension(50, 72));
        jLabelBestCard5.setPreferredSize(new java.awt.Dimension(50, 72));

        jButtonCall.setBackground(new java.awt.Color(250, 255, 234));
        jButtonCall.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jButtonCall.setForeground(new java.awt.Color(255, 53, 53));
        jButtonCall.setText("Check");
        jButtonCall.setBorderPainted(false);
        jButtonCall.setContentAreaFilled(false);
        jButtonCall.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCall.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCall.setMaximumSize(new java.awt.Dimension(80, 24));
        jButtonCall.setMinimumSize(new java.awt.Dimension(80, 24));
        jButtonCall.setPreferredSize(new java.awt.Dimension(80, 24));

        jButtonRaise.setBackground(new java.awt.Color(250, 255, 234));
        jButtonRaise.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jButtonRaise.setForeground(new java.awt.Color(255, 53, 53));
        jButtonRaise.setText("Fold");
        jButtonRaise.setBorderPainted(false);
        jButtonRaise.setContentAreaFilled(false);
        jButtonRaise.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRaise.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRaise.setMaximumSize(new java.awt.Dimension(80, 24));
        jButtonRaise.setMinimumSize(new java.awt.Dimension(80, 24));
        jButtonRaise.setPreferredSize(new java.awt.Dimension(80, 24));
        jButtonRaise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRaiseActionPerformed(evt);
            }
        });

        jButtonCall1.setBackground(new java.awt.Color(250, 255, 234));
        jButtonCall1.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jButtonCall1.setForeground(new java.awt.Color(255, 53, 53));
        jButtonCall1.setText("Bet");
        jButtonCall1.setBorderPainted(false);
        jButtonCall1.setContentAreaFilled(false);
        jButtonCall1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCall1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCall1.setMaximumSize(new java.awt.Dimension(80, 24));
        jButtonCall1.setMinimumSize(new java.awt.Dimension(80, 24));
        jButtonCall1.setPreferredSize(new java.awt.Dimension(80, 24));
        jButtonCall1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCall1ActionPerformed(evt);
            }
        });

        jButtonCall2.setBackground(new java.awt.Color(250, 255, 234));
        jButtonCall2.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jButtonCall2.setForeground(new java.awt.Color(255, 53, 53));
        jButtonCall2.setText("Raise");
        jButtonCall2.setBorderPainted(false);
        jButtonCall2.setContentAreaFilled(false);
        jButtonCall2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCall2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCall2.setMaximumSize(new java.awt.Dimension(80, 24));
        jButtonCall2.setMinimumSize(new java.awt.Dimension(80, 24));
        jButtonCall2.setPreferredSize(new java.awt.Dimension(80, 24));

        jButtonCall3.setBackground(new java.awt.Color(250, 255, 234));
        jButtonCall3.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jButtonCall3.setForeground(new java.awt.Color(255, 53, 53));
        jButtonCall3.setText("Quit");
        jButtonCall3.setBorderPainted(false);
        jButtonCall3.setContentAreaFilled(false);
        jButtonCall3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCall3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCall3.setMaximumSize(new java.awt.Dimension(80, 24));
        jButtonCall3.setMinimumSize(new java.awt.Dimension(80, 24));
        jButtonCall3.setPreferredSize(new java.awt.Dimension(80, 24));
        jButtonCall3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCall3ActionPerformed(evt);
            }
        });

        jButtonCall4.setBackground(new java.awt.Color(250, 255, 234));
        jButtonCall4.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jButtonCall4.setForeground(new java.awt.Color(255, 53, 53));
        jButtonCall4.setText("Pause");
        jButtonCall4.setBorderPainted(false);
        jButtonCall4.setContentAreaFilled(false);
        jButtonCall4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCall4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCall4.setMaximumSize(new java.awt.Dimension(80, 24));
        jButtonCall4.setMinimumSize(new java.awt.Dimension(80, 24));
        jButtonCall4.setPreferredSize(new java.awt.Dimension(80, 24));
        jButtonCall4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCall4ActionPerformed(evt);
            }
        });

        jTextFieldCards.setEditable(false);
        jTextFieldCards.setBackground(new java.awt.Color(250, 255, 234));
        jTextFieldCards.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jTextFieldCards.setForeground(new java.awt.Color(255, 53, 53));
        jTextFieldCards.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCards.setText("cards");
        jTextFieldCards.setBorder(null);
        jTextFieldCards.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jTextFieldCards.setMaximumSize(new java.awt.Dimension(40, 20));
        jTextFieldCards.setMinimumSize(new java.awt.Dimension(40, 20));
        jTextFieldCards.setPreferredSize(new java.awt.Dimension(40, 20));

        jTextFieldCards1.setEditable(false);
        jTextFieldCards1.setBackground(new java.awt.Color(250, 255, 234));
        jTextFieldCards1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jTextFieldCards1.setForeground(new java.awt.Color(255, 53, 53));
        jTextFieldCards1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCards1.setText("Hole");
        jTextFieldCards1.setBorder(null);
        jTextFieldCards1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jTextFieldCards1.setMaximumSize(new java.awt.Dimension(40, 20));
        jTextFieldCards1.setMinimumSize(new java.awt.Dimension(40, 20));
        jTextFieldCards1.setPreferredSize(new java.awt.Dimension(40, 20));

        jTextFieldCards2.setEditable(false);
        jTextFieldCards2.setBackground(new java.awt.Color(250, 255, 234));
        jTextFieldCards2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jTextFieldCards2.setForeground(new java.awt.Color(255, 53, 53));
        jTextFieldCards2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCards2.setText("hand");
        jTextFieldCards2.setBorder(null);
        jTextFieldCards2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jTextFieldCards2.setMaximumSize(new java.awt.Dimension(40, 20));
        jTextFieldCards2.setMinimumSize(new java.awt.Dimension(40, 20));
        jTextFieldCards2.setPreferredSize(new java.awt.Dimension(40, 20));

        jTextFieldCards3.setEditable(false);
        jTextFieldCards3.setBackground(new java.awt.Color(250, 255, 234));
        jTextFieldCards3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jTextFieldCards3.setForeground(new java.awt.Color(255, 53, 53));
        jTextFieldCards3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCards3.setText("Best");
        jTextFieldCards3.setBorder(null);
        jTextFieldCards3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jTextFieldCards3.setMaximumSize(new java.awt.Dimension(40, 20));
        jTextFieldCards3.setMinimumSize(new java.awt.Dimension(40, 20));
        jTextFieldCards3.setPreferredSize(new java.awt.Dimension(40, 20));

        javax.swing.GroupLayout jPanelCardsLayout = new javax.swing.GroupLayout(jPanelCards);
        jPanelCards.setLayout(jPanelCardsLayout);
        jPanelCardsLayout.setHorizontalGroup(
            jPanelCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCardsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldCards, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCards1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jLabelCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabelCard2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanelCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldCards3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCards2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelBestCard1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabelBestCard2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabelBestCard3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabelBestCard4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabelBestCard5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(jPanelCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCardsLayout.createSequentialGroup()
                        .addComponent(jButtonCall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonRaise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCardsLayout.createSequentialGroup()
                        .addGroup(jPanelCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCall4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCall1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCall3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCall2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15))
        );
        jPanelCardsLayout.setVerticalGroup(
            jPanelCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCardsLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanelCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRaise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanelCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCall1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCall2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanelCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCall4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCardsLayout.createSequentialGroup()
                        .addComponent(jButtonCall3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))))
            .addGroup(jPanelCardsLayout.createSequentialGroup()
                .addGroup(jPanelCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCardsLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jTextFieldCards3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextFieldCards2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCardsLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanelCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelBestCard2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelBestCard3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelBestCard4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelBestCard5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelBestCard1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCard2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelCardsLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jTextFieldCards1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextFieldCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jPanelDown.setBackground(new java.awt.Color(60, 2, 2));
        jPanelDown.setPreferredSize(new java.awt.Dimension(600, 50));

        javax.swing.GroupLayout jPanelDownLayout = new javax.swing.GroupLayout(jPanelDown);
        jPanelDown.setLayout(jPanelDownLayout);
        jPanelDownLayout.setHorizontalGroup(
            jPanelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanelDownLayout.setVerticalGroup(
            jPanelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanelLeft.setBackground(new java.awt.Color(60, 2, 2));
        jPanelLeft.setPreferredSize(new java.awt.Dimension(100, 250));

        javax.swing.GroupLayout jPanelLeftLayout = new javax.swing.GroupLayout(jPanelLeft);
        jPanelLeft.setLayout(jPanelLeftLayout);
        jPanelLeftLayout.setHorizontalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanelLeftLayout.setVerticalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jPanelRight.setBackground(new java.awt.Color(60, 2, 2));
        jPanelRight.setPreferredSize(new java.awt.Dimension(100, 250));

        javax.swing.GroupLayout jPanelRightLayout = new javax.swing.GroupLayout(jPanelRight);
        jPanelRight.setLayout(jPanelRightLayout);
        jPanelRightLayout.setHorizontalGroup(
            jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelRightLayout.setVerticalGroup(
            jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanelTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanelRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPanelDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanelCards, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelRight, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addGap(0, 0, 0)
                        .addComponent(jPanelDown, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jPanelCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRaiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRaiseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRaiseActionPerformed

    private void jButtonCall1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCall1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCall1ActionPerformed

    private void jButtonCall3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCall3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCall3ActionPerformed

    private void jButtonCall4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCall4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCall4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCall;
    private javax.swing.JButton jButtonCall1;
    private javax.swing.JButton jButtonCall2;
    private javax.swing.JButton jButtonCall3;
    private javax.swing.JButton jButtonCall4;
    private javax.swing.JButton jButtonRaise;
    private javax.swing.JLabel jLabelBestCard1;
    private javax.swing.JLabel jLabelBestCard2;
    private javax.swing.JLabel jLabelBestCard3;
    private javax.swing.JLabel jLabelBestCard4;
    private javax.swing.JLabel jLabelBestCard5;
    private javax.swing.JLabel jLabelCard1;
    private javax.swing.JLabel jLabelCard2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCards;
    private javax.swing.JPanel jPanelDown;
    private javax.swing.JPanel jPanelLeft;
    private javax.swing.JPanel jPanelRight;
    private javax.swing.JPanel jPanelTable;
    private javax.swing.JPanel jPanelUp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaActions;
    private javax.swing.JTextField jTextFieldCards;
    private javax.swing.JTextField jTextFieldCards1;
    private javax.swing.JTextField jTextFieldCards2;
    private javax.swing.JTextField jTextFieldCards3;
    // End of variables declaration//GEN-END:variables
}
