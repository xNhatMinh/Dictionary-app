package GUI.ControlPanel;

import Dict.DictionaryManagement;
import Dict.VocabularyList;
import GUI.ControlPanel.Learn.Question;
import GUI.ControlPanel.Search.EventClick;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import manageData.Datatype.Word;
import manageData.Datatype.WordExplain;

public class LearnGUI extends JPanel {
    private VocabularyList vocabs;
    private List<List<Component>> list = new ArrayList<>();
    private List<Word> totalWord;
    
    public LearnGUI(DictionaryManagement Dictmng) {
        initComponents();
        this.vocabs = Dictmng.getVocabs();
        totalWord = Dictmng.getDictionary().getDict();
        topicChoose.setTopics(vocabs.getTopics());

        showButton.setBackground(new Color(153, 204, 255));
        prevButton.setBackground(new Color(153, 204, 255));
        nextButton.setBackground(new Color(153, 204, 255));
        shuffleButton.setBackground(new Color(153, 204, 255));
        
        topicChoose.eventClickSugestPanel(new EventClick() {
            @Override
            public void itemClick(String data) {
                topicChoose.setText(data);
                topicChoose.setMenuVisible(false);
                topicChoose.setShow(false);
                slideroundedPanel.clear();
                slideroundedPanel.addComponent(list.get(topicChoose.getChoose()));
                slideroundedPanel.startShow();

            }
        });
    }
    
    public void startLearn() {
        topicChoose.setText("Topics");
        slideroundedPanel.clear();
        slideroundedPanel.addComponent(new Question("Definition", "/ word type /", "Correct Answer is A", "A", "B", "C", "D"));
        slideroundedPanel.startShow();
    }
    
    public void refresh() {
        topicChoose.setTopics(vocabs.getTopics());
        list.clear();
        List<List<Word>> temp = vocabs.getVocabularies();
        for (int i = 0; i < temp.size(); ++i) {
            List<Component> comps = new ArrayList<>();
            for (Word w : temp.get(i)) {
                List<Word> random4Word = new ArrayList<>(totalWord);
                random4Word.remove(w);
                
                for (int j = 0; j < random4Word.size(); j++) {
                    if (random4Word.get(j).getWord_target().isEmpty()) {
                        random4Word.remove(j);
                    }
                }
                
                Collections.shuffle(random4Word);
                random4Word = random4Word.subList(0, 3);

                WordExplain explain = w.getWord_explain().get(0);
                comps.add(new Question(explain.getDefinition(), explain.getType(), explain.getMeaning(),
                        w.getWord_target(), random4Word.get(0).getWord_target(),
                        random4Word.get(1).getWord_target(), random4Word.get(2).getWord_target()));
            }
            list.add(comps);
        } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        showButton = new GUI.roundComponent.Button();
        prevButton = new GUI.roundComponent.Button();
        nextButton = new GUI.roundComponent.Button();
        slideroundedPanel = new GUI.ControlPanel.Learn.SlideRoundedPanel();
        topicChoose = new GUI.ControlPanel.Learn.TopicChoosePanel();
        shuffleButton = new GUI.roundComponent.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        showButton.setText("Show");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        prevButton.setText("Prev");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout slideroundedPanelLayout = new javax.swing.GroupLayout(slideroundedPanel);
        slideroundedPanel.setLayout(slideroundedPanelLayout);
        slideroundedPanelLayout.setHorizontalGroup(
            slideroundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        slideroundedPanelLayout.setVerticalGroup(
            slideroundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        topicChoose.setBackground(new java.awt.Color(153, 204, 255));

        shuffleButton.setText("Shuffle");
        shuffleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shuffleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(288, Short.MAX_VALUE)
                .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(shuffleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addComponent(slideroundedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topicChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(topicChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(slideroundedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shuffleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        try {
            slideroundedPanel.show(slideroundedPanel.getCurrentShowing() + 1);
            Question curr = (Question)slideroundedPanel.getCurrentComponent();
            curr.restart();
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(slideroundedPanel, "Congratulations!\nIt's all words.");
        }

    }//GEN-LAST:event_nextButtonActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        try {
            slideroundedPanel.show(slideroundedPanel.getCurrentShowing() - 1);
            Question curr = (Question)slideroundedPanel.getCurrentComponent();
            curr.restart();
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(slideroundedPanel, "Sorry, Can't show previous word!\nIt's the first word.");
        }
    }//GEN-LAST:event_prevButtonActionPerformed

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        Question curr = (Question)slideroundedPanel.getCurrentComponent();
        curr.showCorrectAns();
    }//GEN-LAST:event_showButtonActionPerformed

    private void shuffleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shuffleButtonActionPerformed
        int choice = topicChoose.getChoose();
        if (choice >= 0) {
            List<Component> copyList;
            copyList = new ArrayList<>(list.get(choice));
            Collections.shuffle(copyList);
            slideroundedPanel.clear();
            slideroundedPanel.addComponent(copyList);
            slideroundedPanel.startShow();
            Question curr = (Question)slideroundedPanel.getCurrentComponent();
            curr.restart();
        }
    }//GEN-LAST:event_shuffleButtonActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.roundComponent.Button nextButton;
    private GUI.roundComponent.Button prevButton;
    private GUI.roundComponent.Button showButton;
    private GUI.roundComponent.Button shuffleButton;
    private GUI.ControlPanel.Learn.SlideRoundedPanel slideroundedPanel;
    private GUI.ControlPanel.Learn.TopicChoosePanel topicChoose;
    // End of variables declaration//GEN-END:variables
}
