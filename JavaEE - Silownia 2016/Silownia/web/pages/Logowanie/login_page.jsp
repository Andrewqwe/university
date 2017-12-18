<%--
  Created by IntelliJ IDEA.
  User: Andrzej
  Date: 2016-12-26
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/pages/Rejestracja/register_style.css" rel="stylesheet" type="text/css">
</head><body>
<div class="section text-left">
    <div class="background-image cover-image" style="background-image : url('${pageContext.request.contextPath}/pages/Logowanie/loginbackground4.jpg')"></div>
    <div class="container"> <div class="row"> <div class="col-md-4"><a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/pages/Logowanie/Logo3.png" class="img-responsive"></a></div><div class="col-md-4"></div><div class="col-md-4"></div></div><div class="row"> <div class="col-md-4"><div class="section"></div></div><div class="col-md-4"></div><div class="col-md-4"></div></div></div>

    <div class="section text-left"> <div class="container"> <div class="row"> <div class="col-md-4"></div><div class="col-md-4">
        <form class="form-horizontal" method="post" role="form">
        <div class="form-group" id="Nickname_bar">
            <div class="col-sm-2">
                <label for="inputEmail" class="control-label"></label>
            </div>
            <div class="col-sm-10" id="Email_bar">
                <input type="email" class="form-control" id="inputEmail" name="usermail" placeholder="E-mail">
            </div>
        </div>
        <div class="form-group" id="Password_bar">
            <div class="col-sm-2">
                <label for="inputPassword" class="control-label" id="Password_Label"></label>
            </div>
            <div class="col-sm-10">
            <input type="password" class="form-control" id="inputPassword" name="userpass" placeholder="Hasło">
        </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox">Pamiętaj mnie</label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Zaloguj</button>
            </div>
        </div>
    </form>

    </div><div class="col-md-4"></div></div><div class="row"> <div class="col-md-4"></div>
        <div class="col-md-4"></div><div class="col-md-4"></div>
    </div></div></div>
</div>
<footer class="section section-danger hidden-xs">
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <h1>Kontakt</h1>
                <p>Wrocław ul. Zielona 78<br>Tel: 506 784 321<br>email: zielonawroclaw@hardcoregym.com</p>
            </div>
            <div class="col-sm-6">
                <p class="text-info text-right">
                    <br>
                    <br>
                </p>
                <div class="row">
                    <div class="col-md-12 hidden-lg hidden-md hidden-sm text-left">
                        <a href="#"><i class="fa fa-3x fa-fw fa-youtube text-inverse"></i></a>
                        <a href="#"><i class="fa fa-3x fa-fw fa-instagram text-inverse"></i></a>
                        <a href="#"><i class="fa fa-3x fa-facebook fa-fw text-inverse"></i></a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 hidden-xs text-right">
                        <a href="#"><i class="fa fa-3x fa-fw fa-youtube text-inverse"></i></a>
                        <a href="#"><i class="fa fa-3x fa-fw fa-instagram text-inverse"></i></a>
                        <a href="#"><i class="fa fa-3x fa-facebook fa-fw text-inverse"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>


</body></html>
