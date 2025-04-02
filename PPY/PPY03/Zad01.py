haslo = input("Podaj haslo")

alfabet = [chr(x) for x in range(65,91)]

oile = int(input("O ile przesuniec?"))

operacja = input("Zaszyfrować(1)\nZdeszyfrowac(2)")

if operacja == "1":
    alfabet2 = alfabet[oile:] + alfabet[:oile]
    szyfr = dict(zip(alfabet, alfabet2))
    print(szyfr)
    for litera in haslo.upper():
            if litera in szyfr:
                    print(szyfr[litera], end="")

elif operacja == "2":
    alfabet2 = alfabet[oile:] + alfabet[:oile]

    szyfr = dict(zip(alfabet2, alfabet))
    print(szyfr)
    for litera in haslo.upper():
            if litera in szyfr:
                    print(szyfr[litera], end="")

