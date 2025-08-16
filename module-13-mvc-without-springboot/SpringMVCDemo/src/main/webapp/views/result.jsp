<%@page language="java" isELIgnored="false" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    </body>
        <!-- <h2>Result is: <%= session.getAttribute("result") %></h2> -> normal servlet way -->
        <p>${alien}</h2> <!-- JSTL way -->

        <p>Welcome to the ${course} world</p>
    </body>
</html>