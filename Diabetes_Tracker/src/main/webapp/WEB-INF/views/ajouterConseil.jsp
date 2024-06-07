<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un Conseil</title>
</head>
<body>
<h1>Ajouter un Nouveau Conseil</h1>
<form action="/conseils/ajouter" method="post">
    Description : <input type="text" name="description"><br>
    Niveau Max : <input type="text" name="niveauxMax"><br>
    Niveau Min : <input type="text" name="niveauxMin"><br>
    Photo : <input type="text" name="photo"><br>
    <input type="submit" value="Ajouter">
</form>
</body>
</html>
