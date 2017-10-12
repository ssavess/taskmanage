<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
    
    <title>Task Manager | Home</title>
    
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
     <link href="static/css/style.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Booking</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-task">Contacts</a></li>
					<li><a href="new-task">Activity</a></li>
					<li><a href="all-contacts">All Contacts</a></li>
					<li><a href="all-activity">All Activity</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
		<c:when test="${mode == 'MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to Task Manager</h1>
				</div>
			</div>
		</c:when>
		
		
		<c:when test="${mode == 'MODE_CONTACTS'}">
			<div class="container text-center" id="tasksDiv">
				<h3>My Contacts</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Email</th>
								<th>FirstName</th>
								<th>LastName</th>
								<th>PhoneNumber</th>
								<th>Adress1</th>
								<th>Adress2</th>
								<th>City</th>
								<th>PostCode</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="contact" items="${contacts}">
								<tr>
									<td><c:out value="${contact.emailAddress}"/></td>
									<td><c:out value="${contact.firstName}"/></td>
									<td><c:out value="${contact.lastName}"/></td>
									<td><c:out value="${contact.telephoneNumber}"/></td>
									<td><c:out value="${contact.address1}"/></td>
									<td><c:out value="${contact.address2}"/></td>
									<td><c:out value="${contact.city}"/></td>
									<td>${contact.postCode}</td>
									<td><a href="edit-contact?email=${contact.emailAddress}"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="remove-contact?email=${contact.emailAddress}"><span class="glyphicon glyphicon-trash"></span></a></td>
									
									
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode == 'MODE_ACTIVITY'}">
			<div class="container text-center" id="tasksDiv">
				<h3>My Contacts</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Title</th>
								<th>Notas</th>
								<th>Date</th>
								<th>Contact</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="activity" items="${activitys}">
								<tr>
									<td><c:out value="${activity.title}"/></td>
								
									
									<td>${activity.contact}</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		
		
		
		
		
		<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manage Task</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-task">
					<input type="hidden" name="id" value="${task.id}"/>
					<div class="form-group">
						<label class="control-label col-md-3">Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="name" value="${task.name}"/>
						</div>				
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Description</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="description" value="${task.description}"/>
						</div>				
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Finished</label>
						<div class="col-md-7">
							<input type="radio" class="col-sm-1" name="finished" value="true"/>
							<div class="col-sm-1">Yes</div>
							<input type="radio" class="col-sm-1" name="finished" value="false" checked/>
							<div class="col-sm-1">No</div>
						</div>				
					</div>		
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save"/>
					</div>
				</form>
			</div>
		</c:when>		
	</c:choose>

	<script src="static/js/jquery-1.11.1.min.js"></script>    
    <script src="static/js/bootstrap.min.js"></script>
</body>
</html>