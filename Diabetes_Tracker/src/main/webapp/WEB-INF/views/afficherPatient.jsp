<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Détails du Patient</title>
</head>
<body>
    <h1>Détails du Patient</h1>
    <p>ID: ${patient.id}</p>
    <p>Nom: ${patient.nom}</p>
    <p>Age: ${patient.age}</p>
    <p>Taille: ${patient.taille}</p>
    <p>Poids: ${patient.poids}</p>
    <a href="/Diabetes_Tracker/patients">Retour à la liste</a>
</body>
</html>
