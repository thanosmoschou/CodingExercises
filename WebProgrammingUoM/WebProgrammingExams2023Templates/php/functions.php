<!DOCTYPE html>
<html>
    <head>
        <title>Functions with PHP</title>
    </head>

    <body>
        <?php 
            function myFunction($aValue)
            {
                echo "The input value will be shown 3 times <br>";
                for($x = 0; $x < 3; $x++)
                {
                    echo "$aValue <br>";
                }
            }

            function returnValueIncreasedByOne($aValue)
            {
                return $aValue + 1;
            }

            $val = 3;
            $val2 = "thanos";
            myFunction(4);
            myFunction($val);
            myFunction($val2);

            $number = 3;
            echo "The number $number increased by one is: " . returnValueIncreasedByOne($number) . "<br>";

        ?>
    </body>


</html>