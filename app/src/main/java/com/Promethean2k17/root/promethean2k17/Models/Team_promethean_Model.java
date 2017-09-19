package com.Promethean2k17.root.promethean2k17.Models;



/**
 * Created by root on 15/9/17.
 */

public class Team_promethean_Model {
    public String Team_promethean_Image;
    public String Team_promethean_Name;

    public Team_promethean_Model(String Team_promethean_Image, String Team_promethean_Name){
        this.Team_promethean_Image=Team_promethean_Image;
        this.Team_promethean_Name=Team_promethean_Name;
    }

    public Team_promethean_Model() {

    }


    public String getTeam_promethean_Image() {
        return Team_promethean_Image;
    }

    public void setTeam_promethean_Image(String team_promethean_Image) {
        Team_promethean_Image = team_promethean_Image;
    }

    public String getTeam_promethean_Name() {
        return Team_promethean_Name;
    }

    public void setTeam_promethean_Name(String team_promethean_Name) {
        Team_promethean_Name = team_promethean_Name;
    }
}
