<%---------------------------------------- 
    Boobin Choi
    UpdatePatient.jsp
    April 07, 2018
-----------------------------------------%>

<%@page import="Business.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="dentist.css">
        <title>Update Patient's Information</title>
        <% 
            Patient p1 = new Patient();
            p1 = (Patient)session.getAttribute("p1");            
            
        %>
    </head>
    <body><div id="wrapper">
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
        <h1 style="padding-left: 30px;">Update your information</h1>
        <main>
            <form action="UpdatePatientServlet" method="POST">
            <table>
            <tr>
                <th>Your Name</th>
                <td><label name="patientFirstName"><%= p1.getPatFirstName() %></label>
                    <label name="patientLastName"><%= p1.getPatLastName() %></label></td>
            </tr>
            <tr>
                <th>Your ID</th>
                <td><label for="patientID"><%= p1.getPatID() %></label></td>
            </tr>
            <tr>
                <th><label for="patientPassword">Your Password</label></th>
                <td><input type="text" name="patientPassword" placeholder="Enter Your New Password"></td>
            </tr>
            <tr>
                <th><label for="patientAddress">Your Address</label></th>
                <td><input type="text" name="patientAddress" placeholder="Enter Your New Address"></td>
            </tr>
            <tr>
                <th><label for="patientEmail">Your E-mail</label></th>
                <td><input type="text" name="patientEmail" placeholder="Enter Your New Email address"></td>
            </tr>
            <tr>
                <th><label for="patientInsurance">Your Insurance</label></th>
                <td><input type="text" name="patientInsurance" placeholder="Enter Your New Insurance"></td>
            </tr>
        </table>
            <div id="displaybuttons">
                <div class="displaybutton">
                    <input type="submit" name="updatePatient" value="UPDATE">
                </div>
                <div class="displaybutton">
                    <input type="reset" name="reset" value="CLEAR">
                </div>
                <div class="displaybutton">
                    <input type="button" name="goback" value="CANCEL" onClick="JavaScript:window.location='DisplayPatient.jsp';">
                </div>
            </div>
            </form>
        </main>    
        </div>
    </body>
</html>
