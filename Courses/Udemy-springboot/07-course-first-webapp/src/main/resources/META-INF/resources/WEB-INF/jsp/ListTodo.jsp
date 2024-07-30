<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    <title>List Todo Page</title>
</head>
<body>
    <jsp:include page="common/Header.jsp"/>
    <div class="container">
        <h1> Todo List</h1></br>
        <h2>Name : ${username}</h2>
        <hr />
        <table class="table table-striped table-hover">
            <thead class="thead-light">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">description</th>
                    <th scope="col">Deadline</th>
                    <th scope="col">Done</th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <th scope="row">${todo.id}</td>
                        <td>${todo.description}</td>
                        <td>${todo.deadline}</td>
                        <td>${todo.done}</td>
                        <td>
                            <a href="updateTodoPage?id=${todo.id}" class="btn btn-sm btn-success">Update</a>
                            <a href="deleteTodo?id=${todo.id}" class="btn btn-sm btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="addNewTodo" class="btn btn-primary">Add New Task</a>
    </div>

    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
