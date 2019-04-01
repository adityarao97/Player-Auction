package com.example.sunita.mini.Model;

public class sign_up_info {

    String id;
    String teamid;
    String teamname;
    String password;

    public sign_up_info(){}

    public sign_up_info(String id, String teamid, String teamname, String password) {
        this.id = id;
        this.teamid = teamid;
        this.teamname = teamname;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getTeamid() {
        return teamid;
    }

    public String getTeamname() {
        return teamname;
    }

    public String getPassword() {
        return password;
    }
}


