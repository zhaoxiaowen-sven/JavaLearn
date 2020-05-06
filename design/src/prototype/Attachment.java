package prototype;

import java.io.Serializable;

public class Attachment implements Serializable {
    private String name; //附件名

    public Attachment(){

    }

    public Attachment(Attachment attachment){
        this.name = attachment.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
