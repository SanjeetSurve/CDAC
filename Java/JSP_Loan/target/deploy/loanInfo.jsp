// ithe sarv values yetayt  

<%@ page import="app.components.*" %>
<%
    // Retrieve form values
    
    // Principal Amount ithe yete  
    double principal = Double.parseDouble(request.getParameter("principal"));

    // Ithe aapn Tenure gheto  
    float period = Float.parseFloat(request.getParameter("period"));

    // Ani loan Type select karto  
    int loanType = Integer.parseInt(request.getParameter("loanType"));

    // jo aaplya LoanFactoy madhe aahe nah S/W case tyala ha refer kartoy  
    Loan loan = LoanFactory.createLoan(loanType, principal, period);

    // ithe aapn tya Values nah call kartoy Factory Class madhun  
    double emi = loan.getEMI();
    double tax = (loan instanceof Taxable) ? ((Taxable) loan).getTax() : 0;
    double discount = (loan instanceof Discountable) ? ((Discountable) loan).getDiscount() : 0;

    // Ani jo apla Data dyacha frontend la toh ithun jatoy hotoy  
    request.setAttribute("loan", loan);
    request.setAttribute("emi", emi);
    request.setAttribute("tax", tax);
    request.setAttribute("discount", discount);

    // ha basically aapla jo data aahe nah tyala send kartoy loanSummary madhe aani toh aplya frontend la display karoy  
    request.getRequestDispatcher("loanSummary.jsp").forward(request, response);
%>