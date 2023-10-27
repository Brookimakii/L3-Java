package org.example.fileReader.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class FileReader implements IFileReader{
  protected FileInputStream in;
  protected File file;
  
  
  protected FileReader(File file) {this.file = file;}
  
  @Override
  public void openFile() throws FileNotFoundException {
    this.in = new FileInputStream(this.file);
  }
  
  @Override
  public void readFile() {
    try {
      openFile();
      
      int i = this.in.read();
      while (i != -1) {
        System.out.println((char) i);
        i = this.in.read();
      }
      
      closeFile();
      
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  
  @Override
  public void closeFile() throws IOException {
    in.close();
  }
}

