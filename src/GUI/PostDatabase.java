package GUI;

import java.io.*;

public class PostDatabase {

    public boolean findDataAtPost(String localDate){

        boolean data = false;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(".\\src\\GUI\\diary.txt"))){
            String temp = bufferedReader.readLine();
            while(temp != null){
                String[] content = temp.split("¤");
                String date = content[0];
                if(date.equals(localDate)){
                    data = true;
                    break;
                }
                temp = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return data;
    }
    public boolean findDataAtReminder(String localDate){

        boolean data = false;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(".\\src\\GUI\\Reminders.txt"))){
            String temp = bufferedReader.readLine();
            while(temp != null){
                String[] content = temp.split(":");
                String date = content[0];
                if(date.equals(localDate)){
                    data = true;
                    break;
                }
                temp = bufferedReader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
