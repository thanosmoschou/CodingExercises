<!doctype html>
<html>
    <head>
        <title>Νέα Δεδομένα</title>
    </head>

    <body>
        <h1>Συμπληρώστε το παρακάτω πεδίο</h1>
        
        <?php 
            $outputWebsiteMessage = $website = "";
            $counter = 0;

            if($_SERVER['REQUEST_METHOD'] == 'POST')
            {
                $valid = true;

                //collect the data
                $website = $_POST['web'];

                if(empty($website))
                {
                    $outputWebsiteMessage = "Το πεδίο δεν μπορεί να είναι κενό";
                    $valid = false;
                }
                else
                {
                    if (!preg_match("/\b(?:(?:https?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%=~_|]/i",$website)) 
                    {
                        $outputWebsiteMessage = "Μη έγκυρο URL";
                        $valid = false;
                    }
                    else
                    {
                        $counter++;
                    }
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
                        $sql = "INSERT INTO ics22020 (website) VALUES ('$_POST[web]')";
                        if($conn -> query($sql) === TRUE)
                        {
                            echo "Πλήθος καταχωρήσεων: $counter <br>";
                        }
                        else
                        {
                            echo "ΔΕΝ ΕΓΙΝΕ η εισαγωγή δεδομένων. <br>";
                        }

                        $conn -> close();
                    }
                }

            }
        ?>


        <form method = "post" action = "<?php echo htmlspecialchars($_SERVER['PHP_SELF']);?>">
            Website: <input type="text" name="web" style="margin-top:10px;"><?php echo $outputWebsiteMessage ?><br>

            <input type="submit" value="Submit" style="margin-top:10px;">
        </form>
    </body>

</html>