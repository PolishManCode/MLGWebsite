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
                <a href="#" class="navbar-left"><img src='pictures/logo.png'
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
                        <li><a href="MLGServlet?param=recruit">Recruits</a></li>
                    </li>
                    <li>
                       <li><a href="MLGServlet?param=recruitment">Recruiting</a></li>
                    </li>
                    <li>
                        <li><a href="MLGServlet?param=profile">Profile</a></li>
                    </li>
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
                    <h2 class="intro-text text-center">
                        <strong>Profile</strong>
                    </h2>
                    <hr>
                </div>
                <div class="col-md-8">
					<img class="img-responsive" src="http://placehold.it/750x450" alt="">
                </div>
                <div class="col-md-4">
                    <p>Name:
                        <strong> ${fName}!</strong>
                    </p>
                    <p>Last Name:
                        <strong>${lName}!</strong>
                    </p>
                    <p>User Name:
                        <strong>${user}!</strong>
                    </p>
                    <p>Game:
                        <strong>${game}!</strong>
                    </p>
                    <p>Password:
                        <strong>${password}!</strong>
                    </p>
                    <a href="#" class="btn btn-default btn-lg">Add Photo</a>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">Edit
                        <strong>personal information</strong>
                    </h2>
                    <hr>
                    <p>Change your information.</p>
                    <form role="form">
                        <div class="row">
                            <div class="form-group col-lg-4">
                                <label>Name</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-lg-4">
                                <label>Last Name</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-lg-4">
                                <label>User Name</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="clearfix"></div>
                            <div class="form-group col-lg-4">
                                <label>Game</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-lg-4">
                                <label>Password</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-lg-4">
                                <label>Re-type Password</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-lg-12">
                                <input type="hidden" name="save" value="contact">
                                <button type="submit" class="btn btn-default">Submit</button>
                            </div>
                        </div>
                    </form>
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
