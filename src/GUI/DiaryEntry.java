import java.util.ArrayList;
import java.util.List;

public class DiaryEntry {

    String date;
    String header;
    String body;
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

    public void DiaryEntry(){
        for (int i = 0; i < diaryEntryList.size(); i++) {
            diaryEntryList.get(i).date.toString();
            diaryEntryList.get(i).header.toString();
            diaryEntryList.get(i).body.toString();
        }
        return;
    }


}
