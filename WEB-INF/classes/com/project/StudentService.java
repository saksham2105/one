package com.project;
import com.thinking.machines.webrock.annotations.*;
import com.thinking.machines.webrock.injections.*;
import java.util.*;
@Path("/studentService")
@InjectApplicationScope
@InjectRequestScope
@InjectSessionScope
@InjectApplicationDirectory
public class StudentService
{
private List<String> list=new ArrayList<>();
@InjectRequestParameter("xyz")
private String xyz;
private ApplicationScope applicationScope;
private SessionScope sessionScope;
private RequestScope requestScope;
private ApplicationDirectory applicationDirectory;
public void setApplicationScope(ApplicationScope applicationScope)
{
System.out.println("Set Application Scope invoked");
this.applicationScope=applicationScope;
}
public void setSessionScope(SessionScope sessionScope)
{
System.out.println("Set Session Scope invoked");
this.sessionScope=sessionScope;
}
@Path("/test")
@Get
@Forward("/index.jsp")
public String testStudent()
{
System.out.println("Test Student Invoked");
return "Saksham";
}
@Path("/test1")
@Get
public void test1()
{
System.out.println("Test 1 invoked");
}
@Path("/test2")
@Get
@Forward("/studentService/test1")
public void test2()
{
System.out.println("Test 2 invoked");
}
@Path("/startup")
@Get
@OnStartup(priority=1)
public void startup()
{
list.add("Mohan");
list.add("Suresh");
System.out.println("Startup Invoked");
}
@Path("/startup2")
@Get
@OnStartup(priority=2)
public void startup2()
{
for(String l : this.list)
{
System.out.println(l);
}
System.out.println("Startup2 Invoked");
}
@Path("/startup3")
@Get
@OnStartup(priority=3)
public void startup3()
{
for(String l : this.list)
{
System.out.println(l);
}
System.out.println("Startup3 Invoked");
}
@Path("/abc")
@Get
public void abc()
{
if(this.applicationScope!=null) 
{
this.applicationScope.setAttribute("name","Mohan");
this.applicationScope.setAttribute("id",1001);
}
}
@Path("/fetchStudent")
@Get
public void fetchStudent()
{
if(this.applicationScope!=null) 
{
if(this.applicationScope.getAttribute("name")!=null) System.out.println(this.applicationScope.getAttribute("name"));
if(this.applicationScope.getAttribute("id")!=null) System.out.println(this.applicationScope.getAttribute("id"));
}
}
@Path("/requestParam")
@Get
public String requestParam()
{
System.out.println("Request Param invoked for "+xyz);
return xyz;
}
@Path("/pathVariable")
@Get
public void pathVariable(@RequestParameter("gender") Character gender,@PathVariable Integer code,@PathVariable String name,@PathVariable Double salary)
{
System.out.println(code+","+name+","+salary+","+gender);
}
@Path("/addStudent")
@Post
public Student addStudent(Student student,ApplicationScope as,RequestScope rs,@PathVariable Integer aaa)
{
System.out.println(student.getRollNumber()+","+student.getName());
System.out.println("aaa : "+aaa);
return student;
}
}