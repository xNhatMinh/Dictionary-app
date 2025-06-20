package GUI.ControlPanel;

import Dict.DictionaryManagement;
import GUI.ControlPanel.Edit.EditPanel;
import GUI.ControlPanel.Edit.Glass;
import GUI.ControlPanel.Learn.TopicChoosePanel;
import GUI.roundComponent.RoundedTextField;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import manageData.Datatype.Word;
import manageData.Datatype.WordExplain;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class EditGUI extends javax.swing.JDialog {
    private final List<EditPanel> list = new ArrayList<>();
    private DictionaryManagement Dictmng;
    private Word wordNeedtoDelete = null;

    public boolean isNewTopic() {
        return chooseNewTopic.isSelected();
    }

    public boolean isNoTopic() {
        return chooseNoTopic.isSelected();
    }
    
    public boolean isChooseATopic() {
        return chooseTopic.isSelected();
    }
    
    private JPanel noTopic = new JPanel();
    private RoundedTextField newTopic = new RoundedTextField();
    private TopicChoosePanel topicChoose = new TopicChoosePanel();
    
    private ItemListener itemListener;
    
    private final JFrame frame;
    
    public EditGUI(JFrame frame, String title, DictionaryManagement dict) {
        super(frame, true);
        this.frame = frame;
        this.Dictmng = dict;
        initComponents();
        
        Tiltle.setText(title);
        
        addNewTypeTab(1);
        Delete.setVisible(false);
        
        CardLayout cardLayout = new CardLayout(0, 0);
        panel.setLayout(cardLayout);
        
        
        noTopic.setBackground(new Color(215,246,248));
        panel.setOpaque(false);
        
        newTopic.setFont(new java.awt.Font("SansSerif", 0, 16));
        newTopic.setHintText("New Topic ...");
        
        topicChoose.setText("Choose...");
        topicChoose.setTopics(dict.getVocabs().getTopics());
        
        panel.add("noTopic", noTopic);
        panel.add("newTopic", newTopic);
        panel.add("chooseTopic", topicChoose);

        itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Nếu một JCheckBox được chọn, hủy chọn JCheckBox còn lại
                    if (e.getItem() == chooseNoTopic) {
                        chooseNewTopic.setSelected(false);
                        chooseTopic.setSelected(false);
                        cardLayout.show(panel, "noTopic");
                    } else if (e.getItem() == chooseNewTopic) {
                        chooseNoTopic.setSelected(false);
                        chooseTopic.setSelected(false);
                        cardLayout.show(panel, "newTopic");
                    } else if (e.getItem() == chooseTopic) {
                        chooseNoTopic.setSelected(false);
                        chooseNewTopic.setSelected(false);
                        topicChoose.setText("Choose...");
                        cardLayout.show(panel, "chooseTopic");
                    }
                }
            }
        };
        
        chooseNoTopic.addItemListener(itemListener);
        chooseNewTopic.addItemListener(itemListener);
        chooseTopic.addItemListener(itemListener);
        
        chooseTopic.setSelected(true);
        cardLayout.show(panel, "chooseTopic");
        
        setLocationRelativeTo(frame);
        init();
    }
    
    private Animator animator;
    private Glass glass;
    private boolean show;
    private void init() {
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                startAnimator(false);
            }
        });
        
        animator = new Animator(350, new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                float f = show ? fraction : 1f - fraction;
                glass.setAlpha(f - f * 0.3f);
                setOpacity(f);
            }

            @Override
            public void end() {
                if (show == false) {
                    dispose();
                    glass.setVisible(false);
                }
            }
        });
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        setOpacity(0f);
        glass = new Glass();
    }

    private void startAnimator(boolean show) {
        if (animator.isRunning()) {
            float f = animator.getTimingFraction();
            animator.stop();
            animator.setStartFraction(1f - f);
        } else {
            animator.setStartFraction(0f);
        }
        this.show = show;
        animator.start();
    }
    public void showDialog() {
        frame.setGlassPane(glass);
        glass.setVisible(true);
        setLocationRelativeTo(frame);
        startAnimator(true);
        setVisible(true);
    }
    public void addNewTypeTab(int num) {
            EditPanel newPanel = new EditPanel(num);
            list.add(newPanel);
            materialTabbed1.addTab("Type", newPanel);
            newPanel.eventType(new KeyAdapter(){
                @Override
                public void keyReleased(KeyEvent e) {
                    if (Character.isLetter(e.getKeyChar())) {
                        materialTabbed1.setTitleAt(materialTabbed1.getSelectedIndex(), newPanel.getType());
                    }
                }

            });
    }

    public Word getWord() {
        Word result = new Word();
        
        if (English.getText().isEmpty() || English.getText().isBlank()) {
            return null;
        }
        
        if (pronounce.getText().isEmpty() || pronounce.getText().isBlank()) {
            return null;
        }
        
        result.setWordTarget(English.getText());
        result.setPronounce(pronounce.getText());
        
        for (EditPanel e : list) {
            List<WordExplain> ex = e.getWordExplain();
            if (ex == null) return null;
            for (WordExplain w : ex) {
                result.addExplain(w);
            }
        }

        return result;
    }
    
    public void changeToEditGUI(Word word) {
        wordNeedtoDelete = word;
        Delete.setVisible(true);
        list.clear();        
        materialTabbed1.removeAll();
        materialTabbed1.revalidate();
        English.setText(word.getWord_target());
        pronounce.setText(word.getPronounce());
        List<String> listType = new ArrayList<>();
        
        for (WordExplain w : word.getWord_explain()) {
            if(listType.contains(w.getType())) {
                list.get(listType.indexOf(w.getType())).addexplain(w.getDefinition(), w.getMeaning());
            } else {
                listType.add(w.getType());
                EditPanel e = new EditPanel(0);
                e.addexplain(w.getDefinition(), w.getMeaning());
                e.setType(w.getType());
                list.add(e);
                materialTabbed1.addTab(w.getType(), e);
            }
        }
        String topicOfWordNeedtoEdit = Dictmng.getTopicOfWord(word.getWord_target());
        if (topicOfWordNeedtoEdit == null) {
            chooseNoTopic.setSelected(true);
        } else {
            chooseTopic.setSelected(true);
            topicChoose.setText(topicOfWordNeedtoEdit);
        }
        materialTabbed1.repaint();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Tiltle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cancel = new GUI.roundComponent.Button();
        Ok = new GUI.roundComponent.Button();
        English = new GUI.roundComponent.RoundedTextField();
        chooseNewTopic = new javax.swing.JCheckBox();
        chooseNoTopic = new javax.swing.JCheckBox();
        panel = new javax.swing.JPanel();
        materialTabbed1 = new GUI.roundComponent.MaterialTabbed();
        AddType = new GUI.roundComponent.Button();
        Delete = new GUI.roundComponent.Button();
        DelType = new GUI.roundComponent.Button();
        jLabel1 = new javax.swing.JLabel();
        pronounce = new GUI.roundComponent.RoundedTextField();
        chooseTopic = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(215, 246, 248));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(215, 246, 248));

        Tiltle.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        Tiltle.setText(" Add Word");

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setOpaque(true);

        cancel.setText("Cancel");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cancelMouseReleased(evt);
            }
        });

        Ok.setText("Ok");
        Ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                OkMouseReleased(evt);
            }
        });

        English.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        English.setHintText("English ...");

        chooseNewTopic.setText("New Topic");

        chooseNoTopic.setText("No topic");

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        AddType.setText("Add Type");
        AddType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                AddTypeMouseReleased(evt);
            }
        });

        Delete.setText("Delete");
        Delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DeleteMouseReleased(evt);
            }
        });

        DelType.setText("Delete Type");
        DelType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DelTypeMouseReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setOpaque(true);

        pronounce.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        pronounce.setHintText("Pronounce ...");

        chooseTopic.setText("choose Topic");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Tiltle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(chooseNoTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chooseNewTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chooseTopic)
                                        .addGap(11, 11, 11)
                                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(DelType, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(materialTabbed1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(English, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(pronounce, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)
                                        .addComponent(AddType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(16, 16, 16))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tiltle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooseNewTopic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chooseNoTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chooseTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(English, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pronounce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(DelType, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseReleased
        if (SwingUtilities.isLeftMouseButton(evt)) {
            startAnimator(false);
        }
    }//GEN-LAST:event_cancelMouseReleased

    private void AddTypeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddTypeMouseReleased
        if (SwingUtilities.isLeftMouseButton(evt)) {
            addNewTypeTab(1);
        }
    }//GEN-LAST:event_AddTypeMouseReleased

    private void DelTypeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelTypeMouseReleased
        if (SwingUtilities.isLeftMouseButton(evt)) {
            if (list.size() > 1) {
                list.remove(materialTabbed1.getSelectedIndex());
                materialTabbed1.removeTabAt(materialTabbed1.getSelectedIndex());
            } else {
                JOptionPane.showMessageDialog(this, "A word must have one or more explanations!");
            }
        }
    }//GEN-LAST:event_DelTypeMouseReleased

    private void DeleteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMouseReleased
        if (SwingUtilities.isLeftMouseButton(evt)) {
            if (Dictmng.deleteWord(wordNeedtoDelete.getWord_target())) {
                Dictmng.deleteInDB(wordNeedtoDelete.getWord_target());
                JOptionPane.showMessageDialog(this, "Successful!");
                startAnimator(false);
                return;
            }
            JOptionPane.showMessageDialog(this, "Not found Word to delete\nOr this word was deleted!");
        }
    }//GEN-LAST:event_DeleteMouseReleased

    private void OkMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OkMouseReleased
        if (SwingUtilities.isLeftMouseButton(evt)) {
            Word tmp = getWord();
            if (tmp == null || (!isChooseATopic() && !isNoTopic() && !isNewTopic())) {
                JOptionPane.showMessageDialog(this, "Invalid English Word!\nYou must fill all blanks");
            } else if (!DictionaryManagement.validWord(tmp.getWord_target())) {
                JOptionPane.showMessageDialog(this, "Invalid English Word!\nAn English word can only have alphabet character!!!");
            } else{
                if (wordNeedtoDelete != null) {        
                    Dictmng.deleteWord(wordNeedtoDelete.getWord_target());
                    Dictmng.deleteInDB(wordNeedtoDelete.getWord_target());
                }
                else if (Dictmng.deleteWord(tmp.getWord_target())) {
                    Dictmng.deleteInDB(tmp.getWord_target());
                }
                Dictmng.insertWord(tmp);
                // add to db
                Dictmng.insertWordIntoDB(tmp);
                if (chooseTopic.isSelected()) {
                    if (topicChoose.getText().equals("Choose...")) {
                        JOptionPane.showMessageDialog(this, "Choose a topic!");
                        return;
                    }
                    Dictmng.insertWordTopic(topicChoose.getText(), tmp);  
                    Dictmng.insertWordTopicIntoDB(topicChoose.getText(), tmp);
                } else if (chooseNewTopic.isSelected()) {
                    Dictmng.insertWordTopic(newTopic.getText(), tmp);
                    Dictmng.insertWordTopicIntoDB(newTopic.getText(), tmp);
                }
                JOptionPane.showMessageDialog(this, "Successful!");
                startAnimator(false);
            }
        }
    }//GEN-LAST:event_OkMouseReleased
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.roundComponent.Button AddType;
    private GUI.roundComponent.Button DelType;
    private GUI.roundComponent.Button Delete;
    private GUI.roundComponent.RoundedTextField English;
    private GUI.roundComponent.Button Ok;
    private javax.swing.JLabel Tiltle;
    private GUI.roundComponent.Button cancel;
    private javax.swing.JCheckBox chooseNewTopic;
    private javax.swing.JCheckBox chooseNoTopic;
    private javax.swing.JCheckBox chooseTopic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private GUI.roundComponent.MaterialTabbed materialTabbed1;
    private javax.swing.JPanel panel;
    private GUI.roundComponent.RoundedTextField pronounce;
    // End of variables declaration//GEN-END:variables
}
