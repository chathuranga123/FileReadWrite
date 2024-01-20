package com.gwsc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileReadWrite {
   static  String FILE_PATH="";
   static  int LINE_COUNT=0;
   static  String WRITE_FILE_NAME="MubasherFixFileUploaderdropcopy";
   static  String READ_FILE_NAME="";

    public static void main(String arg[]){
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter Reading File Name : ");
            String readingFileName = in.nextLine();
            if(readingFileName!=null) {
                READ_FILE_NAME=readingFileName;
            }
            System.out.println("Enter Writing File Name : ");
            String s = in.nextLine();
            if(s!=null) {
                WRITE_FILE_NAME=s;
            }
            System.out.println("File Name Is: " + s);
            System.out.println("Enter Line Count : " );
            String a = in.nextLine();
            System.out.println("Line Count Is: " + a);
            LINE_COUNT=new Integer(a.toString());
            Path currentDirectoryPath = FileSystems.getDefault().getPath("");
            FILE_PATH = currentDirectoryPath.toAbsolutePath().toString();
            System.out.println("Current Directory = \"" + FILE_PATH + "\"");
            createFolder();
            readFile();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



    public static void readFile(){
        try {
            int lineCount=0;
            String fileName="";
            int fileCount=0;
            File writeFile=null;
            FileWriter fileWriter=null;
            File readFile = new File(FILE_PATH+"\\"+READ_FILE_NAME+".txt");
            Scanner myReader = new Scanner(readFile);
            while (myReader.hasNextLine()) {
                lineCount=lineCount+1;
                if(lineCount==1){
                    fileCount=fileCount+1;
                    fileName=FILE_PATH+"\\Out put\\"+WRITE_FILE_NAME+fileCount;
                    writeFile= new File(fileName+".txt");
                    fileWriter = new FileWriter(writeFile);
                }
                if(lineCount<=LINE_COUNT){
                    String data = myReader.nextLine();
                    fileWriter.write(data);
                    fileWriter.write("\n");
                }
                System.out.println("File created: " + fileName +" fileCount :" +fileCount +"File Line count :"+lineCount);
                 if(lineCount==LINE_COUNT){
                    lineCount=0;
                    fileWriter.close();
                }
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    public static void createFolder(){
        try {
            File f1 = new File(FILE_PATH+"\\Out put");
            boolean bool = f1.mkdir();
            if(bool){
                System.out.println("Folder is created successfully");
            }else{
                System.out.println("Error Found!");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


}
