<html>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    <title>Login Page</title>
</head>
<body>
    <jsp:include page="common/Header.jsp"/>
    <div class="container">
        <h1> Welcome ! Check Your Tasks</h1>
        <div>
            <a href="todoPage">${username} todo list</a>
        </div>
    </div>
</body>
</html>