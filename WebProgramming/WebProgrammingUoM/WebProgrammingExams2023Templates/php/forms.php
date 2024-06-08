<!doctype html>
<html>
    <head>
        <title>Form</title>
        <style>
            .asterisk{
                color: red;
            }
        </style>

    </head>
    <body>

        <?php  

            function prepareData($someData)
            {
                $someData = trim($someData);
                $someData = stripslashes($someData);
                $someData = htmlspecialchars($someData);

                return $someData;
            }

            $name=$email=$comments=$gender="";
            $errName=$errEmail=$errGend="";

            if($_SERVER["REQUEST_METHOD"] == "POST")
            {
                if(empty($_POST["fname"]))
                {
                    $errName = "Name is required";
                }
                else
                {
                    $name = prepareData($_POST["fname"]);

                    if (!preg_match("/^[a-zA-Z ]*$/",$name))
                    {
                        $errName = "Only letters and white space allowed";
                    }
                }

                if(empty($_POST["email"]))
                {
                    $errEmail = "Email is required";
                }
                else
                {
                    $email = prepareData($_POST["email"]);

                    if (!filter_var($email, FILTER_VALIDATE_EMAIL)) 
                    {
                        $errEmail = "Invalid email format";
                    }
                }

                $comments = prepareData($_POST["comments"]);

                if(empty($_POST["gender"]))
                {
                    $errGend = "Gender is required";
                }
                else
                {
                    $gender = prepareData($_POST["gender"]);
                }
            }

        
        ?>

        <h1>Please fill the form</h1>
        <span class="asterisk"><p>* required</p></span>

        <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
            Name: <input type="text" name="fname"><span class="asterisk">* <?php echo $errName;?></span><br>
            Email: <input type="text" name="email"><span class="asterisk">* <?php echo $errEmail;?></span><br>
            Comments: <textarea rows="5" cols="10" name = "comments"></textarea><br>
            Gender: 
            Male<input type="radio" name="gender" value="male">
            Female<input type="radio" name="gender" value="female"><span class="asterisk">* <?php echo $errGend;?></span>
            <br>
            <input type="submit">

        </form>

        <?php  
            echo "<br>Your input<br>";
            echo $name . "<br>";
            echo $email . "<br>";
            echo $comments . "<br>";
            echo $gender . "<br>";
        
        ?>

    </body>
</html>