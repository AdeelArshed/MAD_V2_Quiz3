package com.example.mad_v2_quiz3;

public class StdInfo {


    String id,email,fullname, cell,program,institute;
    public StdInfo() {
    }

    public StdInfo(String id, String email, String fullname, String cell, String program, String institute) {
        this.id = id;
        this.email = email;
        this.fullname = fullname;
        this.cell = cell;
        this.program = program;
        this.institute = institute;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }
}

