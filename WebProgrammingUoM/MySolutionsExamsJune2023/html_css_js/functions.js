'use strict';


function calculatePoints(points)
{
    var oldPoints = Number(document.getElementById("scre").innerHTML);

    document.getElementById("scre").innerHTML = (oldPoints + points);
    
}