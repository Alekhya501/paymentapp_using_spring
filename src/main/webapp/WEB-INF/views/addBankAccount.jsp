
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Bank Account</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }
        .container {
            width: 60%;
            margin: auto;
            text-align: center;
            padding-top: 20px;
        }
        .title {
            font-size: 24px;
            font-weight: bold;
            color: red;
            border: 2px solid red;
            padding: 10px;
            margin-bottom: 20px;
            display: inline-block;
        }
        .form-container {
            background: white;
            border: 2px solid black; /* Black border */
            padding: 30px;
            width: 100%;
            max-width: 500px;
            margin: auto;
            text-align: left;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        label {
            font-size: 16px;
            font-weight: bold;
            color: black;
            display: block;
            margin-top: 10px;
        }
        input {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 2px solid black; /* Black border for inputs */
            border-radius: 5px;
            outline: none;
        }
        .btn {
            background-color: blue;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 15px;
            font-size: 16px;
            display: block;
            width: 100%;
        }
        .btn:hover {
            background-color: darkblue;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="title">Add Bank Account</div>
        <br><br>
        <div class="form-container">
            <form action="/addnewbankaccount" method="post">
	           
	            
            
                <label>Bank Name:</label>
                <input type="text" name="bankName" required>
                 

                <label>Account Number:</label>
                <input type="text" name="accountNumber" required>

                <label>Account Type Active Or not :</label>
                <input type="text" name="isActive" required>

                <label>Ifsc code:</label>
                <input type="text" name="ifscCode" required>
                
                 <label>branch :</label>
                <input type="text" name="branchLocation" required>

                <label>Current balance:</label>
                <input type="number" name="balance" required>

                

                <button type="submit" class="btn">Submit</button>
            </form>
        </div>
    </div>
</body>
</html>
