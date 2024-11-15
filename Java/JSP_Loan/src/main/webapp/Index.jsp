<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Loan Input</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2>Enter Loan Details</h2>

         // manje je kahi input asel te sarv loanInfo.jsp handle kart  
        <form action="loanInfo.jsp" method="post">
            <div class="form-group">
                 // for = id samech aahe aani "principal" ha apalya loanInfo.jsp madhe ek field aahe tyla refer kartoy   
                <label for="principal">Principal Amount:</label>

                 // ithe aapn data principal madhe pathavtoy ani ha Reuired aahe manje nahi bharla tar pudhe nahi janar submit anhi hotnar  
                <input type="number" class="form-control" name="principal" required>
                
            </div>
            <div class="form-group">
                 // same ith aapan period field la refer kartoy  
                <label for="period">Period (years):</label>
                <input type="number" class="form-control" name="period" required>
            </div>
            <div class="form-group">
                 // hey loan type ani tyacha input la control kartay  
                <label for="loanType">Loan Type:</label>
                
                 // he ek drop down list aahe  
                <select class="form-control" name="loanType">
                    <option value="1">Personal Loan</option>
                    <option value="2">Home Loan</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Calculate Loan</button>
        </form>
    </div>
</body>
</html>