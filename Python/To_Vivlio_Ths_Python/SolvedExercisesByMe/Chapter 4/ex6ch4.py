"""
Author: Thanos Moschou
Date: 09/2022
Description: Python scripts for exercises from book 'To vivlio ths Python' by Samaras
"""

employees = int(input("Dwse synoliko arithmo ergazomenwn: "))
sumMisthodosia = 0
sumKrathseis = 0

for i in range(1, employees + 1):
    morfosi = input('Dwse morfosi(YE(Ypoxrewtikh), ME(Mesh), AE(Anwtath)): ')
    proypiresia = int(input("Dwse xrono proyphresias: "))

    if morfosi == 'YE':
        if proypiresia <= 10:
            misthos = 570
        else:
            misthos = 690
    elif morfosi == 'ME':
        if proypiresia <= 10:
            misthos = 680
        else:
            misthos = 990
    else:
        if proypiresia <= 10:
            misthos = 790
        else:
            misthos = 1300

    xronoepidoma = (proypiresia // 3) * (misthos * 0.08) #to proypiresia // 3 gia kathe sumpliromenh 3 etia proyphresias
    krathseis = (xronoepidoma + misthos) * 0.2
    vasikosMisthos = misthos + xronoepidoma - krathseis

    print("Vasikos Misthos: ", vasikosMisthos, "Xronoepidoma: ", xronoepidoma, "Krathseis: ", krathseis, "Katharos Misthos: ", misthos)
    sumKrathseis += krathseis
    sumMisthodosia += (misthos + xronoepidoma)

print("Synoliko poso misthodosias: ", sumMisthodosia, "Synoliko poso krathsewn: ", sumKrathseis)
