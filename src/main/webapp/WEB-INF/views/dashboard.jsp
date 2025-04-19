
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ page import="java.util.List" %>
<%@ page import="com.alekhya.paymentapp.entities.UserEntity" %>
<%@ page import="com.alekhya.paymentapp.entities.BankAccountEntity" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Dashboard</title>
<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: Arial, sans-serif;
}
body {
    background-color: #f4f4f4;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 20px;
}
.header {
    width: 100%;
    max-width: 900px;
    background: white;
    padding: 15px;
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    text-align: center;
    margin-bottom: 20px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}
.header h2 {
    color: green;
}
.logout-btn {
    background: red;
    color: white;
    padding: 8px 15px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}
.section {
    width: 100%;
    max-width: 900px;
    background: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    margin-bottom: 20px;
}
.bank-details, .transactions {
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
}
.bank-card {
    border: 2px solid orange;
    padding: 15px;
    border-radius: 10px;
    width: 30%;
    text-align: center;
    margin-top: 10px;
}
.transaction-list {
    width: 100%;
    text-align: left;
    padding: 10px;
}
.send-money-btn {
    background: blue;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    margin-top: 10px;
}
.plus-button {
    background: green;
    color: white;
    padding: 8px 10px;
    border-radius: 5px;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
}
.detailed-btn {
    background: blue;
    color: white;
    padding: 10px 15px;
    border-radius: 5px;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
}
</style>
</head>
<body>

    <div class="header">
        <h2>Payments Web App</h2>
        <form action="/logout">
            <button type="submit" class="logout-btn">Logout</button>
        </form>
    </div>

    <div class="section">
    
       <%
       UserEntity user = (UserEntity) request.getAttribute("user");
       %>
     
            <p>Welcome <%= user.getUserName() %></p>
            <p>Name : <%= user.getLastName() %></p>
            <p>Email : <%= user.getEmail() %></p>
            <p>Phone Number :<%= user.getPhoneNumber() %> </p>
            <%--
        <% } else { %>
            <p>User details not available.</p>
        <% } %>
             --%>

        <form action="/usereditprofile">
            <button class="plus-button">Edit</button>
        </form>
    </div>

    <div class="section">
        <h3>Primary Bank Account</h3>
        <%--
        <%
            ViewBankDto primaryAccount = (ViewBankDto) request.getAttribute("primaryAccount");
            if (primaryAccount != null) {
        %>
         --%>
            <div class="bank-card">
                <p><strong>Bank Name:</strong><%-- <%= primaryAccount.getBankName() %>--%> </p>
                <p><strong>Account No:</strong> <%--<%= primaryAccount.getBankAccountNo() --%></p>
                <p><strong>Balance:</strong> ₹ <%--<%= primaryAccount.getCurrentBalance() --%></p>
                <p><strong>IFSC:</strong> <%--<%= primaryAccount.getIfsc() --%></p>
            </div>
            <%--
        <%
            } else {
        %>
            <p>No primary account found.</p>
        <%
            }
        %>
             --%>
        <form action="sendMoney" method="get">
            <button class="send-money-btn">Send Money</button>
        </form>
    </div>

   <div class="section bank-details">
		<%
		List<BankAccountEntity> bankAccs = (List<BankAccountEntity>) request.getAttribute("bankAccs");
		for (BankAccountEntity bankAcc : bankAccs) {
		%>
		<div class="bank-card">
			<p><%=bankAcc.getBankName()%></p>
			<p>Bank Acct No: <%=bankAcc.getAccountNumber()%></p>
			<p>IFSC Code: <%=bankAcc.getIfscCode()%></p>
			<p>Branch: <%=bankAcc.getBranchLocation()%></p>
			<p>Balance: <%=bankAcc.getBalance()%></p>
			<a href="edit.jsp">Edit</a>
		</div>
		<% } %>

           <form action="addnewbankaccount" method="get">
            <button class="plus-button">+ Add Bank Account</button>
        </form>
		
    </div>

    <div class="section transactions">
        <h4>Recent 10 Transactions</h4>
        <div class="transaction-list">
            <p>1000 sent to Sai</p>
            <p>1300 received from Hema</p>
            <p>120 received from 800839</p>
            <p>...</p>
            <form action="/detailedstatement" method="get">
                <button class="detailed-btn">Detailed Stmt</button>
            </form>
        </div>
    </div>

</body>
</html>
