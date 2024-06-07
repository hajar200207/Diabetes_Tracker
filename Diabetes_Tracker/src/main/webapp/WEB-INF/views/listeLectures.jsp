<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des lectures de glycémie</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>">
    <style>
        .chart-container {
            width: 100%;
            max-width: 600px;
            margin: auto;
            height: 500px;
        }
    </style>
</head>
<body>
    <div class="chart-container">
        <canvas id="myChart"></canvas>
    </div>
    <h1>Liste des lectures de glycémie</h1>

    <!-- Section de débogage pour afficher les données JSON -->
    <pre>${glycemiesJson}</pre>

    <c:if test="${not empty glycemies}">
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>ID du patient</th>
                    <th>Date</th>
                    <th>Heure</th>
                    <th>Niveau de glycémie</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="glycemie" items="${glycemies}">
                    <tr>
                        <td>${glycemie.id}</td>
                        <td>${glycemie.patient.id}</td>
                        <td>${glycemie.date}</td>
                        <td>${glycemie.heure}</td>
                        <td>${glycemie.niveauGlycemie}</td>
                        <td>
                            <form action="<c:url value='/supprimerLecture'/>" method="post">
                                <input type="hidden" name="id" value="${glycemie.id}">
                                <input type="submit" value="Supprimer">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty glycemies}">
        <p>Aucune lecture de glycémie trouvée.</p>
    </c:if>

    <p><a href="<c:url value='/'/>">Retour à l'accueil</a></p>
    
    <script>
        var labels = [];
        var dataValues = [];
        
        <c:forEach var="glycemie" items="${glycemies}">
            labels.push("${glycemie.date} ${glycemie.heure}");
            dataValues.push(${glycemie.niveauGlycemie});
        </c:forEach>
        
        const data = {
            labels: labels,
            datasets: [{
                label: 'Niveau de glycémie',
                data: dataValues,
                fill: false,
                borderColor: 'rgb(75, 192, 192)',
                tension: 0.1
            }]
        };
        
        const config = {
            type: 'line',
            data: data,
        };
        
        var myChart = new Chart(
            document.getElementById('myChart'),
            config
        );
    </script>
</body>
</html>