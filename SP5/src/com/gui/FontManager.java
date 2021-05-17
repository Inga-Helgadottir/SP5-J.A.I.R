package com.gui;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FontManager {
   final Font anton40 = addNewFont("Anton\\Anton-Regular.ttf", 50);

   public Font addNewFont(String fontPath, int fontSize){
      Font font = null;
      try{
         font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("..\\..\\font\\" + fontPath).openStream());
         GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
         ge.registerFont(font);
         font = font.deriveFont(Font.PLAIN, fontSize);
      }catch(ExceptionInInitializerError | IOException | FontFormatException e){
         System.out.println(e);
      }

      return font;
   }

}
