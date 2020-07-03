package com.dubovik.strings.reader;

import com.dubovik.strings.exception.InvalidDataException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DataReader {
    public String readDataFile(String filename) throws InvalidDataException{
        String first_filename = "input/inputFile.txt";
        String data;
        Path path = Paths.get(first_filename);
        if(Files.exists(Paths.get(filename))){
            path = Paths.get(filename);
        }
        try {
            data = Files.readString(path);
        } catch (IOException e) {
            throw new InvalidDataException("e, Problems with input file");
        }
        return data;
    }

    public String readDataConsole(){
        StringBuilder data = new StringBuilder();
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            data.append(in.nextLine());
        }
        return data.toString();
    }
}
