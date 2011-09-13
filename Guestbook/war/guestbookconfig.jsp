<%@page import="java.net.URLEncoder"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.JSR"%>
<%@page import="sun.beans.editors.StringEditor"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.List"%>
<%@page import="guestbook.Greeting"%>
<%@page import="guestbook.PMF"%>
<%@page import="javax.jdo.PersistenceManager"%>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<html>
  <head>
    <link type="text/css" rel="stylesheet" href="/stylesheets/main.css" />
  </head>
  <body>

<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    if( user!=null && user.getEmail().equals("woutereverse@gmail.com") && user.getUserId().equals("105076256560637784048")){
		
	
%>

<p>Hallo, <%= user.getNickname() %>! (Je kunt
<a href="<%= userService.createLogoutURL(request.getRequestURI()) %>">uitloggen</a>.)
<a href="/delete">berichten verwijderen</a>
</p><hr/>

<H2>
	Welkom bij de config...
</H2>
	
	<p>Vul hieronder je reactie in en druk op "Reactie plaatsen".</p>
	<form action="/sign" method="post">
	  Beste ervaring:<div><textarea name="content1" rows="4" cols="80"></textarea></div>
	  Slechtste ervaring:<div><textarea name="content2" rows="4" cols="80"></textarea></div>
	  <div><input type="submit" value="Reactie plaatsen" /></div>
	</form>
<%
    } else {
%>

<p>Hallo!
<a href="<%= userService.createLoginURL(request.getRequestURI()) %>">Log in</a>
</p>

<%
    }
%>

<hr/>
<%
	PersistenceManager pm = PMF.get().getPersistenceManager();
    String query = "select from " + Greeting.class.getName() + " order by date desc range 0,0";
    List<Greeting> greetings = (List<Greeting>) pm.newQuery(query).execute();
/*    UITGECOMMENT
	if(greetings.isEmpty()){
%>

<p>Er zijn geen evaluaties.</p>

<%
    } else {
%>
<p>The 10 most recent messages in this guestbook are:</p>
<%
        for (Greeting g : greetings) {
            if (g.getAuthor() == null) {
%>

<p>An anonymous person wrote on <%= g.getDate() %>:</p>

<%
            } else {
%>

<p><b><%= g.getAuthor().getNickname() %></b> wrote on <%= g.getDate() %>:</p>

<%
			
            }
%>

<blockquote><%= g.getContent() %></blockquote>

<%
        }
    }
    pm.close();
*/
%>


  </body>
</html>