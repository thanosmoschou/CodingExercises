<!doctype html>
<html>
    <head>
        <title>A random title</title>
    </head>

    <body>
        <?php 
            $servername = "localhost";
            $username = "root";
            $password = "";
            $db = "test"; 
            

            //connect to db
            $conn = new mysqli($servername, $username, $password, $db); 

            if($conn -> connect_error)
            {
                die("Error connecting" . $conn -> connect_error);
            }
            else
            {
                
                //Let's create a table if not exists
                $sql = "CREATE TABLE IF NOT EXISTS ics22020(
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    email VARCHAR(25)
                )";

                if($conn -> query($sql) === TRUE)
                {
                    echo "Table created successfully/or already existed <br>";
                }

                
                $conn -> close();
            }

        ?>

        <a href="insert.php">Insert</a>
        <a href="view.php">View</a>
    </body>

</html>