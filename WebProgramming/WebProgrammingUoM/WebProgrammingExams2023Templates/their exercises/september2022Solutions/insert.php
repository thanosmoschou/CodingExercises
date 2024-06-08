<!doctype html>
<html>
    <head>
        <title>Insert</title>
    </head>
    <body>
        <h1>Fill this form</h1>
               
        <?php 
            $outputEmailMessage = $email = "";

            if($_SERVER['REQUEST_METHOD'] == 'POST')
            {
                //collect the data
                $email = $_POST['email'];


                if(empty($email))
                    $outputEmailMessage = "Email field cannot be empty";
                else
                {
                    if (!filter_var($email, FILTER_VALIDATE_EMAIL)) 
                    {
                        $email = "";
                        $outputEmailMessage = "Invalid email format";
                    }
                    else
                    {
                        $servername = "localhost";
                        $username = "root";
                        $password = "";
                        $db = "test"; //I put that after I created the db
                        
            
                        //connect to db
                        $conn = new mysqli($servername, $username, $password, $db); //I put $db after I created the db. Now I must connect to a db in order to create table, enter values to it etc...
            
                        if($conn -> connect_error)
                        {
                            die("Error connecting" . $conn -> connect_error);
                        }
                        else
                        {
                            //enter values from a form to table
                            $sql = "INSERT INTO ics22020 (email) VALUES ('$_POST[email]')";
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

            }
        ?>

        <form method = "post" action = "<?php echo htmlspecialchars($_SERVER['PHP_SELF']);?>">
            Email: <input type="text" name="email" style="margin-top:10px;"><?php echo $outputEmailMessage ?><br>
            <input type="submit" value="Submit" style="margin-top:10px;">
        </form>
    </body>
</html>

