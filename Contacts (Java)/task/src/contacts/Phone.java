package contacts;

import java.time.LocalDateTime;

abstract public class Phone {
    private String name;

    private String number;
    private LocalDateTime initial;
    private LocalDateTime lastEdit;

    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setInitial(LocalDateTime initial) {
        this.initial = initial;
    }

    public LocalDateTime getInitial() {
        return initial;
    }

    public void setLastEdit(LocalDateTime lastEdit) {
        this.lastEdit = lastEdit;
    }

    public LocalDateTime getLastEdit() {
        return lastEdit;
    }

    public void show() {
    }

    public String getFull(){
        return this.name;
    }

    public String regexTool() {
        return "";
    }
}


