<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <br>
    <br>
    <form method="POST" action="/result">
    <label for="name">Nombre:</label>
    <input type="text" name="name">
    <br>
    <br>
    <label for="favorite_language">Lenguaje Favorito</label>
    <select name="favorite_language">
        <option value="Javascript">Javascript</option>
        <option value="Java">Java</option>
        <option value="Python">Python</option>
    </select>
    <br>
    <br>
    <label for="location">Dojo Location</label>
    <select name="location">
        <option value="San Jose">San jose</option>
        <option value="Los Angeles">Los Angeles</option>
        <option value="California">California</option>
    </select>
    <br>
    <br>
    <label for="comment">Comentarios(opcional)</label>
    <br>
    <textarea name="comment" id="descripcion" cols="30" rows="10"></textarea>
    <br>
    <button>submit</button>
    </form>
</body>
</html>