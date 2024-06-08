<!doctype html>
<html>
    <head>
        <title>Initial Page</title>
    </head>

    <body>
        <?php 
            $servername = "localhost";
            $username = "root";
            $password = "";                

            //connect to db
            $conn = new mysqli($servername, $username, $password); 

            if($conn -> connect_error)
            {
                die("Error connecting" . $conn -> connect_error);
            }
            else
            {
                //Let's create a db if not exists
                
                $sql = "CREATE DATABASE IF NOT EXISTS ics22020";
                if($conn -> query($sql) === TRUE)
                {
                    echo "Successful creation of db <br>";
                }
                else
                {
                    echo "Error creating db";
                }

                $conn -> close();
            }
                
            $db = "ics22020";

            $conn = new mysqli($servername, $username, $password, $db); 

            if($conn -> connect_error)
            {
                die("Error connecting" . $conn -> connect_error);
            }
            else
            {
                //Let's create a table if not exists
                $sql = "CREATE TABLE IF NOT EXISTS ics22020(
                    id INT,
                    name VARCHAR(30),
                    website VARCHAR(30)
                )";

                if($conn -> query($sql) === TRUE)
                {
                    echo "Table created successfully/or already existed <br>";
                }
                else
                {
                    echo "Wrong while creating table";
                }

                $conn -> close();
            }  
            ?>

            <a href="show.php">Emfanisi</a>
            <a href="set.php">Kataxorisi</a>
            <a href="pick.php">Dialogi</a>

        
    </body>

</html>