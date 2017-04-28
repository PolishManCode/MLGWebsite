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
                    <h2 class="intro-text text-center">The Games
                        <strong>we sponsor</strong>
                    </h2>
                    <hr>
                </div>
                <div class="col-md-6">
                    <img class="img-responsive img-border-left" src="img/esports.jpg" alt="">
                </div>
                <div class="col-md-6">
                    <p>Here are the games that we sponsor for MLG recruitment.</p>
                    <p>If you want to see the the top videos for a certain game, just click on the picture.</p>
                    <p>Logged in users can vote on these videos as well.</p>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        
        <#if guest>
        <div class="row">
            <div class="box">
           <div class="col-lg-12">
           <hr>
           <h2 class="intro-text text-center">Post
                 <strong>a video: </strong>
           </h2>
            <hr>
            
            
            <form role="form" action="MLGServlet?param=addLink" method="post">
                        <div class="row">
                            <div class="form-group col-lg-4">
                                <label>Link (make sure it is an embeded one, not a view link)</label>
                                <input type="text" class="form-control" name="link">
                            </div>
                            
                            <div class="clearfix"></div>
                            <div class="form-group col-lg-4">
                                <label>Game</label>
                                <select name="linkGame" class="form-control">
    								<option class="gameOption" value="Dota 2">Dota 2</option>
    								<option class="gameOption" value="World of Warcraft">World of Warcraft</option>
   									<option class="gameOption" value="CSGO">Counter Strike: Global Offensive</option>
    								<option class="gameOption" value="League of Legends">League of Legends</option>
    								<option class="gameOption" value="Smite">Smite</option>
    								<option class="gameOption" value="Halo5">Halo 5</option>
    								<option class="gameOption" value="Call of Duty, Black Ops3">Call of Duty: Black Ops 3</option>
    								<option class="gameOption" value="Hearthstone, Heroes of Warcraft">Hearthstone Heroes of Warcraft</option>
    								<option class="gameOption" value="Starcraft II">Starcraft II</option>
    								<option class="gameOption" value="Heroes of the Storm">Heroes of the Storm</option>
    								<option class="gameOption" value="Call of Duty, Advanced Warfare">Call of Duty: Advanced Warfare</option>
    								<option class="gameOption" value="Overwatch">Overwatch</option>
    								<option class="gameOption" value="Gears of War 4">Gears of War 4</option>
  								</select>
                            </div>
            
            			<div class="form-group col-lg-12">
                             
                                <button type="submit" class="btn btn-default" name="sButton">Submit</button>
                            </div>
                   
                        </div>
                    </form>
                    </div>
                    </div>
            
           </div>
        </#if>

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">The
                        <strong>Games</strong>
                    </h2>
                    <hr>
                </div>
                <div class="col-sm-4 text-center">
                	<a href="MLGServlet?param=worldofwarcraft">
                    <img class="img-responsive" src="img/wow.jpg" width= "750" height= "450" alt="Go to World of Warcraft">
                    </a>
                    <h3>World <br/> of <br/> Warcraft
                    </h3>
         		 </div>
                <div class="col-sm-4 text-center">
                	<a href="MLGServlet?param=csgo">
                    <img class="img-responsive" src="img/csgo.png" width= "750" height= "450" alt="Go to Counter Strike">
                    </a>
                    <h3>Counter Strike: Global Offensive
                    </h3>
                </div>
                <div class="col-sm-4 text-center">
                	<a href="MLGServlet?param=leagueoflegends">
                    <img class="img-responsive" src="img/lol.jpg" width= "750" height= "450" alt="Go to League of Legends">
                    </a>
                    <h3>League<br/> Of<br/> Legends
                    </h3>
                </div>
                <div class="clearfix"></div>
                <div class="col-sm-4 text-center">
                	<a href="MLGServlet?param=smite">
                    <img class="img-responsive" src="img/smite.png" width= "750" height= "450" alt="Go to Smite">
                    </a>
                	<h3>Smite
                    </h3>
                </div>
                <div class="col-sm-4 text-center">
                	<a href="MLGServlet?param=halo5">
                    <img class="img-responsive" src="img/halo5.jpeg" width= "750" height= "450" alt="Go to Halo 5">
                    </a>
                    <h3>Halo 5
                    </h3>
                </div>
                <div class="col-sm-4 text-center">
                	<a href="MLGServlet?param=callofdutybo3">
                    <img class="img-responsive" src="img/BO3.jpg" width= "750" height= "450" alt="Go to Call of Duty: Black Ops 3">
                    </a>
                    <h3>Call of Duty: Black Ops 3
                    </h3>
                </div>
                <div class="clearfix"></div>
                <div class="col-sm-4 text-center">
                	<a href="MLGServlet?param=hearthstone">
                    <img class="img-responsive" src="img/hearthstone.jpeg" width= "750" height= "450" alt="Go to Hearthstone">
                    </a>
                    <h3>Hearthstone Heroes of Warcraft
                    </h3>
                </div>
                <div class="col-sm-4 text-center">
                	<a href="MLGServlet?param=starcraft">
                    <img class="img-responsive" src="img/starcraft2.jpg" width= "750" height= "450" alt="Go to Starcraft">
                    </a>
                    <h3>Starcraft II
                    </h3>
                </div>
                <div class="col-sm-4 text-center">
                	<a href="MLGServlet?param=heroesofthestorm">
                    <img class="img-responsive" src="img/hots.jpg" width= "750" height= "450" alt="Go to Heroes of the Storm">
                    </a>
                    <h3>Heroes of the Storm
                    </h3>
                </div>
                <div class="clearfix"></div>
                <div class="col-sm-4 text-center">
                	<a href="MLGServlet?param=callofdutyaw">
                    <img class="img-responsive" src="img/advancedwarfare.png" width= "750" height= "450" alt="Go to Call of Duty: Advanced Warfare">
                    </a>
                    <h3>Call of Duty: Advanced Warfare
                    </h3>
                </div>
                <div class="col-sm-4 text-center">
                	<a href="MLGServlet?param=overwatch">
                    <img class="img-responsive" src="img/overwatch.jpg" width= "750" height= "450" alt="Go to Overwatch">
                    </a>
                    <h3>Overwatch
                    </h3>
                </div>
                <div class="col-sm-4 text-center">
                	<a href="MLGServlet?param=gearsofwar4">
                    <img class="img-responsive" src="img/gow.jpeg" width= "750" height= "450" alt="Go to Gears of War 4">
                    </a>
                    <h3>Gears of War 4
                    </h3>
                </div>
                <div class="clearfix"></div>
                 <div class="col-sm-4 text-center">
                	<a href="MLGServlet?param=dota2">
                    <img class="img-responsive" src="img/dota.jpg" width= "750" height= "450" alt="Go to Dota 2">
                    </a>
                    <h3>Dota 2
                    </h3>
                </div>
            <div class="clearfix"></div>
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
