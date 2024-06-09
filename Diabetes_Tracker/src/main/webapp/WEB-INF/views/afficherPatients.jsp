<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Patients</title>
</head>
<body>
    <h1>Liste des Patients</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Age</th>
            <th>Taille</th>
            <th>Poids</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="patient" items="${patients}">
            <tr>
                <td>${patient.id}</td>
                <td>${patient.nom}</td>
                <td>${patient.age}</td>
                <td>${patient.taille}</td>
                <td>${patient.poids}</td>
                <td>
                    <a href="/Diabetes_Tracker/patients/${patient.id}">Voir</a>
                    <a href="/Diabetes_Tracker/patients/modifier/${patient.id}">Modifier</a>
                    <a href="/Diabetes_Tracker/patients/supprimer/${patient.id}">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
