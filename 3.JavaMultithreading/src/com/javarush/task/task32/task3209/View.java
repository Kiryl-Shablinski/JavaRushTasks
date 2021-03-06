package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();

    public UndoListener getUndoListener() {
        return undoListener;
    }

    private UndoListener undoListener = new UndoListener(undoManager);

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception exception) {
            ExceptionHandler.log(exception);
        }
    }


    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void init() {
        initGui();
        FrameListener listener = new FrameListener(this);
        addWindowListener(listener);
        setVisible(true);

    }

    public void selectedTabChanged() {
        int indexPane = tabbedPane.getSelectedIndex();

        if (indexPane == 0) {
            controller.setPlainText(plainTextPane.getText());
        }
        if (indexPane == 1) {
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }

    public void exit() {
        controller.exit();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

         switch (command) {
             case "Новый": controller.createNewDocument();
             break;

             case "Открыть" : controller.openDocument();
             break;

             case "Сохранить" : controller.saveDocument();
             break;

             case "Сохранить как..." : controller.saveDocumentAs();
             break;

             case "Выход" : controller.exit();
             break;

             case  "О программе" : showAbout();
             break;
         }
    }

    public void initMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, jMenuBar);
        MenuHelper.initEditMenu(this, jMenuBar);
        MenuHelper.initStyleMenu(this, jMenuBar);
        MenuHelper.initAlignMenu(this, jMenuBar);
        MenuHelper.initColorMenu(this, jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);
        getContentPane().add(jMenuBar, BorderLayout.NORTH);
    }

    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", jScrollPane);
        JScrollPane jScrollPane1 = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", jScrollPane1);
        tabbedPane.setPreferredSize(new Dimension(500, 500));
        TabbedPaneChangeListener tabbedListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedListener);
        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);


    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack();

    }

    public void undo() {
        try {
            undoManager.undo();

        } catch (Exception o) {
            ExceptionHandler.log(o);
        }
    }

    public void redo() {
        try {
            undoManager.redo();
        } catch (Exception o) {
            ExceptionHandler.log(o);
        }
    }

    public boolean canUndo() {
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected() {

        return tabbedPane.getSelectedIndex() == 0;
    }

    public void selectHtmlTab(){
       tabbedPane.setSelectedIndex(0);
        this.resetUndo();
    }

    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout(){
        JOptionPane.showMessageDialog(tabbedPane.getSelectedComponent(),
                "Версия 1.0","О программе",JOptionPane.INFORMATION_MESSAGE);
    }
}

