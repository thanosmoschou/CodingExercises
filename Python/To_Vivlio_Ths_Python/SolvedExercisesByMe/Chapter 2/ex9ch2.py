"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

arx_poso = float(input("Dwse to arxiko poso tis paraggelias: "))
online_order = int(input("Egine hlektronika h paraggelia?(0-No/1-Yes): "))

if online_order:
    final_value = 0.9 * arx_poso
    print("Ekanes hlektroniki paraggelia!")
    print("Kerdises 10% ekptosi dhladi: ", 0.1*arx_poso)
    print("Teliko poso(Den tha xreotheis metaforika 5 Euro): ", final_value)
else:
    final_value = arx_poso + 5
    print("Den ekanes hlektroniki paraggelia...")
    print("Ara exeis 5 euro extra xreosi gia metaforika kai den exeis 10% ekptosi")
    print("Teliko poso: ", final_value)

    