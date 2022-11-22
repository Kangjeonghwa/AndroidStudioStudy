package org.example.mysummary1;

public class CommentItem {
    String name;
    //String time;
    String comment;

    public CommentItem(String name, String comment) {
        this.name = name;
        //this.time = time;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    //

    public String getComment() {
        return comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    //

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "UserItem{" +
                "name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
