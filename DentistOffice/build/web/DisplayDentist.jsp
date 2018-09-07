<%---------------------------------------- 
    Boobin Choi
    DisplayDentist.jsp
    April 07, 2018
-----------------------------------------%>
<%@page import="Business.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="dentist.css">
        <title>Dentist</title>
        <% 
            Dentist d1 = new Dentist();
            d1 = (Dentist)session.getAttribute("d1");
            
            ArrayList<Appointment> apptList = d1.getAppointmentList().getAppointmentList();
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
            <h4 style="font-size: 30px;">Your Information</h4>
            <form action="UpdateDentist.jsp" method="POST">
        <table>
            <tr>
                <th>Your ID</th>
                <td><%= d1.getDentID() %></td>
            </tr>
            <tr>
                <th>Your Password</th>
                <td><%= d1.getDentPassword() %></td>
            </tr>
            <tr>
                <th>Your Name</th>
                <td><%= d1.getDentFirstName() + " " + d1.getDentLastName() %></td>
            </tr>           
            <tr>
                <th>Your E-mail</th>
                <td><%= d1.getDentEmail() %></td>
            </tr>
            <tr>
                <th>Your Office Number</th>
                <td><%= d1.getDentOffice() %></td>
            </tr>
        </table>
            
        <div id="displaybuttons">
            <div class="displaybutton">
                <input type="submit" name="updateDentist" value="CHANGE YOUR INFORMATION" >
            </form>
            </div>
        </div>
            
        <h4 style="font-size: 30px;">Your Appointments</h4>
            <table>
            <tr>
                <th>Appointment Date and Time</th>
                <th>Patient Name</th>
                <th>Procedure Name</th>
                <th>Procedure Description</th>
            </tr>
            
            <% for(int i = 0; i < apptList.size(); i++){
                
                Appointment appt = apptList.get(i);
                
                Patient p1 = new Patient();
                p1.selectPatient(appt.getPatID());
                
                Procedures proc = new Procedures();
                proc.selectDB(appt.getProcCode());
            %>

                <tr>
                    <td><%= appt.getApptDateTime() %></td>
                    <td><%= p1.getPatFirstName()+" "+ p1.getPatLastName() %></td>
                    <td><%= proc.getProcName() %></td>
                    <td><%= proc.getProcDesc() %></td>
                </tr>


            <% }; %>
        </table>
        <div class="emptyspot"></div>
        </main>
        </div>
    </body>
</html>
