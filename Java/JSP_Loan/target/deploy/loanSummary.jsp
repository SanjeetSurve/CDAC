<%@ page import="app.components.Loan" %>
<%
    // ithe sarv attributes aalet loaninfo madhun
    Loan loan = (Loan) request.getAttribute("loan");
    double emi = (double) request.getAttribute("emi");
    double tax = (double) request.getAttribute("tax");
    double discount = (double) request.getAttribute("discount");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Loan Summary</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h2 class="my-4">Loan Summary</h2>
        <!-- Ithe aapn basically Table create kartoy -->
        <table class="table table-bordered">
            <tr>
                <th>
                    Loan Type
                </th>
                    <td>
                        <%= loan.getClass().getSimpleName() %>
                    </td>
            </tr>
            <tr>
                <th>
                    Principal Amount
                </th>
                    <td>
                        <%= loan.getPrincipal() %>
                    </td>
                </tr>
            <tr>
                <th>
                    Period (years)
                </th>
                    <td>
                        <%= loan.getPeriod() %>
                    </td>
            </tr>
            <tr>
                <th>
                    Rate of Interest
                </th>
                    <td>
                        <%= loan.getRate() %>
                    </td>
            </tr>
            <tr>
                <th>Discount</th>
                    <td>
                        <%= String.format("%.2f", discount) %>
                    </td>
            </tr>
            <tr>
                <th>
                    Tax
                </th>
                    <td>
                        <%= String.format("%.2f", tax) %>
                    </td>
            </tr>
            <tr>
                <th>
                    EMI (per month)
                </th>
                    <td>
                        <%= String.format("%.2f", emi) %>
                    </td>
            </tr>
        </table>
        <a href="loanForm.jsp" class="btn btn-primary">Apply for Another Loan</a>
    </div>
</body>
</html>