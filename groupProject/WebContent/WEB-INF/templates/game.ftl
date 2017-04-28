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
                <div class="col-lg-12 text-center">
                    
                    <h2 class="brand-before">
                        <small>Welcome to</small>
                    </h2>
                    <h1 class="brand-name">Recruit Gaming</h1>
                    <hr class="tagline-divider">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">Here are the  
                        <strong>World of Warcraft videos</strong>
                    </h2>
                    
            </div>
        </div>
   
        <div class="box"><h2>Top Videos for ${gameName}</h2></div>
        <#if topList?size != 0>
            <#assign i = 1>
            <#list topList as topRow>
                <div class="row">
                    <div class="box">
                        <div class="col-sm-12">
                            <div class="row">
                                <div class="col-sm-6">
                                    <h2>#${i} by ${topRow.playerName} (${topRow.voteCount} votes)</h2>
                                </div>

                                <div class="col-sm-6">
                                    <a href="MLGServlet?param=vote&videoID=${topRow.linkID}&like=1" class="btn btn-default btn-lg">Like</a>
                                    <a href="MLGServlet?param=vote&videoID=${topRow.linkID}&like=0" class="btn btn-default btn-lg">Dislike</a>
                                </div>
                            </div>

                            <div class="row">
                                <div class="embed-responsive embed-responsive-16by9" >
                                <iframe class="embed-responsive-item"  src="${topRow.link}"></iframe>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                </div>    
            <#assign i++>
            </#list>            
       <#else>
       <div class="box"><h5>No videos yet</h5></div>
       </#if>

    </div>
    <!-- /.container -->

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright &copy; Recruit Gaming 2017</p>
                </div>
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>

</body>

</html>