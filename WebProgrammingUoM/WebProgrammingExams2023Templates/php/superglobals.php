<!DOCTYPE html>
<html>
    <head>
        <title>Superglobals with PHP</title>
    </head>

    <body>

        <?php 
            $x = 1;
            $y = 2;

            function myFunc()
            {
                $GLOBALS["z"] = $GLOBALS["x"] + $GLOBALS["y"];

                /*
                alternative

                global $x, $y, $z;

                $z = $x + $y;
                */

            }

            myFunc();

            echo "z = $z";

            echo $_SERVER["PHP_SELF"];
            echo "<br>";
            echo $_SERVER["SERVER_NAME"];
            echo "<br>";
            echo $_SERVER["REMOTE_HOST"]; //for some reason this does not work
            echo "<br>";

        ?>
    </body>


</html>