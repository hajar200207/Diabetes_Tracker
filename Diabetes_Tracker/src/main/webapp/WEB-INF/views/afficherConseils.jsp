<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Afficher les Conseils</title>
</head>
<body>
<h1>Liste des Conseils</h1>
<c:forEach items="${conseils}" var="conseil">
    <p>ID : ${conseil.id}</p>
    <p>Description : ${conseil.description}</p>
    <p>Niveau Max : ${conseil.niveauxMax}</p>
    <p>Niveau Min : ${conseil.niveauxMin}</p>
    <img src="${conseil.photo}" alt="Photo du Conseil">
</c:forEach>
</body>
</html>
