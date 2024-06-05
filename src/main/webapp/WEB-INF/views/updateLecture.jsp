<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mettre � jour une lecture de glyc�mie</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>">
</head>
<body>
    <h1>Mettre � jour une lecture de glyc�mie</h1>

<form action="<c:url value='/updateLecture'/>" method="post">
        <input type="hidden" name="id" value="${glycemie.id}">
        <p>
            <label for="date">Date:</label>
            <input type="date" id="date" name="date" value="${glycemie.date}" required>
        </p>
        <p>
            <label for="heure">Heure:</label>
            <input type="time" id="heure" name="heure" value="${glycemie.heure}" required>
        </p>
        <p>
            <label for="niveauGlycemie">Niveau de glyc�mie:</label>
            <input type="number" step="0.01" id="niveauGlycemie" name="niveauGlycemie" value="${glycemie.niveauGlycemie}" required>
        </p>
        <p>
            <input type="submit" value="Mettre � jour">
        </p>
    </form>

    <p><a href="<c:url value='/list'/>">Retour � la liste</a></p>
</body>
</html>
    