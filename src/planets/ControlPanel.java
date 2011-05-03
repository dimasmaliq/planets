package planets;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * Holds all of the control elements
 *
 * @author carlos
 * @author evant
 * @author trev
 * @version 2011.04.03
 */
public class ControlPanel extends JMenuBar
{

    private JMenuItem newItem;
    private JMenuItem saveItem;
    private JMenuItem loadItem;
    private JMenuItem quitItem;

    //private JMenuItem preferencesItem;

    private JMenuItem contentsItem;
    private JMenuItem aboutItem;

    /**
     * A simple menu bar
     */
    public ControlPanel()
    {
        /*
         * Menu Items: File Edit Help
         */

        // -------------------------------
        newItem = new JMenuItem("New", KeyEvent.VK_N);
        newItem.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
        newItem.addActionListener(new NewItemListener());

        saveItem = new JMenuItem("Save", KeyEvent.VK_S);
        saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
        saveItem.addActionListener(new SaveItemListener());

        loadItem = new JMenuItem("Load", KeyEvent.VK_L);
        loadItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        loadItem.addActionListener(new LoadItemListener());

        quitItem = new JMenuItem("Quit", KeyEvent.VK_Q);
        quitItem.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));
        quitItem.addActionListener(new QuitItemListener());

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        fileMenu.addSeparator();
        fileMenu.add(quitItem);

        // -------------------------------
        /*
         * preferencesItem = new JMenuItem("Preferences", KeyEvent.VK_P);
         * preferencesItem.setAccelerator(KeyStroke.getKeyStroke("ctrl P"));
         * preferencesItem.addActionListener(new PreferencesItemListener());
         *
         * JMenu editMenu = new JMenu("Edit");
         * editMenu.setMnemonic(KeyEvent.VK_E); editMenu.add(preferencesItem);
         */

        // -------------------------------
        contentsItem = new JMenuItem("Contents", KeyEvent.VK_C);
        contentsItem.setAccelerator(KeyStroke.getKeyStroke("F1"));
        contentsItem.addActionListener(new ContentsItemListener());

        aboutItem = new JMenuItem("About", KeyEvent.VK_A);
        aboutItem.setAccelerator(KeyStroke.getKeyStroke("F2"));
        aboutItem.addActionListener(new AboutItemListener());

        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        helpMenu.add(contentsItem);
        helpMenu.add(aboutItem);

        // -------------------------------
        add(fileMenu);
        // add(editMenu);
        add(helpMenu);
    }

    // -----------------------------
    // FILE ACTION LISTNERS
    // -----------------------------

    /**
     * Action listener for whenever the user hits the new menu item.
     */
    private class NewItemListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            newItem.setEnabled(false);
        }

    }

    /**
     * Action listener for whenever the user hits the save menu item.
     */
    private class SaveItemListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Auto-generated method stub

        }

    }

    /**
     * Action listener for whenever the user hits the load menu item.
     */
    private class LoadItemListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Auto-generated method stub

        }

    }

    /**
     * Action Listener for when ever the user hits the quit menu item.
     */
    private class QuitItemListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }

    }

    // -----------------------------
    // EDIT ACTION LISTNERS
    // -----------------------------

    /**
     * Action Listener for when ever the user hits the preferences menu item.
     */
    /*
     * private class PreferencesItemListener implements ActionListener {
     *
     * @Override public void actionPerformed(ActionEvent e) { new
     * PreferencesFrame(); }
     *
     * }
     */

    // -----------------------------
    // HELP ACTION LISTNERS
    // -----------------------------

    /**
     * Action listener for whenever the user hits the contents menu item.
     */
    private class ContentsItemListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Auto-generated method stub

        }

    }

    /**
     * Action listener for whenever the user hits the about menu item.
     */
    private class AboutItemListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(ControlPanel.this.getParent(),
                    "<html><h2>Made By:" + "<ul><li>Trevor Senior"
                            + "<li>Evan Tatarka"
                            + "<li>Carlos Vializ</ul>", "About",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

}
