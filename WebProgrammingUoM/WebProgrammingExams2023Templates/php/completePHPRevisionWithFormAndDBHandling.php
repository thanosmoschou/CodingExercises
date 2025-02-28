<!doctype html>
<html>
    <head>
        <title>A random title</title>
    </head>

    <body>
        <!--
            PHP Showcase ----- Only take some code from here do not copy the whole file

            Open xampp and pass to htdocs your php files in order to be executed by the server

            How to write php

            <?php 
                //Your php code goes here
            ?>

            Comments
            // -> single line comment
            /* */ -> multiline comment

            PHP is case insensitive except variable names
            $color is different than $Color

            Assign a value to a variable
            $x = 10;

            DATA TYPES

            String, Integer, Float, Boolean, Array, Object, NULL, Resource

            var_dump() returns data type and value of a variable


            Creating an array

            $x = array(1, 3, 5);

            Define constants

            define(name, value, case_insensitive) ->name of constant, value and a boolean value to tell if constant is case insensitive...the default is false

            define(HELLO, "Yoooo");
            echo HELLO;


            Variable scope 
            Same thing like other languages

            $x = 10;
            function m()
            {
                //x is not available here
            }

            a variable that is defined outside of a function has global scope and can be used only outside of the function
            a variable that is defined inside a function has local scope and can be used only inside the function


            Glocal keyword

            $x = 10;
            function m()
            {
                global $x; //now I refer to the global variable x 
                $x++;
            }


            PHP saves all the global variables to a $GLOBALS[index] array and index is the name of the variable inside ''

            echo $GLOBALS['x'];


            PHP Operators

            Arithmetic
            +, -, *, /, %, **

            Assign
            =, +=, -=, *=, /=, %=

            Comparison
            ==, === (True if $x is equal to $y, and they are of the same type), !=, <>, 
            !== (True if $x is not equal to $y or they are not of the same type), >, <, >=, <=

            Increment/Decrement
            $x++, $x--, ++$x, --$x

            Logical
            &&, ||, !

            String
            . (concatenation), .=


            If

            almost the same like C

            if, elseif, else

            if()
            {

            }

            if()
            {}
            elseif()
            {}
            else
            {}


            Switch is the same like C

            switch()
            {
                case something:
                    //code
                    break;
            }


            Loops

            for($x = 0; $x < 10; $x++)
            {

            }

            while(condition)
            {
                //code
            }

            do
            {
                //code
            }
            while()


            foreach($array as $value)
            {

            }


            Functions

            function myFunc($par1, $par2) -> function names are not case sensitive
            {
                //code
            }

            default parameter value

            function m($a=1) -> if you call m with an argument then your argument will be passed to the function. Otherwise the parameter will have the default value
            {
                //code
            }

            also you can have a return

            function m()
            {
                //code
                return $value
            }


            CREATING AN ARRAY

            array();

            $a = array(1,2,3);
            $b = array('a', 'b');

            echo $a[0];

            echo count($a); ->return the length of the array


            Associative arrays

            $a = array('a'=>1, 'b'=>2);

            echo $a['a'];

            loop an associative array

            foreach($array as $key=>$value) -> looks the same like foreach($array as $value) but now for value we have $key=>$value
            {

            }


            SUPERGLOBALS

            $GLOBALS, $_SERVER, $_REQUEST, $_GET, $_POST

            Let's create a form and make some validity checks

            <form action="add php code here in order to make this file handle the credentials" method="your method post or get">
                input goes here
            </form>

            the php code is
            <?php echo htmlspecialchars($_SERVER['PHP_SELF']);?>

            When you have to check if input is a valid email then use the ready code provided in the pdf of the course


            <?php
                // define variables and set to empty values
                /*
                $nameErr = $emailErr = $genderErr = $websiteErr = "";
                $name = $email = $gender = $comment = $website = "";
                
                if ($_SERVER["REQUEST_METHOD"] == "POST") 
                {
                    if (empty($_POST["name"])) 
                    {
                        $nameErr = "Name is required";
                    }
                    else 
                    {
                        $name = test_input($_POST["name"]);
                        // check if name only contains letters and whitespace
                        if (!preg_match("/^[a-zA-Z ]*$/",$name)) 
                        {
                            $nameErr = "Only letters and white space allowed"; 
                        }
                    }
                
                    if (empty($_POST["email"])) 
                    {
                        $emailErr = "Email is required";
                    } 
                    else 
                    {
                        $email = test_input($_POST["email"]);
                        // check if e-mail address is well-formed
                        if (!filter_var($email, FILTER_VALIDATE_EMAIL)) 
                        {
                            $emailErr = "Invalid email format"; 
                        }
                    }
                
                    if (empty($_POST["website"])) 
                    {
                        $website = "";
                    } 
                    else 
                    {
                        $website = test_input($_POST["website"]);
                        // check if URL address syntax is valid (this regular expression also allows dashes in the URL)
                        if (!preg_match("/\b(?:(?:https?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%=~_|]/i",$website)) 
                        {
                            $websiteErr = "Invalid URL"; 
                        } 
                    }
            
                    if (empty($_POST["comment"])) 
                    {
                        $comment = "";
                    } 
                    else 
                    {
                        $comment = test_input($_POST["comment"]);
                    }
                    
                    if (empty($_POST["gender"])) 
                    {
                        $genderErr = "Gender is required";
                    } 
                    else 
                    {
                        $gender = test_input($_POST["gender"]); 
                    }
                }
                
                function test_input($data) 
                {
                    $data = trim($data);
                    $data = stripslashes($data);
                    $data = htmlspecialchars($data);
                    return $data;
                }
                */
            ?>
                
            ---------------------------------------------------
            URL Validation
            
            $website = test_input($_POST["website"]); //test input prepares the string. It is user made. You can have $_POST["website"];
            if (!preg_match("/\b(?:(?:https?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%=~_|]/i",$website)) {
            $websiteErr = "Invalid URL";
            }
            
            ---------------------------------------------------
            Insert Data Into a Database Table
            The INSERT INTO statement is used to add new records to a database table.
            
            Syntax
            It is possible to write the INSERT INTO statement in two forms.
            
            The first form doesn't specify the column names where the data will be inserted, only their values:
                
            INSERT INTO table_name
            VALUES (value1, value2, value3,...)
            
            The second form specifies both the column names and the values to be inserted:

            INSERT INTO table_name (column1, column2, column3,...)
            VALUES (value1, value2, value3,...)
            
            To get PHP to execute the statements above we must use the mysql_query() function. This function is used to send a query or command to a MySQL connection.
            
            Example
            In the previous chapter we created a table named "Persons", with three columns; "Firstname", "Lastname" and "Age". We will use the same table in this example. The following example adds two new records to the "Persons" table:
            
            <?php
            /*
            $con = mysql_connect("localhost","peter","abc123");
            if (!$con)
            {
                die('Could not connect: ' . mysql_error());
            }
            mysql_select_db("my_db", $con);
            mysql_query("INSERT INTO Persons (FirstName, LastName, Age) 
            VALUES ('Peter', 'Griffin', '35')");
            mysql_query("INSERT INTO Persons (FirstName, LastName, Age) 
            VALUES ('Glenn', 'Quagmire', '33')");
            mysql_close($con);
            ?>
            
            Insert Data From a Form Into a Database
            Now we will create an HTML form that can be used to add new records to the "Persons" table.
            
            Here is the HTML form:

            <html>
            <body>
            <form action="insert.php" method="post">
            Firstname: <input type="text" name="firstname" />
            Lastname: <input type="text" name="lastname" />
            Age: <input type="text" name="age" />
            <input type="submit" />
            </form>
            </body>
            </html>
            When a user clicks the submit button in the HTML form in the example above, the form data is sent to "insert.php".
            
            The "insert.php" file connects to a database, and retrieves the values from the form with the PHP $_POST variables.
            
            Then, the mysql_query() function executes the INSERT INTO statement, and a new record will be added to the "Persons" table.
            
            Here is the "insert.php" page:
            
            <?php
            $con = mysql_connect("localhost","peter","abc123");
            if (!$con)
            {
                die('Could not connect: ' . mysql_error());
            }
            mysql_select_db("my_db", $con);
            $sql="INSERT INTO Persons (FirstName, LastName, Age)
            VALUES
            ('$_POST[firstname]','$_POST[lastname]','$_POST[age]')";
            if (!mysql_query($sql,$con))
            {
                die('Error: ' . mysql_error());
            }
            echo "1 record added";
            mysql_close($con)
            ?>
            */
            ?>
            
            -->
            
        <h1>Fill this form</h1>
        
        <?php 
            $outputNameMessage = $outputEmailMessage = $name = $email = "";

            if($_SERVER['REQUEST_METHOD'] == 'POST')
            {
                //collect the data
                $name = $_POST['fname'];
                $email = $_POST['email'];

                if(empty($name))
                    $outputNameMessage = "Name field cannot be empty";

                if(empty($email))
                    $outputEmailMessage = "Email field cannot be empty";
                else
                {
                    if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
                        $email = "";
                        $outputEmailMessage = "Invalid email format";
                    }
                }

            }
        ?>

        <form method = "post" action = "<?php echo htmlspecialchars($_SERVER['PHP_SELF']);?>">
            Name: <input type="text" name="fname" style="margin-top:10px;"><?php echo $outputNameMessage ?><br>
            Email: <input type="text" name="email" style="margin-top:10px;"><?php echo $outputEmailMessage ?><br>

            <input type="submit" value="Submit" style="margin-top:10px;">
        </form>

        <?php
            echo $name . "<br>";
            echo $email . "<br>";
        ?>

        <!--
            Let's connect to a db and pass the input data to our db
        -->

        <?php 
            $servername = "localhost";
            $username = "root";
            $password = "";
            $db = "exams"; //I put that after I created the db
            

            //connect to db
            $conn = new mysqli($servername, $username, $password, $db); //I put $db after I created the db. Now I must connect to a db in order to create table, enter values to it etc...

            if($conn -> connect_error)
            {
                die("Error connecting" . $conn -> connect_error);
            }
            else
            {
                //Let's create a db if not exists
                /*
                $sql = "CREATE DATABASE IF NOT EXISTS exams";
                if($conn -> query($sql) === TRUE)
                {
                    echo "Successful creation of db <br>";
                }
                */
                
                
                //Let's create a table if not exists
                $sql = "CREATE TABLE IF NOT EXISTS people(
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(30),
                    email VARCHAR(25)
                )";

                if($conn -> query($sql) === TRUE)
                {
                    echo "Table created successfully/or already existed <br>";
                }

                //enter values from a form to table
                $sql = "INSERT INTO people (name, email) VALUES ('$_POST[fname]', '$_POST[email]')";
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

        ?>

        <h1>Now let's show what is inside the table...This should be happening by having an a tag with a reference to another file...anyway</h1>
        <?php 
            $servername = "localhost";
            $username = "root";
            $password = "";
            $db = "exams";

            $conn = new mysqli($servername, $username, $password, $db);
            if($conn -> connect_error)
            {
                die("abort" . $conn -> connect_error);
            }
            else
            {
                $sql = "SELECT id, name, email FROM people";
                $result = $conn -> query($sql);

                if($result -> num_rows > 0)
                {
                    echo "<table><tr><th>ID</th><th>Name</th><th>Email</th></tr>";
                    while($row = $result -> fetch_assoc())
                    {
                        echo "<tr><td>".$row["id"]."</td><td>".$row["name"]."</td><td>".$row["email"]."</td></tr>";
                    }
                    echo "</table>";
                }
                else
                {
                    echo "0 results";
                }

                $conn -> close(); //remember to close the connection
            }

        ?>
    </body>

</html>