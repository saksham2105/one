package com.project;
import com.thinking.machines.webrock.annotations.*;
@Path("/projectService")
public class ProjectService
{
@AutoWired(name="name")
private String name;
@AutoWired(name="id")
private Integer id;
@Path("/autowired")
@Get
public void autowired()
{
if(id!=null) System.out.println(id);
if(name!=null) System.out.println(name);
}
}