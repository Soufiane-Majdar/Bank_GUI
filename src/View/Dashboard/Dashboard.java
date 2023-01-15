package View.Dashboard;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;
public class Dashboard extends JFrame {

    IdentityPanel identitypanel;
    SideMenuPanel menupanel;
    CenterPanel centerpanel;



    private void setMenuWhite()
    {
        menupanel.getLabels().forEach((name,lbl)->{
            lbl.setBackground(Color.WHITE);
        });
    }
    private void Menu_Click(){
        menupanel.getLabels().forEach((name,lbl)->{
            lbl.addMouseListener(new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {

                    setMenuWhite();
                    lbl.setBackground(new Color(247, 249, 252));
                    identitypanel.setLbl_Title(name);
                }
            });
        });
    }

    private void iniPanels(){
        identitypanel= new IdentityPanel("Ajouter");

        List<String> labelsNames= List.of("Ajouter","Modifier","Suprimer","Chercher","Trier");
        List<ImageIcon> iamges = List.of(
                (new ImageIcon("img/add-new-100.png")),
                (new ImageIcon("img/updates-96.png")),
                (new ImageIcon("img/trash-90.png")),
                (new ImageIcon("img/search-64.png")),
        (new ImageIcon("img/filter-50.png"))
        );
        menupanel= new SideMenuPanel(labelsNames,iamges);

        centerpanel = new CenterPanel();
    }


    public Dashboard(String title){
        iniPanels();


        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(800,500);
        setLocationRelativeTo(null);
        setVisible(true);
        //setContentPane( new ShadowPane());
        add(identitypanel);
        add(centerpanel);
        add(menupanel);

        Menu_Click();
    }


    public static void main(String[] args) {
        new Dashboard("D A S H B O A R D");
    }
}
