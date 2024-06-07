<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Afficher les lectures de glyc�mie</title>
</head>
<body>
    <h1>Lectures de glyc�mie pour le patient</h1>
    <table>
        <tr>
            <th>Date</th>
            <th>Heure</th>
            <th>Niveau de glyc�mie</th>
        </tr>
        <!-- Boucle sur les lectures de glyc�mie -->
        <th:each var="lecture" items="${lectures}">
            <tr>
                <td>${lecture.date}</td>
                <td>${lecture.heure}</td>
                <td>${lecture.niveauGlycemie}</td>
            </tr>
        </th:each>
    </table>
</body>
</html>
    