<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Saisir Lecture de Glycémie</title>
</head>
<body>
    <h1>Saisir Lecture de Glycémie</h1>
    <form action="saisirLecture" method="post">
        <label for="patientId">ID du Patient:</label>
        <input type="text" id="patientId" name="patientId" required><br>

        <label for="date">Date:</label>
        <input type="date" id="date" name="date" required><br>

        <label for="heure">Heure:</label>
        <input type="time" id="heure" name="heure" required><br>

        <label for="niveauGlycemie">Niveau de Glycémie:</label>
        <input type="number" step="0.01" id="niveauGlycemie" name="niveauGlycemie" required><br>

        <button type="submit">Soumettre</button>
    </form>
</body>
</html>
    