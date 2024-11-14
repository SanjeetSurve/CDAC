<jsp:useBean id="Calculator" class="app.components.Calculate" scope="session"/>
<jsp:setProperty name="Calculator" property="amt" param="someone"/>
<jsp:setProperty name="Calculator" property="yr" param="yr"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calc</title>
</head>
<body>
    <form method="post">
        <p>
            <b>Principal Amount:</b>
            <input name="someone"/>
        </p>
        <p>
            <b>Years: </b>
            <input name="yr"/>
        </p>
        <input type="submit" value="submit"/>
    </form>

    <p>
        <b>Output (Calculated Interest): </b>
        <input type="text" value="<%= Calculator.getCal() %>" readonly/>
    </p>
</body>
</html>