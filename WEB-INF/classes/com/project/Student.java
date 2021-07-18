package com.project;
public class Student
{
private Integer rollNumber;
private String name;
public Student()
{
this.rollNumber=0;
this.name="";
}
public void setRollNumber(Integer rollNumber)
{
this.rollNumber=rollNumber;
}
public Integer getRollNumber()
{
return this.rollNumber;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
}