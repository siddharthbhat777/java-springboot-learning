<%@page language="java" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    </body>
        <!-- <h2>Result is: <%= session.getAttribute("result") %></h2> -> normal servlet way -->
        <h2>Result is: ${result}</h2> <!-- JSTL way -->
    </body>
</html>