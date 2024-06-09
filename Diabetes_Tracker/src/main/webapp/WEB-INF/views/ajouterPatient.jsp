<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter Patient</title>
</head>
<body>
    <h1>Ajouter Patient</h1>
    <form action="${pageContext.request.contextPath}/ajouterPatient" method="post">
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" required><br>
        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br>
        <label for="taille">Taille (cm):</label>
        <input type="number" id="taille" name="taille" required><br>
        <label for="poids">Poids (kg):</label>
        <input type="number" id="poids" name="poids" required><br>
        <input type="submit" value="Ajouter">
    </form>
    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>
</body>
</html>
