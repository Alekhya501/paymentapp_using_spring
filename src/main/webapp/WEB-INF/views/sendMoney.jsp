<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.alekhya.paymentapp.entities.BankAccountEntity" %>
<!DOCTYPE html>
<html>
<head>
    <title>Send Money</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            width: 400px;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .header {
            font-size: 24px;
            font-weight: bold;
            color: blue;
            margin-bottom: 20px;
        }
        .form-group {
            text-align: left;
            margin-bottom: 15px;
        }
        .form-group label {
            font-size: 16px;
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }
        .form-group input, .form-group select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }
        .radio-group {
            display: flex;
            align-items: center;
            margin-bottom: 15px;
        }
        .radio-group input {
            margin-right: 10px;
        }
        .send-btn {
            width: 100%;
            padding: 10px;
            border: none;
            background-color: blue;
            color: white;
            font-size: 16px;
            font-weight: bold;
            border-radius: 5px;
            cursor: pointer;
        }
        .send-btn:hover {
            background-color: #c9302c;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">SEND MONEY</div>
        
        <form action="sendMoney" method="post">
            <div class="form-group">
                <label>Amount to Send:</label>
                <input type="number" name="amount" required>
            </div>

            <!-- FROM ACCOUNT -->
            <div class="form-group">
                <label>From:</label>
                <select name="fromAccount" required>
                    <%
                        List<BankAccountEntity> fromAccounts = (List<BankAccountEntity>) request.getAttribute("fromAccounts");
                        for (BankAccountEntity acc : fromAccounts) {
                    %>
                        <option value="<%= acc.getAccountNumber() %>">
                            <%= acc.getAccountNumber() %> - ₹<%= acc.getBalance() %>
                        </option>
                    <%
                        }
                    %>
                </select>
            </div>

            <!-- TO ACCOUNT RADIO -->
            <div class="radio-group">
                <input type="radio" name="sendTo" value="account" required>
                <label>To Account</label>
            </div>

            <!-- TO ACCOUNT DROPDOWN -->
            <div class="form-group">
                <select name="toAccountNumber">
                    <%
                        List<BankAccountEntity> toAccounts = (List<BankAccountEntity>) request.getAttribute("toAccounts");
                        for (BankAccountEntity acc : toAccounts) {
                    %>
                        <option value="<%= acc.getAccountNumber() %>">
                            <%= acc.getAccountNumber() %> - <%= acc.getUser().getUserName() %>
                        </option>
                    <%
                        }
                    %>
                </select>
            </div>

            <!-- WALLET RADIO -->
            <div class="radio-group">
                <input type="radio" name="sendTo" value="wallet">
                <label>To Wallet</label>
            </div>

            <!-- WALLET INPUT -->
            <div class="form-group">
                <input type="text" name="walletId" placeholder="Enter Wallet ID">
            </div>

            <button type="submit" class="send-btn">SEND</button>
        </form>
    </div>
</body>
</html>
