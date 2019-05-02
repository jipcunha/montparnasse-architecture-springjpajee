<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css" />
<title>Formulaire</title>
</head>
<body>
	<div>
		<section class="container">
			<h1>Inscription</h1>
			<div>
				<form action="ServletPers">
				
					<input type="hidden" name="id" value="${id}" />
				
					<div class="form-group">
						<label for="surname">Nom</label> <input id="nom"
							class="form-control" type="text" name="nom" value="${nom}"  required />
					</div>
					<div class="form-group">
						<label for="name">Prenom</label> <input id="prenom"
							class="form-control" type="text" name="prenom" value="${prenom}" required />
					</div>
					<div class="form-group">
						<label for="age">Age</label> <input id="age" class="form-control"
							type="number" name="age" value="${age}" required />
					</div>
					
					<div>
						<button type="submit" class="btn btn-primary" name="ajouter">Ajouter</button>
						<button type="submit" class="btn btn-primary" name="modifier">Modifier</button>
					</div>					
					
				</form>
			</div>
		</section>
	</div>
	<br>
	
	<div>
		<section class="container">
		<h2>Liste des personnes dans la BDD</h2>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<td>ID</td>
					<td>Nom</td>
					<td>Prenom</td>
					<td>Age</td>
					<th>Supprimer</th>
					<th>Modifier</th>
				</tr>
			</thead>

			<tbody>
			
				<c:if test="${!empty personnes}">
					<c:forEach items="${personnes}" var="x"> 
					<tr>
						<td><c:out value="${x.idPersonne}" /> </td> <!--idPersonne, nom, prenom et age sont les attrubuts de la classe Personne-->
						<td><c:out value="${x.nom}" /> </td>
						<td><c:out value="${x.prenom}" /> </td>
						<td><c:out value="${x.age}" /> </td>
						<td><a href="SupprimerPers?idPers=${x.idPersonne}">Supprimer</a> </td>
						<td><a href="ModifierPers?idPers=${x.idPersonne}">Modifier</a> </td>	
								
					</tr>
					</c:forEach>
				</c:if>

			</tbody>
		</table>
		</section>
	</div>

</body>
</html>