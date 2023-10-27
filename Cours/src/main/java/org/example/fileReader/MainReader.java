package org.example.fileReader;

import java.io.File;
import java.io.FileNotFoundException;
import org.example.fileReader.model.DotTxt;

public class MainReader {
  public static void main(String[] args) {
    File f = new File("C:\\Users\\Brookii-PC\\Documents\\Scolaire\\Sorbonne\\Java\\Cours\\src\\main\\java\\org\\example\\fileReader\\thisisafile.txt");
    DotTxt txt;
    try {
      txt = new DotTxt(f);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    txt.readFile();
    System.out.println("------------------------------------------------------");
    System.out.println(txt.readNormally());
    System.out.println("------------------------------------------------------");
    System.out.println(txt.readReversely());
    System.out.println("------------------------------------------------------");
    System.out.println(txt.readPalindrome());
    System.out.println("------------------------------------------------------");
    
  }
  
  //TODO: Interface qui lit les fichier:
  // -IFileReader: ouvrirFichier(); closeFile()
  //   - FileReader: define above methode
  //     - FileReaderText(): Define The HOW to read the file
  //     - FileReaderAudio()
  
}
