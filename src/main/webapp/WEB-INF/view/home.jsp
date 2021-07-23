<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  
  User: lonewol7f
  Date: 14/07/2021
  Time: 18:54
  
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <security:authentication property="principal" var="principal"/>

    <script>
        function loader() { /* to make sure the script runs after page load */

            $('.item').each(function (event) { /* select all divs with the item class */

                var max_length = 150; /* set the max content length before a read more link will be added */

                if ($(this).html().length > max_length) { /* check for content length */

                    var short_content = $(this).html().substr(0, max_length); /* split the content in two parts */
                    var long_content = $(this).html().substr(max_length);

                    $(this).html(short_content + '...' +
                        '<details>' +
                        '<summary style="float: right">see all/less</summary>' + '<p style="clear:both;">' + short_content + long_content + '</p>' +
                        '</details>');
                }

            });


        };

    </script>

</head>
<body onload="loadData()">

<div style="display: flex; align-content: center;justify-content: center">
    <h1 style="font-family: 'Ubuntu Mono'">It's Working Baby</h1>
</div>
<hr>
<div>
    <p>User: ${principal.username}</p>
</div>

<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout"/>
</form:form>

<div class="container" style="width: 40%;">
    <div>
        name:role
        <div class="mb-3">
            <textarea class="form-control" id="commentBox" placeholder="Type your comment..." rows="3"
                      style="resize: none;"></textarea>
        </div>
        <button onclick="" class="btn btn-primary" style="float: right;">Comment</button>
    </div>
    <div id="results" style="clear: both; margin-top: 10vh;" class="container">

    </div>
</div>


</body>
</html>
