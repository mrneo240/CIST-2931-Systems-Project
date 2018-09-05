<%---------------------------------------- 
    Boobin Choi
    DisplayPatient.jsp
    April 07, 2018
-----------------------------------------%>

<%@page import="Business.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="dentist.css">
        <title>Patient</title>
        <% 
            Patient p1 = new Patient();
            p1 = (Patient)session.getAttribute("p1");
            
            Appointment a1 = new Appointment();
            a1 = (Appointment)session.getAttribute("a1");
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
            <form action="UpdatePatient.jsp" method="POST">
        <table>
            <tr>
                <th>Your Name</th>
                <td><%= p1.getPatFirstName() + " " + p1.getPatLastName() %></td>
            </tr>           
            <tr>
                <th>Your ID</th>
                <td><%= p1.getPatID() %></td>
            </tr>
            <tr>
                <th>Your Password</th>
                <td><%= p1.getPatPassword() %></td>
            </tr>
            <tr>
                <th>Your Address</th>
                <td><%= p1.getPatAddress() %></td>
            </tr>
            <tr>
                <th>Your E-mail</th>
                <td><%= p1.getPatEmail() %></td>
            </tr>
            <tr>
                <th>Your Insurance</th>
                <td><%= p1.getPatInsurance() %></td>
            </tr>
        </table>
            <div id="displaybuttons">
                <div class="displaybutton">           
                    <input type="submit" name="updatePatient" value="CHANGE YOUR INFORMATION" >
                    </form>
                </div>
            </div>
            
        <h4 id="displaymain">Your Appointment is IMPORTANT to us!</h4>
        <% if (p1.makeAppointment()) {%>
        <form action="UpdateAppointment.jsp" method="POST">
        <table>
            <tr>
                <th>Your Appointment Date</th>
                <td><%= p1.getAppointment().getApptDateTime() %></td>
            </tr>
            <tr>
                <th>Your Doctor</th>
                <td>Dr. <%= a1.getDentist().getDentLastName() %></td>
            </tr>
            <tr>
                <th>Your Procedure</th>
                <td><%= a1.getProcedure().getProcName() %></td>
            </tr>
            <tr>
                <th>Your Procedure Description</th>
                <td><%= a1.getProcedure().getProcDesc() %></td>
            </tr>
            <tr>
                <th>Your Procedure Price</th>
                <td>$ <%= a1.getProcedure().getCost() %></td>
            </tr>
        </table>
            
        <div id="displaybuttons">
            <div class="displaybutton">
                <input type="submit" name="updateAppointment" value="CHANGE AN APPOINTMENT" >
            </div>
        </div>
        </form>    
            
            <% } else {%>
            
            <form action="MakeAppointment.jsp" method="POST">
                <div class="column">
                    <p style="text-align:center; font-weight:bold; font-size: 20px">You don't have any appointment with us.</p>
                </div>
            <div id="displaybuttons">
                <div class="displaybutton">
                    <input type="submit" name="updateAppointment" value="MAKE AN APPOINTMENT" >
                </div>
            </div>     
        <% }%>
            </form>   
        </main>
        </div>
    </body>
</html>
