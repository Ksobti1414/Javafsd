package com.test;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;
import java.util.*;
public class Customtag extends TagSupport{
private static final long serialVersionUID=1L;
public int doStartTag() {
	JspWriter out=null;
	try {
		out=pageContext.getOut();
		out.println("Current Date:"+new Date());
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return SKIP_BODY;
}
}
