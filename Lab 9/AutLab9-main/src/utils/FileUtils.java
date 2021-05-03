package utils;

import model.Note;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtils {

    private static final String NOTES_PATH = "./notes/";
    private static ArrayList<Note> currentNotes;

    //It's a static initializer. It's executed when the class is loaded.
    //It's similar to constructor
    static {
        boolean isSuccessful = new File(NOTES_PATH).mkdirs();
        System.out.println("Creating " + NOTES_PATH + " directory is successful: " + isSuccessful);
    }

    public static File[] getFilesInDirectory() {
        return new File(NOTES_PATH).listFiles();
    }


    public static String fileReader(File file) {
        //TODO: Phase1: read content from file
        try{
            String content = "";
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int count;
            char[] buffer = new char[2048];
            while(reader.ready()){
                count = reader.read(buffer);
                content += new String(buffer, 0, count);
            }
            reader.close();
            return content;
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return "";
    }

    public static void fileWriter(String content) {
        //TODO: write content on file

        String fileName = getProperFileName(content);

        try{

            FileWriter fileWriter = new FileWriter(NOTES_PATH + fileName);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(content);

            writer.flush();

            writer.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //TODO: Phase1: define method here for reading file with InputStream
    public static String inputStreamRead(File file){
        try{
            FileInputStream in = new FileInputStream(file);

            StringBuilder builder = new StringBuilder();
            int i;
            while((i = in.read()) != -1){
                builder.append((char)i);
            }

            in.close();
            return builder.toString();
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return "";
    }
    //TODO: Phase1: define method here for writing file with OutputStream
    public static void outputStreamWrite(String content){
        String filename = getProperFileName(content);

        try{
            FileOutputStream reader = new FileOutputStream(NOTES_PATH + filename);
            byte[] bytes = content.getBytes();
            reader.write(bytes);
            reader.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //TODO: Phase2: proper methods for handling serialization
//    public static Note[] getNoteObjects(){
//        try(FileInputStream fInput = new FileInputStream(NOTES_PATH + "note.txt")){
//
//            ObjectInputStream oInput = new ObjectInputStream(fInput);
//            ArrayList<Note> notes;
//            notes = (ArrayList<Note>) oInput.readObject();
//            Note[] arrayNotes = new Note[notes.size()];
//            int i = 0;
//            for(Note note: notes){
////                System.out.println(note);
//                arrayNotes[i] = note;
//                i++;
//            }
//
//            return arrayNotes;
//        } catch (EOFException ex){
////            System.out.println("EOF");
//        } catch(Exception ex){
//            ex.printStackTrace();
//        }
//
//        return null;
//    }
//
//    public static void createSerializedFile(){
//        try(FileOutputStream fOutput = new FileOutputStream(NOTES_PATH + "note.txt")){
//            ObjectOutputStream oOutput = new ObjectOutputStream(fOutput);
//            Note[] currentNotes = FileUtils.getNoteObjects();
//            if(currentNotes == null || currentNotes.length == 0){
////                System.out.println("empty file");
//                Note[] notes = new Note[]{new Note("title","something","date")};
//                oOutput.writeObject(notes);
//            }
//
//            oOutput.close();
//        } catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//
//    public static void writeObject(String content){
//        try(FileOutputStream fOutput = new FileOutputStream(NOTES_PATH + "note.txt")){
//
//            String fileName = getProperFileName(content);
//            String date = "date";
//            Note[] notes = FileUtils.getNoteObjects();
//                System.out.println(notes.length);
//            Note[] newNotes = new Note[notes.length + 1];
//            int i = 0;
//            for(Note note: notes){
//                System.out.println(note);
//                newNotes[i] = note;
//            }
//            newNotes[notes.length] = new Note(fileName, content, date);
//            ObjectOutputStream oOutput = new ObjectOutputStream(fOutput);
//            oOutput.writeObject(newNotes);
//
//        } catch(Exception ex){
//            ex.printStackTrace();
//        }
//    }
    public static ArrayList<Note> getNoteObjects(){
        try(FileInputStream fInput = new FileInputStream(NOTES_PATH + "note.txt")){

            ObjectInputStream objectInputStream = new ObjectInputStream(fInput);
            ArrayList<Note> notes = (ArrayList<Note>) objectInputStream.readObject();
            currentNotes = notes;
            for(Note note: notes){
                System.out.println(note);
            }

            return notes;
        } catch (EOFException ex){
//            System.out.println("EOF");
        } catch(Exception ex){
            ex.printStackTrace();
        }

        return null;
    }

    public static void createSerializedFile(){
        try(FileOutputStream fOutput = new FileOutputStream(NOTES_PATH + "note.txt")){
            ObjectOutputStream oOutput = new ObjectOutputStream(fOutput);
            ArrayList<Note> fileNotes = FileUtils.getNoteObjects();
            if(fileNotes == null || fileNotes.size() == 0){
                System.out.println("empty file");
                Note newNote = new Note("title","something","date");
                currentNotes = new ArrayList<>();
                currentNotes.add(newNote);
                oOutput.writeObject(currentNotes);
            }

            oOutput.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void writeObject(String content){
        try(FileOutputStream fileOutputStream = new FileOutputStream(NOTES_PATH + "note.txt")){

            String fileName = getProperFileName(content);
            String date = "date";
            currentNotes.add(new Note(fileName, content, date));
            ObjectOutputStream oOutput = new ObjectOutputStream(fileOutputStream);
            oOutput.writeObject(currentNotes);

        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private static String getProperFileName(String content) {
        int loc = content.indexOf("\n");
        if (loc != -1) {
            return content.substring(0, loc) + ".txt";
        }
        if (!content.isEmpty()) {
            return content + ".txt";
        }
        return System.currentTimeMillis() + "_new file.txt";
    }
}
