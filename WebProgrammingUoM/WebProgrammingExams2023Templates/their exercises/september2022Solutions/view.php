<!doctype html>
<html>
    <head>
        <title>View</title>
    </head>
    <body>
        <h1>Results</h1>
                
        <?php
            $servername = "localhost";
            $username = "root";
            $password = "";
            $db = "test"; //I put that after I created the db


            //connect to db
            $conn = new mysqli($servername, $username, $password, $db);
            if($conn -> connect_error)
            {
                die("abort" . $conn -> connect_error);
            }
            else
            {
                $sql = "SELECT id, email FROM ics22020";
                $result = $conn -> query($sql);

                if($result -> num_rows > 0)
                {
                    echo "<table><tr><th>ID</th><th>Email</th></tr>";
                    while($row = $result -> fetch_assoc())
                    {
                        echo "<tr><td>".$row["id"]."</td><td>".$row["email"]."</td></tr>";
                    }
                    echo "</table>";
                }
                else
                {
                    echo "0 results";
                }

                $conn -> close(); //remember to close the connection
            }
        ?>

    </body>
</html>

