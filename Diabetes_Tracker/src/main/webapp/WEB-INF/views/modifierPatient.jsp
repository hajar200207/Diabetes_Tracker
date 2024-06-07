<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Modifier Informations Personnelles</title>
</head>
<body>
    <h1>Modifier Informations Personnelles</h1>
    <form action="modifierPatient" method="post">
        <label for="patientId">ID du Patient:</label>
        <input type="text" id="patientId" name="patientId" required><br>

        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" required><br>

        <label for="age">Âge:</label>
        <input type="number" id="age" name="age" required><br>

        <label for="taille">Taille (cm):</label>
        <input type="number" id="taille" name="taille" required><br>

        <label for="poids">Poids (kg):</label>
        <input type="number" id="poids" name="poids" required><br>

        <button type="submit">Soumettre</button>
    </form>
</body>
</html>
