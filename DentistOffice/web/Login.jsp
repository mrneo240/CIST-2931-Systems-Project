<%---------------------------------------- 
    Boobin Choi
    Login.jsp
    April 07, 2018
-----------------------------------------%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="dentist.css">
        <title>Smile Dental Care Login</title>
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
        <main class="row">
        <div class="column">
            <h3>Patients Login</h3>
            <div class="container">
            <img src="https://www.framinghamfamilydentalcare.com/blog/wp-content/uploads/2018/01/AdobeStock_60194687-300x200.jpeg"
                 alt="patients" class="loginPics">
            </div>
            <form action="LoginServlet" method="POST">
                <label for="patientID">Username</label>
                <input type="text" name="patientID" placeholder="Enter Your ID">      
                
                <label for="patientPassword">Password</label>
                <input type="password" name="patientPassword" placeholder="Enter Password">
                
                <input type="submit" name="login" value="SUBMIT" class="secondbutton">
                <input type="reset" name="clear" value="CLEAR" class="secondbutton">
            </form>
        </div>
        <div class="column">
            <h3>Dentists Login</h3>
            <div class="container">
            <img src="https://www.d3financialcounselors.com/wp-content/uploads/2014/05/Depositphotos_11882386_m.jpg" 
                 alt="dentists" class="loginPics">
            </div>
            <form action="LoginServlet" method="POST">
                <label for="dentistID">Username</label>
                <input type="text" name="dentistID" placeholder="Enter Your ID">
                
                <label for="dentistPassword">Password</label>
                <input type="password" name="dentistPassword" placeholder="Enter Password">
                
                <input type="submit" name="login" value="SUBMIT" class="secondbutton">
                <input type="reset" name="clear" value="CLEAR" class="secondbutton">
            </form>   
        </div>
        </main>            
    </div>
    </body>
</html>
