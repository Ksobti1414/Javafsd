package com.test;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloService {
	@GET
	@Path("/text")
	@Produces(MediaType.TEXT_PLAIN)
public String simplePlainTextResponse() {
	return "This is simple Rest API plain text response"; 
}
	@GET
	@Path("/{id}")
	@Produces(MediaType.TEXT_HTML)
	public String simpleHTMLResponse(@PathParam("id") long num) {
		return "<html><body><h1>This is simple Rest API HTML response: "+num+" </h1></body></html>";
	}
	@GET
	@Path("/fruits")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Fruits>getAllFruits(){
		return List.of(new Fruits(1,"Apple",50),new Fruits(2,"Mango",40),new Fruits(3,"Banana",15));
	}
}
