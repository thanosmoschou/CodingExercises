"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

initial_seconds = int(input("Insert the total value of seconds: "))
temp_sec = initial_seconds

hours = temp_sec // 3600 #Thelo div gia akraio arithmo oron oste na dothei timi kai sta upoloipa
temp_sec -= (hours * 3600) #Tosa prepei na afairethoun giati antoistoixoun stis ores pou tis metrisa

minutes = temp_sec // 60
temp_sec -= ( minutes * 60)

print("Seconds you entered:", initial_seconds)
print("Hours: ", hours)
print("Minutes: ", minutes)
print("Seconds: ", temp_sec)
