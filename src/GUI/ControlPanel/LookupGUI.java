package GUI.ControlPanel;

import GUI.ControlPanel.Search.EventClick;
import GUI.ControlPanel.Search.searchSuggestPanel;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPopupMenu;
import Dict.DictionaryManagement;
import Translate.TranslateController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javazoom.jl.decoder.JavaLayerException;
import manageData.Datatype.Word;
import manageData.Datatype.WordExplain;
import GUI.ControlPanel.Search.ResultBoard;
import javax.swing.JFrame;


public class LookupGUI extends javax.swing.JPanel {
    
    private DictionaryManagement Dictmng;
    
    private TranslateController controller;
    
    public void setDictionay(DictionaryManagement Dictmng) {
        this.Dictmng = Dictmng;
    }
    
    private Word result ;

    private Word pre_result ;

    private JPopupMenu menu;
    private searchSuggestPanel suggestPanel;
    
    public LookupGUI() {
        initComponents();
        
        controller = new TranslateController();
        
        menu = new JPopupMenu();
        suggestPanel = new searchSuggestPanel();
        suggestPanel.setPathIcon("src/data/img/search_1.png");
        
        menu.setBorder(BorderFactory.createLineBorder(new Color(245, 242, 242)));
        menu.add(suggestPanel);
        menu.setFocusable(false);
        suggestPanel.addEventClick(new EventClick() {
            @Override
            public void itemClick(String data) {
                textBar.setText(data);
                suggestPanel.setSuggestData(Dictmng.findWordsWithPrefix(data));
                menu.show(textBar, 0, textBar.getHeight());
                menu.setPopupSize(textBar.getWidth(), (suggestPanel.getItemSize() * 35) + 2);
                menu.setVisible(false);
            }
        });
        
        jPanel1.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iconSearch = new GUI.roundComponent.circleComponent();
        jPanel1 = new javax.swing.JPanel();
        WordTarget = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        line = new javax.swing.JLabel();
        editButton = new GUI.roundComponent.Button();
        readButton = new GUI.roundComponent.Button();
        materialTabbed1 = new GUI.roundComponent.MaterialTabbed();
        Pronounce = new javax.swing.JLabel();
        textBar = new GUI.ControlPanel.Search.TextFieldAnimation();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        iconSearch.setBackground(new java.awt.Color(254, 236, 166));
        iconSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/img/lookup.png"))); // NOI18N
        iconSearch.setOpaque(true);

        javax.swing.GroupLayout iconSearchLayout = new javax.swing.GroupLayout(iconSearch);
        iconSearch.setLayout(iconSearchLayout);
        iconSearchLayout.setHorizontalGroup(
            iconSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        iconSearchLayout.setVerticalGroup(
            iconSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        WordTarget.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        WordTarget.setForeground(new java.awt.Color(45, 45, 45));
        WordTarget.setText("Word");

        jLabel1.setBackground(new java.awt.Color(220, 220, 220));
        jLabel1.setOpaque(true);

        line.setBackground(new java.awt.Color(153, 153, 153));
        line.setOpaque(true);

        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/img/edit.png"))); // NOI18N
        editButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                editButtonMouseReleased(evt);
            }
        });

        readButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/img/audio.png"))); // NOI18N
        readButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                readButtonMousePressed(evt);
            }
        });

        Pronounce.setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
        Pronounce.setText("/ pronounce /");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(line, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(WordTarget, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(readButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pronounce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(WordTarget)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(readButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(4, 4, 4)
                .addComponent(Pronounce)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(line, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        textBar.setBackground(new java.awt.Color(245, 242, 242));
        textBar.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        textBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textBarMousePressed(evt);
            }
        });
        textBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textBarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textBarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(iconSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textBar, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(iconSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(textBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBarKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_UP && evt.getKeyCode() != KeyEvent.VK_DOWN && 
                evt.getKeyCode() != KeyEvent.VK_ENTER && evt.getKeyCode() != KeyEvent.VK_ESCAPE) {
            String text = textBar.getText().trim();
            if (!DictionaryManagement.validWord(text)) {
                suggestPanel.setSuggestData(this.Dictmng.findWordsWithPrefix(""));
                if (suggestPanel.getItemSize() > 0) {
                    //  * 2 top and bot border
                    menu.show(textBar, 0, textBar.getHeight());
                    menu.setPopupSize(textBar.getWidth(), (suggestPanel.getItemSize() * 35) + 2);
                }
                menu.setVisible(false);
            }
            else {
                suggestPanel.setSuggestData(this.Dictmng.findWordsWithPrefix(text));//"list string da tim"
                if (suggestPanel.getItemSize() > 0) {
                    //  * 2 top and bot border
                    menu.show(textBar, 0, textBar.getHeight());
                    menu.setPopupSize(textBar.getWidth(), (suggestPanel.getItemSize() * 35) + 2);
                } else {
                    menu.setVisible(false);
                }
            }
        }
    }//GEN-LAST:event_textBarKeyReleased

    private void textBarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            menu.setVisible(false);
            String key = suggestPanel.getSelectedText();
            if (!key.isEmpty()) {
                textBar.setText(key);
            }
            if (!textBar.getShow()) {
                processing();    
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            menu.setVisible(false);
            if (textBar.getShow()) {
                textBar.close_searching();    
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            if (menu.isVisible()) {
                suggestPanel.keyUp();
                textBar.setText(suggestPanel.getSelectedText());
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN){
            if (menu.isVisible()) {
                suggestPanel.keyDown();
                textBar.setText(suggestPanel.getSelectedText());
            }
        }
    }//GEN-LAST:event_textBarKeyPressed

    private void textBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textBarMousePressed
        if (SwingUtilities.isLeftMouseButton(evt)) {
            if (textBar.checkMouseOver(evt.getPoint())) {
                if (!textBar.getShow()) {
                    processing();
                } else {
                    textBar.close_searching();
                }
            } else {
                if (suggestPanel.getItemSize() > 0) {
                    menu.show(textBar, 0, textBar.getHeight());
                }
            }
        }
    }//GEN-LAST:event_textBarMousePressed

    public void eventEdit(MouseAdapter event) {
        editButton.addMouseListener(event);
    }

    private Thread thread;
    
    private void readButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_readButtonMousePressed
        if (SwingUtilities.isLeftMouseButton(evt)) {
                if (thread != null) {
                    thread.interrupt();
                }
                thread = new Thread(() -> {
                    try {
                        controller.readMessage(result.getWord_target(), "en");
                    } catch (IOException | JavaLayerException ex) {
                        JOptionPane.showMessageDialog(this, "Can't read Text");
                    }
                });
                
                thread.setDaemon(false);
                
                thread.start();
        }
    }//GEN-LAST:event_readButtonMousePressed

    private JFrame frame;
    
    public void setframe(JFrame frame) {
        this.frame = frame;
    }
    private void editButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseReleased
        if (SwingUtilities.isLeftMouseButton(evt)) {
            EditGUI edit = new EditGUI(frame, " Edit Word", Dictmng);
            edit.changeToEditGUI(result);
            edit.showDialog();
        }
    }//GEN-LAST:event_editButtonMouseReleased

    private void processing() {
        textBar.execute_searching();
        Word tmp = Dictmng.findWord(textBar.getText().trim());
        if (tmp != null) {
            if (result == null) {
                result = new Word();
            }
            result.copy(tmp);
        } else {
            result = null;
        }
        Timer timer = new Timer(600, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Đoạn mã trong này sẽ được thực thi sau khi đợi (delay) kết thúc
                if (textBar.getShow()) {
                    textBar.close_searching();
                    if (result != null) {
                        materialTabbed1.removeAll();
                        materialTabbed1.revalidate();
                        WordTarget.setText(result.getWord_target());
                        Pronounce.setText("/ " + result.getPronounce() + " /");
                        List<String> listType = new ArrayList<>();
                        List<ResultBoard> listBoard = new ArrayList<>();
        
                        for (WordExplain w : result.getWord_explain()) {                        
                            if(listType.contains(w.getType())) {
                                listBoard.get(listType.indexOf(w.getType())).addData(w.getDefinition(), w.getMeaning());
                            } else {
                                listType.add(w.getType());
                                ResultBoard r = new ResultBoard();
                                r.addData(w.getDefinition(), w.getMeaning());
                                listBoard.add(r);
                                materialTabbed1.addTab(w.getType(), r);
                            }
                        }
                        materialTabbed1.repaint();
                        if (!jPanel1.isVisible()) {
                            jPanel1.setVisible(true);
                        }
                        pre_result = result;
                    } else {
                        jPanel1.setVisible(false);
                        result = pre_result;
                        JOptionPane.showMessageDialog(jPanel1, "Not found");
                    }
                }
            }
        });

        // Kích hoạt Timer để bắt đầu đợi
        timer.setRepeats(false);  // Đặt timer chỉ chạy một lần
        timer.start();
    }
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Pronounce;
    private javax.swing.JLabel WordTarget;
    private GUI.roundComponent.Button editButton;
    private GUI.roundComponent.circleComponent iconSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel line;
    private GUI.roundComponent.MaterialTabbed materialTabbed1;
    private GUI.roundComponent.Button readButton;
    private GUI.ControlPanel.Search.TextFieldAnimation textBar;
    // End of variables declaration//GEN-END:variables
}
