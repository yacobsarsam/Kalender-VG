package GUI;

import java.io.BufferedReader;
import java.io.FileReader;


import java.util.ArrayList;
import java.util.List;

public class DiaryEntry {

    String date;
    String header;
    String body;
    String temp;
    String temp2 = "";
    String string1;
    String string2;
    String string3;
    public List<DiaryEntry> diaryEntryList = new ArrayList<>();

    public DiaryEntry(String date, String header, String body) {
        this.date = date;
        this.header = header;
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void diaryEntry(){
        try(BufferedReader br = new BufferedReader(new FileReader("/Users/pontuslundin/Desktop/javamapp/Analys och Design/Calendar/src/GUI/diary.txt"));){
            while(true){
                int tempInt = 0;
                temp = br.readLine();
                //StringBuilder sb = new StringBuilder(temp);
                if(temp != null){
                    char tempChar;
                    for (int i = 0; i < temp.length(); i++) {
                        tempChar = temp.charAt(i);
                        if(tempChar=='%'){
                            if(tempInt == 2){
                                string3 = temp2;
                                temp2 = "";
                                tempInt = 0;
                            }
                            if(tempInt == 1){
                                string2 = temp2;
                                temp2 = "";
                                tempInt++;
                            }
                            if(tempInt == 0){
                                string1 = temp2;
                                temp2 = "";
                                tempInt++;
                            }

                        }
                        else{
                            temp2 = temp2 + tempChar;
                        }
                    }
                    DiaryEntry de = new DiaryEntry(string1,string2,string3);
                    diaryEntryList.add(de);
                }
                else{
                    break;
                }
            }
            System.out.println(diaryEntryList.size());
            for (int i = 0; i < diaryEntryList.size(); i++) {
                System.out.println(diaryEntryList.get(i).date.toString() + " " + diaryEntryList.get(i).header.toString() + " " + diaryEntryList.get(i).body.toString());

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


}
