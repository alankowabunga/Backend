<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <div class="container">
        <h1> Hello ${username} , please login !</h1>
        <pre>${errorMessage}</pre>
        <form method="post">
            Account: <input type="text" name="account">
            Password: <input type="password" name="password">
            <input type="submit">
        </form>
    </div>
</body>
</html>