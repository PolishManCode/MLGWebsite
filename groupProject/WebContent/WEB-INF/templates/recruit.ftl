<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Recruit Gaming</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/recruit-gaming.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">


</head>

<body>
	   

    <!-- Navigation -->
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="MLGServlet?param=home" class="navbar-left"><img src='pictures/logo.png'
			alt='Recruit Gaming Home' style='width: 100px; height: 54px;'></a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                	<li>
                        <a href="MLGServlet?param=home" class="navbar-left"><img src='pictures/logo.png'
			alt='Recruit Gaming Home' style='width: 172px; height: 92px;'></a>
                    </li>
                    <li>
                        <a href="MLGServlet?param=home">Home</a>
                    </li>
                    <li>
                        <a href="MLGServlet?param=games">Games</a>
                    </li>
                    <li>
                        <li><a href="MLGServlet?param=recruitment">Recruitment</a></li>
                    </li>
                    <#if guest>
                    <li>
                        <li><a href="MLGServlet?param=profile">Profile</a></li>
                    </li>
                    </#if>
                    <#if guest>
                    <li class="right">
                        <li><a href=MLGServlet?param=logOutIn class ="logIn">LogOut</a></li>
                    </li>
                    </#if>
                    
                    <#if guest = false>
                    <li class="right">
                        <li><a href=MLGServlet?param=logOutIn class ="logIn">LogIn</a></li>
                    </li>
                    </#if>
                    
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

   <div class="container">

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">The Recruits 
                        <strong>Page</strong>
                    </h2>
                    <hr>
                </div>
                <div class="col-lg-12 text-center">
                    <img class="img-responsive img-border img-full" src="img/dota.png" alt="">
                    <h2>Dota 2
                        <br>
                        <small>Current Recruits</small>
                    </h2>
                    
                <table class="table">
                    <thead>
                        <tr>
                        <th>User name</th>
                        <th>Name</th>
                        <th>Contact information</th>
                        </tr>
                    </thead>
                    <tbody>
                        <#list list1 as listItem>
                            <tr>
                                <td>${listItem.userName}</td>
                                <td>${listItem.fname} ${listItem.lname}</td>
                                <td>${listItem.email}</td>
                                <td><a href="mailto:${listItem.email}" class="btn btn-default btn-lg">Send email</a></td>
                            </tr>
                        </#list>
                    </tbody>
                </table>

                    <hr>
                </div>
                <div class="col-lg-12 text-center">
                    <img class="img-responsive img-border img-full" src="img/csgo.png" alt="">
                    <h2>Counter Strike
                        <br>
                        <small>Current Recruits</small>
                    </h2>
                <table class="table">
                    <thead>
                        <tr>
                        <th>User name</th>
                        <th>Name</th>
                        <th>Contact information</th>
                        </tr>
                    </thead>
                    <tbody>
                        <#list list2 as listItem>
                            <tr>
                                <td>${listItem.userName}</td>
                                <td>${listItem.fname} ${listItem.lname}</td>
                                <td>${listItem.email}</td>
                                <td><a href="mailto:${listItem.email}" class="btn btn-default btn-lg">Send email</a></td>
                            </tr>
                        </#list>
                    </tbody>
                </table>
                    <hr>
                </div>
                <div class="col-lg-12 text-center">
                    <img class="img-responsive img-border img-full" src="img/slide-3.jpg" alt="">
                    <h2>League Of Legends
                        <br>
                        <small>Current Recruits</small>
                    </h2>
                                    <table class="table">
                    <thead>
                        <tr>
                        <th>User name</th>
                        <th>Name</th>
                        <th>Contact information</th>
                        </tr>
                    </thead>
                    <tbody>
                        <#list list3 as listItem>
                            <tr>
                                <td>${listItem.userName}</td>
                                <td>${listItem.fname} ${listItem.lname}</td>
                                <td>${listItem.email}</td>
                                <td><a href="mailto:${listItem.email}" class="btn btn-default btn-lg">Send email</a></td>
                            </tr>
                        </#list>
                    </tbody>
                </table>
                    <hr>
                <div class="col-lg-12 text-center">
                    <ul class="pager">
                        <li class="previous"><a href="#">&larr; Older</a>
                        </li>
                        <li class="next"><a href="#">Newer &rarr;</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

    </div>
    <!-- /.container -->

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright &copy; Recruit Gaming 2014</p>
                </div>
            </div>
        </div>
    </footer>

    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
