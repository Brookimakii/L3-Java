package org.example.fileReader.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface IFileReader {
  
  void openFile() throws FileNotFoundException;
  
  void readFile();
  
  void closeFile() throws IOException;
}

