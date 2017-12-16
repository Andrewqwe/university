<%--
  Created by IntelliJ IDEA.
  User: Andrzej
  Date: 2016-12-21
  Time: 00:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/pages/Glowna/main_page.css" rel="stylesheet" type="text/css">
</head><body>
<div class="cover">
    <div class="navbar navbar-default">
        <div class="container" style="padding-left:25px; padding-top: 30px">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="#" id="Logo_Silowni"><img src="${pageContext.request.contextPath}/pages/Glowna/logo.png" class="img-responsive"></a>
            </div>
            <div class="collapse navbar-collapse" id="navbar-ex-collapse">
                <ul class="lead nav navbar-nav navbar-right">
                    <li id="register_button">
                        <input type="hidden"/>
                        <a href="/rejestracja"><b>Rejestracja</b></a>
                    </li>
                    <li id="login_button">
                        <input type="hidden"/>
                        <a href="/logowanie"><b>Logowanie</b></a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <div class="background-image-fixed cover-image hidden-xs" style="background-image : url('${pageContext.request.contextPath}/pages/Glowna/gym_background.jpg')"></div>
    <div class="background-image cover-image resi hidden-lg hidden-md hidden-sm"  style="background-image : url('${pageContext.request.contextPath}/pages/Glowna/gym_background2.jpg')"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center visible-xs-inline"><h1></h1></div>
            <div class="col-md-12 text-center visible-xs-inline"><h1></h1></div>
            <div class="col-md-12 text-center visible-xs-inline"><h1></h1></div><!--przesuwanie nizej tytulu by nie przeszkadzal menu-->
            <div class="col-md-12 text-center visible-xs-inline">
                <h1 class="text-center text-danger">
                    your body. your choice.</h1>
                <p></p>
                <br>
                <br>
            </div>
            <div class="col-md-12 text-center hidden-xs">
                <h1 class="text-center text-danger">your body. your choice.</h1>
                <p></p>
                <br>
                <br>
            </div>
        </div>
    </div>
</div>

<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1 class="text-center"><b>Nasza oferta</b></h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <a id="gym_adv1"><img src="${pageContext.request.contextPath}/pages/Glowna/gym_adv1.jpg" class="img-responsive"></a>
                <h3>Najlepsza siłownia w mieście</h3>
                <p>Dysponujemy profesjonalnym sprzętem najwyższej klasy ponieważ najwazniejsze
                    jest dla nas twoje bezpieczeństwo</p>
            </div>
            <div class="col-md-4">
                <a id="gym_adv2"><img src="${pageContext.request.contextPath}/pages/Glowna/gym_adv2.jpg" class="img-responsive"></a>
                <h3>Trening personalny</h3>
                <p>Posiadamy świetnie wyszkoloną kadrę sportowców, trenerów oraz dietetyków</p>
            </div>
            <div class="col-md-4">
                <a id="gym_adv3"><img src="${pageContext.request.contextPath}/pages/Glowna/gym_adv3.jpg" class="img-responsive"></a>
                <h3>Zajecia grupowe</h3>
                <p>Oferujemy szeroką gamę grupowych zajęć fitness zarówno dla osób poczatkujacych
                    jak i doświadczonych</p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <a id="gym_adv4"><img src="${pageContext.request.contextPath}/pages/Glowna/gym_adv4.jpg" class="img-responsive"></a>
                <h3>Spa &amp;&nbsp;Wellness</h3>
                <p>Szeroka gama zabiegów oraz sauny i łaźnie pozwolą ci się zrelaksować</p>
            </div>
            <div class="col-md-4">
                <a id="gym_adv5"><img src="${pageContext.request.contextPath}/pages/Glowna/gym_adv5.jpg" class="img-responsive"></a>
                <h3>Tanita</h3>
                <p>W naszych klubach oferujemy profesjonalną analizę składu ciała z pomocą
                    technologii Tanita</p>
            </div>
            <div class="col-md-4">
                <a id="gym_adv6"><img src="${pageContext.request.contextPath}/pages/Glowna/gym_adv6.jpg" class="img-responsive"></a>
                <h3>Strefa dziecięca</h3>
                <p>W naszym klubie znajduje się strefa dla najmłodszych w której dzieci na
                    pewno nie będą się nudzić</p>
            </div>
        </div>
    </div>
</div>
<div class="section"> <div class="container"> <div class="row"><div class="col-md-12"><h1 class="text-center"><b>Honorujemy karty</b></h1></div></div><div class="row"> <div class="col-md-4"> <img src="${pageContext.request.contextPath}/pages/Glowna/gym_karta1.jpg" class="center-block img-responsive img-thumbnail"> <h2 class="text-center">MultiSport</h2> </div><div class="col-md-4"> <img src="${pageContext.request.contextPath}/pages/Glowna/gym_karta2.jpg" class="center-block img-responsive img-thumbnail"> <h2 class="text-center">BeActive</h2> </div><div class="col-md-4"> <img src="${pageContext.request.contextPath}/pages/Glowna/gym_karta3.jpg" class="center-block img-responsive img-thumbnail"> <h2 class="text-center">MyLife</h2> </div></div></div></div><footer class="section section-danger">
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