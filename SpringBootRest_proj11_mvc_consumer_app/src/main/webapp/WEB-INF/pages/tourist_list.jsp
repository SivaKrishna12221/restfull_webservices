<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 style="color: green; text-align: align">Tourist report</h1>
<c:choose>
	<c:when test="${!empty touristList }">

		<table align="center">
			<tr>
				<td>tid</td>
				<td>name</td>
				<td>place</td>
				<td>touristBudget</td>
				<td>budget</td>
				<td>status</td>
				<td>Edit</td>
				<td>Delete</td>
			</tr>
			<c:forEach var="tourist" items="${touristList }">
				<tr>
					<td>${tourist.tid}</td>
					<td>${tourist.name}</td>
					<td>${tourist.place}</td>
					<td>${tourist.touristPackage}</td>
					<td>${tourist.budget}</td>
					<td>${tourist.status }</td>
					<td><a href="edit_tourist?tid=${tourist.tid }">Edit</a></td>
					<td><a href="delete_tourist?tid=${tourist.tid }">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<blink>
			<h1 style="color: green; text-align: center">${msg }</h1>
		</blink>
	</c:otherwise>
</c:choose>
<h1 style="color: green; text-align: center;">
	<a href="add_new_tourist"> Add new Student</a>
</h1>
</html>