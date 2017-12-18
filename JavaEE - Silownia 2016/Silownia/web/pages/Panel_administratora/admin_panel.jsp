<%--
  Created by IntelliJ IDEA.
  User: Andrzej
  Date: 2017-01-07
  Time: 04:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/pages/Panel_uzytkownika/user_panel.css" rel="stylesheet" type="text/css">
</head><body>
<div class="navbar navbar-default navbar-static-top">
    <div class="container-fluid">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/pages/Panel_uzytkownika/Logo3.png" class="img-responsive"></a>
        <form action="${pageContext.request.contextPath}/UserPanel" method="post">
            <div class="collapse navbar-collapse" id="navbar-ex-collapse">
                <ol class="nav navbar-nav">
                    <li><a class="btn btn-danger" href="?button=1" role="button">Wyloguj</a></li>
                    <li><a class="btn btn-danger" href="?button=2" role="button">Użytkownicy</a></li>
                    <li><a class="btn btn-danger" href="?button=3" role="button">Zajęcia</a></li>
                    <li><a class="btn btn-danger" href="?button=4" role="button">Trenerzy</a></li>
                    <li><a class="btn btn-danger" href="?button=5" role="button">Pomieszczenia</a></li>
                </ol>
            </div>
        </form>
    </div>
</div>

<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <form action="${pageContext.request.contextPath}/AdminPanel" method="post">
                    <c:if test="${param.button==2}">
                        <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Imie</th>
                            <th>Nazwisko</th>
                            <th>Wiek</th>
                            <th>Typ Karnetu</th>
                            <th>Data wygaśnięcia karnetu</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${sessionScope.wyswietl}">
                            <tr>
                                <td>${i.imie}</td>
                                <td>${i.nazwisko}</td>
                                <td>${i.wiek}</td>
                                <td>${i.typ_karnetu}</td>
                                <td>${i.data}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                        </table>
                    </c:if>

                    <c:if test="${param.button==3}">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>Nazwa zajęć</th>
                                <th>Trener</th>
                                <th>Dzień tygodnia</th>
                                <th>Godzina rozpoczęcia</th>
                                <th>Godzina zakończenia</th>
                                <th>Nr Sali</th>
                                <th>Typ zajęć</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="i" items="${sessionScope.wyswietl}">
                                <tr>
                                    <td>${i.nazwa_zajec}</td>
                                    <td>${i.prowadzacy}</td>
                                    <td>${i.dzien}</td>
                                    <td>${i.g_rozpoczecia}</td>
                                    <td>${i.g_zakonczenia}</td>
                                    <td>${i.nr_sali}</td>
                                    <td>${i.dla_kogo}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>

                    <c:if test="${param.button==4}">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Imie</th>
                            <th>Nazwisko</th>
                            <th>Pensja</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${sessionScope.wyswietl}">
                            <tr>
                                <td>${i.imie}</td>
                                <td>${i.nazwisko}</td>
                                <td>${i.pensja}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </c:if>

                    <c:if test="${param.button==5}">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>Imie</th>
                                <th>Nazwisko</th>
                                <th>Pensja</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="i" items="${sessionScope.wyswietl}">
                                <tr>
                                    <td>${i.ID}</td>
                                    <td>${i.liczba_miejsc}</td>
                                    <td>${i.typ}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                    </c:if>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>