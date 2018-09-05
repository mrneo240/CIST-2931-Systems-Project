<%---------------------------------------- 
    Boobin Choi
    LoginError.jsp
    April 07, 2018
-----------------------------------------%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="dentist.css">
        <title>Login Error</title>
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
            <div class="clearfix">
                <div class="column">
                    <h1 style="text-align: center;">Wrong password! Try Again!</h1>
                </div>
            <input type="button" name="goback" value="Go Back" onClick="JavaScript:window.location='Login.jsp';" class="buttonalone">
            </div>
        </main>
        </div>
    </body>
</html>
