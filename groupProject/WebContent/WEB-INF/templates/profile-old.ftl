<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>Home</title>
<link rel='stylesheet' type='text/css' href='css/home.css'>
</head>
<body>
	<div id='homelogo'>
		<a href="MLGServlet?param=home"> <img src='pictures/logo.png'
			alt='Recruit Gaming Home' style='width: 172px; height: 92px;'>
		</a>
	</div>
	<ul>
		<li><a href="MLGServlet?param=home">Home</a></li>
		<li><a href="MLGServlet?param=games">Games</a></li>
		<li><a href="MLGServlet?param=recruit">Recruits</a></li>
		<li><a href="MLGServlet?param=recruitment">Recruiting</a></li>
		<li><a href="MLGServlet?param=profile">Profile</a></li>
	</ul>
	<div id='login'>
		<a href="login.html">Log in</a>
	</div>
	<div class="profile">
	<h1>Hello ${user}!</h1>
	</div>
</body>
</html>

