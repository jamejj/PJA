#Pobieranie slow

slowo1 = input("Podaj pierwsze słowo ")
print("Podane slowo nr 1: ", slowo1)

slowo2 = input("Podaj drugie słowo ")
print("Podane slowo nr 2: ", slowo2)

samogloski = "aAąĄeEęĘiIoOóÓuUyY"

#litera przyjmuje kolejne samogloski i gdy litera znajduje się w słowie zamienia je na 7
for litera in samogloski:
    slowo1 = slowo1.replace(litera, str(7))

print(slowo1)

spolgloski = "bBcCćĆdDfFgGhHjJkKlłŁLmMnNńŃpPrRsSśŚtTwWzZźŹżŻ"

for litera in spolgloski:
    slowo2 = slowo2.replace(litera, str(6))

print(slowo2)

#Złączenie i zamiana małych liter na duże
slowo3 = slowo1 + slowo2
print("Po zączeniu i zamianie małych liter na duże")
print(slowo3.upper())