package com.gui;

import com.company.DBConnector;
import com.company.Film;
import com.company.Main;
import com.company.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;


public class LikedCard
{

    private static JButton addAButton(String text)
    {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }

    public static JPanel createLikedCard()
    {
        JPanel likedCard = new JPanel();
        likedCard.setBackground(ColorManager.purple);

        if (Main.currentUser != null)
        {
            User user = new User(Main.currentUser.getId(), Main.currentUser.getEmail(), Main.currentUser.getName());
            DBConnector.getUserLikedList(user);
            ArrayList<Film> userArraylist = user.getLikedFilms();
            if (userArraylist.size() > 0)
            {
                for (Film f : userArraylist)
                {
                    JLabel img = new JLabel(new ImageIcon(f.getImgPath()));
                    likedCard.add(img);
                    img.addMouseListener(new MouseListener()
                    {
                        @Override
                        public void mouseClicked(MouseEvent e)
                        {
                            GUI.mainContainer.add(InfoCard.createInfoCard(f), "INFO_CARD");
                            GUI.insideAppContentLayout.show(GUI.mainContainer, "INFO_CARD");
                        }

                        @Override
                        public void mousePressed(MouseEvent e)
                        {
                        }

                        @Override
                        public void mouseReleased(MouseEvent e)
                        {
                        }

                        @Override
                        public void mouseEntered(MouseEvent e)
                        {
                            img.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        }

                        @Override
                        public void mouseExited(MouseEvent e)
                        {
                            img.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                        }
                    });
                }
            }
        }
        likedCard.setVisible(true);
        return likedCard;
    }


    public static void addComponentsToPane(Container pane) throws IOException
    {
        JPanel panel = new JPanel();
        pane.add(panel);


        panel.setPreferredSize(new Dimension(600, 400));
        panel.setMaximumSize(panel.getPreferredSize());
        panel.setMinimumSize(panel.getPreferredSize());


        panel.setPreferredSize(new Dimension(600, 400));
        panel.setMaximumSize(panel.getPreferredSize());
        panel.setMinimumSize(panel.getPreferredSize());
    }
}

