package com.group2.miniproject.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = ExamResult.class)
public class ExamResult {
    private String name;
    private String role;
    private String schoolName;
    private int scienceMarks;
    private int mathMarks;
    private int socialScienceMarks;
    private int artMarks;
    private int sportMarks;

    public ExamResult(String name,String  role,String schoolName,int scienceMarks,
                      int mathMarks,int socialScienceMarks, int artMarks,int sportMarks){
        super();
        this.name=name;
        this.role=role;
        this.schoolName=schoolName;
        this.scienceMarks=scienceMarks;
        this.mathMarks=mathMarks;
        this.socialScienceMarks=socialScienceMarks;
        this.artMarks=artMarks;
        this.sportMarks=sportMarks;
    }

    public  void setName(String name){
        this.name=name;
    }
    public void setRole(String role){
        this.role=role;
    }
    public void setSchoolName(String schoolName){
        this.schoolName=schoolName;
    }
    public void setScienceMarks(int scienceMarks){
        this.scienceMarks=scienceMarks;
    }
    public void setMathMarks(int mathMarks){
        this.mathMarks=mathMarks;
    }
    public void setSocialScienceMarks(int socialScienceMarks){
        this.socialScienceMarks=socialScienceMarks;
    }
    public void setArtMarks(int artMarks){
        this.artMarks=artMarks;
    }
    public void setSportMarks(int sportMarks){
        this.sportMarks=sportMarks;
    }
    public String getName(){
        return this.name;
    }
    public String getRole(){
        return this.role;
    }
    public String getSchoolName(){
        return this.schoolName;
    }
    public int getScienceMarks(){
        return this.scienceMarks;
    }
    public int getMathMarks(){
        return this.mathMarks;
    }
    public int getSocialScienceMarks(){
        return  this.socialScienceMarks;
    }
    public int getArtMarks(){
        return this.artMarks;
    }
    public int getSportMarks(){
        return this.sportMarks;
    }

    @Override
    public String toString() {
        return "ExamResult{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", scienceMarks=" + scienceMarks +
                ", mathMarks=" + mathMarks +
                ", socialScienceMarks=" + socialScienceMarks +
                ", artMarks=" + artMarks +
                ", sportMarks=" + sportMarks +
                '}';
    }
}
