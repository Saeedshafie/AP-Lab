package gui;

import model.Note;
import utils.FileUtils;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;


public class SerializedMainPanel extends JPanel {

    private JTabbedPane tabbedPane;
    private JList<Note> directoryList;

    public SerializedMainPanel() {

//        FileUtils.createSerializedFile();

        setLayout(new BorderLayout());

        initDirectoryList(); // add JList to main Panel

        initTabbedPane(); // add TabbedPane to main panel

        addNewTab(); // open new empty tab when user open the application
    }

    private void initTabbedPane() {
        tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);
    }

    private void initDirectoryList() {
        ArrayList<Note> notes = FileUtils.getNoteObjects();
        if(notes == null || notes.size() == 0){
            FileUtils.createSerializedFile();
            notes = FileUtils.getNoteObjects();
        }
        Note[] arrayNotes = new Note[notes.size()];
        int i = 0;
        for(Note note: notes){
            arrayNotes[i] = note;
            i++;
        }
        directoryList = new JList<>(arrayNotes);

        directoryList.setBackground(new Color(211, 211, 211));
        directoryList.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        directoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        directoryList.setVisibleRowCount(-1);
        directoryList.setMinimumSize(new Dimension(130, 100));
        directoryList.setMaximumSize(new Dimension(130, 100));
        directoryList.setFixedCellWidth(130);
        directoryList.setCellRenderer(new MyCellRenderer());
        directoryList.addMouseListener(new MyMouseAdapter());

        add(new JScrollPane(directoryList), BorderLayout.WEST);
    }


    public void addNewTab() {
        JTextArea textPanel = createTextPanel();
        textPanel.setText("Write Something here...");
        tabbedPane.addTab("Tab " + (tabbedPane.getTabCount() + 1), textPanel);
    }

    public void openExistingNote(Note note) {
        JTextArea existPanel = createTextPanel();
        existPanel.setText(note.getContent());

        int tabIndex = tabbedPane.getTabCount() + 1;
        tabbedPane.addTab("Tab " + tabIndex, existPanel);
        tabbedPane.setSelectedIndex(tabIndex - 1);
    }

    public void saveNote() {
        JTextArea textPanel = (JTextArea) tabbedPane.getSelectedComponent();
        String note = textPanel.getText();
        if (!note.isEmpty()) {
            FileUtils.writeObject(note);
        }
        updateListGUI();
    }

    private JTextArea createTextPanel() {
        JTextArea textPanel = new JTextArea();
        textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return textPanel;
    }

    private void updateListGUI() {
        ArrayList<Note> notes = FileUtils.getNoteObjects();
        Note[] arrayNotes = new Note[notes.size()];
        int i = 0;
        for(Note note: notes){
            arrayNotes[i] = note;
            i++;
        }
        directoryList.setListData(arrayNotes);
    }


    private class MyMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent eve) {
            // Double-click detected
            if (eve.getClickCount() == 2) {
                int index = directoryList.locationToIndex(eve.getPoint());
                System.out.println("Item " + index + " is clicked...");
                //TODO: Phase1: Click on file is handled... Just load content into JTextArea
                ArrayList<Note> notes = FileUtils.getNoteObjects();
//                String content = FileUtils.inputStreamRead(curr[index]);
                Note note = notes.get(index);
                openExistingNote(note);
            }
        }
    }


    private class MyCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object object, int index, boolean isSelected, boolean cellHasFocus) {
            if (object instanceof Note) {
                Note file = (Note) object;
                setText(file.getTitle() + " - " + file.getDate());
//                setIcon(FileSystemView.getFileSystemView().getSystemIcon(file));
                if (isSelected) {
                    setBackground(list.getSelectionBackground());
                    setForeground(list.getSelectionForeground());
                } else {
                    setBackground(list.getBackground());
                    setForeground(list.getForeground());
                }
                setEnabled(list.isEnabled());
            }
            return this;
        }
    }

    public void saveAll(){
        File[] files = FileUtils.getFilesInDirectory();
        for(int i = 0;i < files.length;i++){
            String content = FileUtils.fileReader(files[i]);
            FileUtils.fileWriter(content);
        }
        System.out.println("All files saved...");
    }
}
