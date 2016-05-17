<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Hangman Game </title>
</head>
<body>

<h2>Hangman Single User Game</h2>
   <table>
    <tr>
        <td>Guess Word</td>
        <td>${guess_word}</td>
    </tr>
    <tr>
        <td>Max Lives</td>
        <td>${max_lives}</td>
    </tr>
    <tr>
        <td>Used Lives</td>
        <td>${used_lives}</td>
    </tr>
</table>  
</body>
</html>