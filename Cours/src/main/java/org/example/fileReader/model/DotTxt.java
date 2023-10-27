package org.example.fileReader.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DotTxt extends FileReader {
  public DotTxt(File file) throws FileNotFoundException {super(file);}
  
  public String readNormally() {
    StringBuilder sb = new StringBuilder();
    try {
      openFile();
      
      int i = this.in.read();
      while (i != -1) {
        sb.append((char) i);
        i = this.in.read();
      }
      
      closeFile();
      
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return sb.toString();
  }
  
  public String readPalindrome() {
    StringBuilder sb = new StringBuilder();
    try {
      openFile();
      
      int i = this.in.read();
      StringBuilder line = new StringBuilder();
      while (i != -1) {
        if ((char) i != '\n') {
          line.insert(0, (char) i);
        } else {
          
          sb.append(line).append((char) i);
          line = new StringBuilder();
        }
        i = this.in.read();
      }
      sb.append(line);
      
      closeFile();
      
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return sb.toString();
  }
  
  public String readReversely() {
    StringBuilder sb = new StringBuilder();
    
    try {
      openFile();
      
      int i = this.in.read();
      StringBuilder line = new StringBuilder();
      while (i != -1) {
        if (i != '\n') {
          line.append((char) i);
        } else {
          sb.insert(0, String.valueOf((char) i) + line);
          line = new StringBuilder();
        }
        i = this.in.read();
      }
      sb.insert(0, line);
      
      closeFile();
      
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return sb.toString();
  }
}
