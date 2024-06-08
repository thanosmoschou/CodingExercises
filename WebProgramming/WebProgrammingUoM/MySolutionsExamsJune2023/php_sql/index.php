<!doctype html>
<html>
    <head>
        <title>Index</title>
    </head>

    <body>
        <h1 style="text-align: center;">Αθανάσιος Μόσχου ics22020</h1>
        <?php 
            $servername = "localhost";
            $username = "root";
            $password = "";
            $db = "test"; 
            

            //connect to db
            $conn = new mysqli($servername, $username, $password, $db); 

            if($conn -> connect_error)
            {
                die("Αποτυχία Σύνδεσης" . $conn -> connect_error);
            }
            else
            {
                
                //Let's create a table if not exists
                $sql = "CREATE TABLE IF NOT EXISTS ics22020(
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    website VARCHAR(25)
                )";

                if($conn -> query($sql) === TRUE)
                {
                    echo "Επιτυχής δημιουργία πίνακα <br>";
                }
                else
                {
                    echo "ΟΧΙ δημιουργία πίνακα <br>";
                }

                
                $conn -> close();
            }

        ?>

        <a href="vazo.php">Νέα Δεδομένα</a>
        <a href="diagrafo.php">Διαγραφή Δεδομένων</a>
    </body>

</html>