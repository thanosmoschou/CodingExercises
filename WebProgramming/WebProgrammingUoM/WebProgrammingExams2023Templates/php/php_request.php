<!DOCTYPE html>
<html>
    <head>
        <title>$_REQUEST with PHP</title>
    </head>

    <body>
        <h1>Fill this form</h1>

        <form method="post" action="<?php echo $_SERVER["PHP_SELF"];?>">
            Enter your name: <input type="text" name="fname">
            <br>
            Submit your form <input type="submit">
        </form>

        <?php 

            if($_SERVER["REQUEST_METHOD"] == "POST")
            {
                $name = $_REQUEST['fname']; //$_REQUEST always creates keys and values. If the method is post I could also take the value from $_POST['fname']. If it was get from the $_GET[]
                if(empty($name))
                {
                    echo "Name is empty";
                }
                else
                {
                    echo "Hello $name";
                }

                echo "<br>";
            }
            

        ?>
    </body>


</html>