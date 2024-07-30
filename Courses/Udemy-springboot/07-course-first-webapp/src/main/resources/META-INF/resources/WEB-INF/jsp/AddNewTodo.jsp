<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    <link href="webjars/eonasdan-bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <title>Login Page</title>
</head>
<body>
    <jsp:include page="common/Header.jsp"/>
    <div class="container">
            <h1> Task Details </h1>
            <hr/>
            <form:form modelAttribute="todo" method="post">
                <!-- description -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Description</span>
                    </div>

                    <form:input type="text" class="form-control" path="description" required="required"/>
                    <form:errors path="description" cssClass="text-warning"/>
                </div>
                <!-- Deadline -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Deadline</span>
                    </div>

                    <form:input type="text" id="deadline" path="deadline" required="required"/>
                    <form:errors path="deadline" cssClass="text-warning"/>
                </div>
                <!-- <div class="input-group mb-3">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Done</span>
                    </div>

                    <form:input type="hidden" class="form-control" path="done" required="required"/>
                </div> -->



                <div class="input-group-append">
                    <button type="submit" class="btn btn-outline-primary">Confirm</button>
                </div>

            </form:form>
        </div>


    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/momentjs/2.29.1/moment.min.js"></script>
        <script src="webjars/eonasdan-bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript">
    	$('#deadline').datetimepicker({
    	    format: 'yyyy-mm-dd'
    	});
    </script>
</body>
</html>
