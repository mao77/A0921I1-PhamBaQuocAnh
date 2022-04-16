<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 07/04/2022
  Time: 5:18 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
  <style>
    img{
      width: 50%;
      height: 70%;
    }
  </style>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col">
      <img src="https://gamek.mediacdn.vn/133514250583805952/2020/11/13/1-1605284141781704584331.png" alt="">
    </div>
    <div class="col">

    </div>
    <div class="col">
      <h1>QUOC ANH</h1>
    </div>
  </div>
</div>
<div class="row">
  <div class="col-4"></div>
  <div class="col-5">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="/home">Home</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="/benhan"  role="button" data-toggle="dropdown" aria-expanded="false">
              Bệnh án
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
              <a class="dropdown-item" href="/benhan">List All</a>
              <a class="dropdown-item" href="/benhan?action=add">Create new</a>
            </div>
          </li>

        </ul>
      </div>
    </nav>
  </div>

</div>

</body>
</html>



