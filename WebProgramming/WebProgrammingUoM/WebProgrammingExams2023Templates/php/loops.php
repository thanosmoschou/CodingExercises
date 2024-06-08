<!DOCTYPE html>
<html>
    <head>
        <title>Loops with PHP</title>
    </head>

    <body>
        <?php 
            echo "Loops <br>";

            $x = 0;
            while($x < 10)
            {
                echo "$x <br>";
                $x++;
            }

           echo "<br>";
            for($x = 1; $x < 11; $x++)
            {
                echo "$x <br>";
            }

            echo "<br>";
            $x = 10;
            do
            {
                echo "Yo <br>";
                $x--;
            }while($x > 0);

            $b = array("thanos"=>"1", "elena"=>"2", "fourkan"=>3, "marios"=>"4");
            foreach($b as $key => $value)
            {
                echo "Key is $key and value is $value <br>";
            }

        ?>
    </body>


</html>