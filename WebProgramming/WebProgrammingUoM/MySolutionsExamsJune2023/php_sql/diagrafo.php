<!doctype html>
<html>
    <head>
        <title>Διαγραφή Δεδομένων</title>
    </head>

    <body>
        <h1>Συμπληρώστε το παρακάτω πεδίο</h1>
        
        <?php 
            $outputIdMessage = $id = "";
            $counter = 0;

            if($_SERVER['REQUEST_METHOD'] == 'POST')
            {
                $valid = true;
                $counter = 0;

                //collect the data
                $id = $_POST['id'];

                if(empty($id))
                {
                    $outputIdMessage = "Το πεδίο δεν μπορεί να είναι κενό";
                    $valid = false;
                }
                
               
                if($valid)
                {
                    $servername = "localhost";
                    $username = "root";
                    $password = "";
                    $db = "test";
                    
                    //connect to db
                    $conn = new mysqli($servername, $username, $password, $db); 

                    if($conn -> connect_error)
                    {
                        die("Αποτυχία σύνδεσης" . $conn -> connect_error);
                    }
                    else
                    {
                        //enter values from a form to table
                        $sql = "DELETE FROM ics22020 WHERE id = $_POST[id]";
                        $counter++;

                        if($conn -> query($sql) === TRUE)
                        {
                            echo "Πλήθος στοιχείων που διαγράφηκαν $counter <br>";
                        }
                        else
                        {
                            echo "Απέτυχε η διαγραφή δεδομένων <br>";
                        }

                        $conn -> close();
                    }
                }

            }
        ?>


        <form method = "post" action = "<?php echo htmlspecialchars($_SERVER['PHP_SELF']);?>">
            Id: <input type="text" name="id" style="margin-top:10px;"><?php echo $outputIdMessage ?><br>
           
            <input type="submit" value="Submit" style="margin-top:10px;">
        </form>
    </body>

</html>