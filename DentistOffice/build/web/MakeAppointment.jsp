<%---------------------------------------- 
    Boobin Choi
    MakeAppointment.jsp
    April 07, 2018
-----------------------------------------%>

<%@page import="Business.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="dentist.css">
        <title>Make Patient's Appointment</title>
        <% 
            Patient p1 = new Patient();
            p1 = (Patient)session.getAttribute("p1");    
            
            Appointment a1 = new Appointment();
            a1 = (Appointment)session.getAttribute("a1");
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
        <h1 style="padding-left: 30px;">Make your Appointment!</h1>
        <main>
            <form action="MakeAppointmentServlet" method="POST">
            <table>
            <tr>
                <th>Your ID</th>
                <td><%= p1.getPatID() %></td>
            </tr>
            <tr>
                <th><label for="dateTime">Preferable Date and Time</label></th>
                <td><input type="text" name="dateTime" placeholder="Enter the Date and Time you desire"></td>
            </tr>
            <tr>
                <th><label for="chooseDentist">Choose your Dentist</label></th>
                <td><select id="chooseDentist" name="chooseDentist">
                        <option value="D201" <%if((p1.getAppointment().getDentID())=="D201"){ %> selected <%}%> >Frank Martin</option>
                        <option value="D202" <%if((p1.getAppointment().getDentID())=="D202"){ %> selected <%}%> >Susan Cassidy</option>
                        <option value="D203" <%if((p1.getAppointment().getDentID())=="D203"){ %> selected <%}%> >Jerry York</option>
                        <option value="D204" <%if((p1.getAppointment().getDentID())=="D204"){ %> selected <%}%> >Wayne Patterson</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th><label for="chooseProcedure">Choose your Procedure</label></th>
                <td><select id="chooseProcedure" name="chooseProcedure">
                        <option value="P114" <%if((a1.getProcCode())=="P114"){ %> selected <%}%> >Cleaning/Exam</option>
                        <option value="P119" <%if((a1.getProcCode())=="P119"){ %> selected <%}%> >Xrays</option>
                        <option value="P122" <%if((a1.getProcCode())=="P122"){ %> selected <%}%> >Whitening</option>
                        <option value="P321" <%if((a1.getProcCode())=="P321"){ %> selected <%}%> >Cavity</option>
                        <option value="P650" <%if((a1.getProcCode())=="P650"){ %> selected <%}%> >Top Dentures</option>
                        <option value="P660" <%if((a1.getProcCode())=="P660"){ %> selected <%}%> >Bottom Dentures</option>
                        <option value="P780" <%if((a1.getProcCode())=="P780"){ %> selected <%}%> >Crown</option>
                        <option value="P790" <%if((a1.getProcCode())=="P790"){ %> selected <%}%> >Root Canel</option>
                    </select>
                </td>
            </tr>
        </table>
            
            <div id="displaybuttons">
                <div class="displaybutton">                 
                        <input type="submit" name="makeAppointment" value="DONE">
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
