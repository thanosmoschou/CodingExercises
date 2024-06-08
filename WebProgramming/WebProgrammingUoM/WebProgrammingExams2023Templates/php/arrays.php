<!DOCTYPE html>
<html>
    <head>
        <title>Arrays with PHP</title>
    </head>

    <body>
        <?php 
            $myArray = array(1, 4, 2);

            echo "The size of the array is " . count($myArray) . "<br>";

            for($i = 0; $i < count($myArray); $i++)
            {
                echo "$myArray[$i] <br>";
            }


            $b = array("thanos"=>"1", "elena"=>"2", "fourkan"=>3, "marios"=>"4");
            echo "Value of thanos: " . $b["thanos"] . "<br>";

            foreach($b as $key=>$value)
            {
                echo "Key: $key Value: $value <br>";
            }

            //multidimensional array
            $multi = array(array(1, 2, 3), array(4, 5, 6), array(7, 8, 9));
            for($i = 0; $i < 3; $i++)
            {
                for($j = 0; $j < 3; $j++)
                {
                    echo $multi[$i][$j] . " "; //you must not put the array value $multi[][] to quotes because it is multidimensional. Also the associative array has the same problem
                }
            }

            echo "<br>";

            sort($myArray);
            $limit = count($myArray);
            for($i = 0; $i < $limit; $i++)
            {
                echo "$myArray[$i] ";
            }

            echo "<br>";

            rsort($myArray);
            for($i = 0; $i < $limit; $i++)
            {
                echo "$myArray[$i] ";
            }

            echo "<br>";

            asort($b);
            foreach($b as $key=>$value)
            {
                echo $key . " " . $value . "<br>";
            }

            echo "<br>";

            ksort($b);
            foreach($b as $key=>$value)
            {
                echo $key . " " . $value . "<br>";
            }

            echo "<br>";

            arsort($b);
            foreach($b as $key=>$value)
            {
                echo $key . " " . $value . "<br>";
            }

            echo "<br>";

            krsort($b);
            foreach($b as $key=>$value)
            {
                echo $key . " " . $value . "<br>";
            }

            echo "<br>";



        ?>
    </body>


</html>