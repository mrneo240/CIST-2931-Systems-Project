<%---------------------------------------- 
    Boobin Choi
    UpdateDentist.jsp
    April 07, 2018
-----------------------------------------%>

<%@page import="java.util.ArrayList"%>
<%@page import="Business.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Dentist</title>
        <link rel="stylesheet" href="dentist.css">
        <% 
            Dentist d1 = new Dentist();
            d1 = (Dentist)session.getAttribute("d1");
            
        %>
    </head>
    <body>
        <div id="wrapper">
        <header>
            <div id="header-name">
                <h1>Smile Dentistry</h1>
            </div>
            <div id="header-logo">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0WWAzum7Iq2XqxbfpnrBx9PKIQ8QgOXehkPhL-_m0X6C2gOUGOA"
                     alt="Smile Face" height="60" width="60">
            </div>                
            <div id="header-middle">
                <h2>123-456-7890</h2>
                <p>available for emergencies</p>
            </div>
            <div id="header-right">
                123 smile road<br>
                Atlanta, GA 30001
            </div>
        </header>
            <main>
                <h4 id="displaymain">We will always make you SMILE!</h4>
                <h1 style="padding-left: 20px">Change your Information!</h1>
                <form action="UpdateDentistServlet" method="POST">
            <table>
            <tr>
                <th>Your Name</th>
                <td><label name="dentistFirstName"><%= d1.getDentFirstName() %></label>
                    <label name="dentistLastName"><%= d1.getDentLastName() %></label></td>
            </tr>
            <tr>
                <th>Your ID</th>
                <td><label name="dentistID"><%= d1.getDentID() %></label></td>
            </tr>
            <tr>
                <th><label for="dentistPassword">Your Password</label></th>
                <td><input type="text" name="dentistPassword" placeholder="Enter your Password"></td>
            </tr>
            
            <tr>
                <th><label for="dentistEmail">Your E-mail</label></th>
                <td><input type="text" name="dentistEmail" placeholder="Enter your E-mail"></td>
            </tr>
            <tr>
                <th><label for="dentistOffice">Your Office</label></th>
                <td><input type="text" name="dentistOffice" placeholder="Enter your Office"></td>
            </tr>
        </table>
        <div id="displaybuttons">
            <div class="displaybutton">
                <input type="submit" name="updateDentist" value="UPDATE" >
            </div>
            <div class="displaybutton">
                <input type="reset" name="reset" value="CLEAR" >
            </div>
            <div class="displaybutton">
                    <input type="button" name="goback" value="CANCEL" onClick="JavaScript:window.location='DisplayDentist.jsp';">
            </div>
        </div>
            </form>
        </main>
    </body>
</html>
