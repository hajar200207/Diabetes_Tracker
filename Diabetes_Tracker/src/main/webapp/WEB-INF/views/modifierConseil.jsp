<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier un Conseil</title>
</head>
<body>
<h1>Modifier le Conseil ${conseil.id}</h1>
<form action="/conseils/modifier/${conseil.id}" method="post">
    Description : <input type="text" name="description" value="${conseil.description}"><br>
    Niveau Max : <input type="text" name="niveauxMax" value="${conseil.niveauxMax}"><br>
    Niveau Min : <input type="text" name="niveauxMin" value="${conseil.niveauxMin}"><br>
    Photo : <input type="text" name="photo" value="${conseil.photo}"><br>
    <input type="submit" value="Modifier">
</form>
</body>
</html>
