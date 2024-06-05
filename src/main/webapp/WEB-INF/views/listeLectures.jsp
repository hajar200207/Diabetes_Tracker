
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
</head>
<body>
<canvas id="myChart" width="400" height="400"></canvas>
    <h1>Liste des lectures de glycémie</h1>

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
    var glycemies = ${glycemiesJson}; // Supposons que glycemiesJson contient les données au format JSON

    var dates = [];
    var niveauxGlycemie = [];

    glycemies.forEach(function(glycemie) {
        dates.push(glycemie.date);
        niveauxGlycemie.push(glycemie.niveauGlycemie);
    });

    var ctx = document.getElementById('myChart').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: dates,
            datasets: [{
                label: 'Niveau de glycémie',
                data: niveauxGlycemie,
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                borderColor: 'rgba(255, 99, 132, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });
</script>
    
</body>
</html>

    