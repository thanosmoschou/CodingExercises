<!doctype html>
<html>
    <head>
        <title>Dialogi</title>
    </head>

    <body>
        <?php 
            $servername = "localhost";
            $username = "root";
            $password = "";
            $db = "ics22020";

            $conn = new mysqli($servername, $username, $password, $db);
            if($conn -> connect_error)
            {
                die("abort" . $conn -> connect_error);
            }
            else
            {
                $sql = "SELECT id, name, website FROM ics22020 WHERE id = 22020";
                $result = $conn -> query($sql);

                if($result -> num_rows > 0)
                {
                    echo "<table><tr><th>ID</th><th>Name</th><th>Website</th></tr>";
                    while($row = $result -> fetch_assoc())
                    {
                        echo "<tr><td>".$row["id"]."</td><td>".$row["name"]."</td><td>".$row["website"]."</td></tr>";
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