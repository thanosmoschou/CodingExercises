<!doctype html>
<html>
    <head>
        <title>Kataxorisi</title>
    </head>

    <body>
        <h1>Fill this form</h1>
        
        <?php 
            $outputIdMessage = $outputNameMessage = $outputWebsiteMessage = $id = $name = $website = "";

            if($_SERVER['REQUEST_METHOD'] == 'POST')
            {
                $valid = true;

                //collect the data
                $id = $_POST['id'];
                $name = $_POST['fname'];
                $website = $_POST['web'];

                if(empty($id))
                {
                    $outputIdMessage = "Id field cannot be empty";
                    $valid = false;
                }
                
                if(empty($name))
                {
                    $outputNameMessage = "Name field cannot be empty";
                    $valid = false;
                }

                if(empty($website))
                {
                    $outputWebsiteMessage = "Website field cannot be empty";
                    $valid = false;
                }
                else
                {
                    if (!preg_match("/\b(?:(?:https?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%=~_|]/i",$website)) 
                    {
                        $outputWebsiteMessage = "Invalid URL";
                        $valid = false;
                    }
                }

                if($valid)
                {
                    $servername = "localhost";
                    $username = "root";
                    $password = "";
                    $db = "ics22020"; //I put that after I created the db
                    
                    //connect to db
                    $conn = new mysqli($servername, $username, $password, $db); //I put $db after I created the db. Now I must connect to a db in order to create table, enter values to it etc...

                    if($conn -> connect_error)
                    {
                        die("Error connecting" . $conn -> connect_error);
                    }
                    else
                    {
                        //enter values from a form to table
                        $sql = "INSERT INTO ics22020 (id, name, website) VALUES ('$_POST[id]', '$_POST[fname]', '$_POST[web]')";
                        if($conn -> query($sql) === TRUE)
                        {
                            echo "Values entered to the table successfully <br>";
                        }
                        else
                        {
                            echo "Error entering values to the table";
                        }

                        $conn -> close();
                    }
                }

            }
        ?>


        <form method = "post" action = "<?php echo htmlspecialchars($_SERVER['PHP_SELF']);?>">
            Id: <input type="text" name="id" style="margin-top:10px;"><?php echo $outputIdMessage ?><br>
            Name: <input type="text" name="fname" style="margin-top:10px;"><?php echo $outputNameMessage ?><br>
            Website: <input type="text" name="web" style="margin-top:10px;"><?php echo $outputWebsiteMessage ?><br>

            <input type="submit" value="Submit" style="margin-top:10px;">
        </form>
    </body>

</html>