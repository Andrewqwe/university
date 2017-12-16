<%--
  Created by IntelliJ IDEA.
  User: Andrzej
  Date: 2017-01-05
  Time: 03:27
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
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/pages/Panel_uzytkownika/Logo3.png" class="img-responsive"></a>
        </div>
        <form action="${pageContext.request.contextPath}/UserPanel" method="post">
        <div class="collapse navbar-collapse" id="navbar-ex-collapse">
            <ul class="nav navbar-nav navbar-right">
                <button type="submit" class="btn btn-danger" name="wylogoj">Wyloguj</button>
            </ul>
        </div>
        </form>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="page-header text-center">
                    <h2>Witaj ${sessionScope.get("loggedIn").imie}! Wybierz zajęcia na które chcesz się zapisać</h2>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <form action="${pageContext.request.contextPath}/UserPanel" method="post">
                <table class="table table-striped hidden-xs">
                    <thead>
                    <tr>
                        <th>Nazwa Zajęć</th>
                        <th>Prowadzacy</th>
                        <th>Godzina Rozpoczęcia</th>
                        <th>Godzina Zakończenia</th>
                        <th>Dzien tygodnia</th>
                        <th>Nr Sali</th>
                        <th>Ilość wolnych miejsc</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="i" items="${requestScope.lekcje}">
                        <c:set var="brak_miejsc" value="false" scope="page"/>
                        <c:set var="contains" value="false" scope="page"/>
                        <c:forEach var="j" items="${requestScope.zapisany}">
                            <c:if test="${j==i.ID}">
                                <tr style="background-color: #8cc780; ">
                                <c:set var="contains" value="true" scope="page"/>
                            </c:if>
                        </c:forEach>
                        <c:if test="${i.ilosc_miejsc==0 && pageScope.contains==false}">
                            <c:set var="brak_miejsc" value="true" scope="page"/>
                            <tr style="background-color: lightcoral">
                        </c:if>
                        <c:if test="${pageScope.contains==false && pageScope.brak_miejsc==false}"><tr style="background-color: lightskyblue"></c:if>
                            <td>${i.nazwa_zajec}</td>
                            <td>${i.prowadzacy}</td>
                            <td>${i.g_rozpoczecia}</td>
                            <td>${i.g_zakonczenia}</td>
                            <td>${i.dzien}</td>
                            <td>${i.nr_sali}</td>
                            <td>${i.ilosc_miejsc}</td>
                            <td>
                                <c:if test="${pageScope.contains==false && pageScope.brak_miejsc==false}">
                                <button name="zapis" type="submit" class="btn" value="${i.ID}" style="white-space: nowrap">Zapisz się</button>
                                </c:if>
                                <c:if test="${pageScope.contains==true}">
                                    <button name="zapis" type="submit" class="btn" value="${i.ID}" style="white-space: nowrap">Wypisz się</button>
                                </c:if>
                                <c:if test="${pageScope.contains==false && pageScope.brak_miejsc==true}">
                                    <button name="zapis" type="submit" class="btn disabled" value="${i.ID}" style="white-space: nowrap">Zapisz się</button>
                                </c:if>

                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <table class="table table-striped visible-xs pull-left" style="font-size: x-small">
                    <thead>
                    <tr>
                        <th>Nazwa Zajęć</th>
                        <th>Prowadzacy</th>
                        <th>Termin</th>
                        <th>Nr Sali</th>
                        <th>Ilość wolnych miejsc</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="i" items="${requestScope.lekcje}">
                        <c:set var="brak_miejsc" value="false" scope="page"/>
                        <c:set var="contains" value="false" scope="page"/>
                        <c:forEach var="j" items="${requestScope.zapisany}">
                            <c:if test="${j==i.ID}">
                                <tr style="background-color: #8cc780; ">
                                <c:set var="contains" value="true" scope="page"/>
                            </c:if>
                        </c:forEach>
                        <c:if test="${i.ilosc_miejsc==0 && pageScope.contains==false}">
                            <c:set var="brak_miejsc" value="true" scope="page"/>
                            <tr style="background-color: lightcoral">
                        </c:if>
                        <c:if test="${pageScope.contains==false && pageScope.brak_miejsc==false}"><tr style="background-color: lightskyblue"></c:if>
                                <td>${i.nazwa_zajec}</td>
                                <td>${i.prowadzacy}</td>
                                <td>${i.dzien} ${i.g_rozpoczecia}-${i.g_zakonczenia}</td>
                                <td>${i.nr_sali}</td>
                                <td>${i.ilosc_miejsc}</td>
                        <td>
                            <c:if test="${pageScope.contains==false && pageScope.brak_miejsc==false}">
                                <button name="zapis" type="submit" class="btn-danger" value="${i.ID}" style="white-space: nowrap; font-size: x-small">Zapisz się</button>
                            </c:if>
                            <c:if test="${pageScope.contains==true}">
                                <button name="zapis" type="submit" class="btn-danger" value="${i.ID}" style="white-space: nowrap;font-size: x-small">Wypisz się</button>
                            </c:if>
                            <c:if test="${pageScope.contains==false && pageScope.brak_miejsc==true}">
                                <button name="zapis" type="submit" class="btn disabled" value="${i.ID}" style="white-space: nowrap; font-size: x-small">Zapisz się</button>
                            </c:if>
                        </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                </form>
            </div>
        </div>
    </div>
</div>


</body></html>