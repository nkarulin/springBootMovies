<html>
    <head>
        <title>Log In</title>
    </head>
    <body>
        <form action="/movies/management/" method="post" enctype="multipart/form-data">
            <h2>New movie details:</h2>
            <input type="text" name="title" value="Title" />
            <input type="number" name="year" value="1972"/>
            <input type="file" name="imageFile" />
            <input type="submit" id="say-hello-button" value="Add Movie" />
        </form>
    </body>
</html>