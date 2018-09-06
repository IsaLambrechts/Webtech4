<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>

<title>Spring Boot</title>
</head>
<body>

  <div class="form">
    <form action="joke_post" method="post" onsubmit="return validate()">
      <label>Enter your lastname</label>
      <input id="name" name="name"><br/><br/>
      <label>Enter your firstname</label>
      <input id="firstname" name="firstname"><br/><br/>
      <input type="submit" value="Submit">
    </form>
  </div>

</body>
</html>