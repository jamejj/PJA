import random as rnd

listaDuzychLiter = [chr(i) for i in list(range(65,91))]
listaMalychLiter = [chr(i) for i in list(range(97,123))]
listaCyfr = list(range(0,10))
listaZnakowSpecjalnych = [chr(i) for i in list(range(33,65)) if i not in (range(48,58))]

iloscLiter = int(input("Ile liter?\n"))
iloscCyfr = int(input("Ile cyfr?\n"))
iloscZnakowSpecjalnych = int(input("Ile znaków specjalnych?\n"))

dlugosc = int(input("Jaka ma być długość hasła?\n"))
sumaZnakow = iloscLiter + iloscCyfr + iloscZnakowSpecjalnych

if sumaZnakow > dlugosc:
    print("Ilosc znakow przekracza długosc\n")
elif sumaZnakow < dlugosc:
    print("Dlogosc jest wieksza od sumy znakow\n")
else:
    print("Twoje hasła to:")
    for i in range(5):
        haslo = []

        for i in range(iloscLiter):
            haslo.append(rnd.choice(listaDuzychLiter + listaMalychLiter))

        for i in range(iloscCyfr):
            haslo.append(rnd.choice(listaCyfr))

        for i in range(iloscZnakowSpecjalnych):
            haslo.append(rnd.choice(listaZnakowSpecjalnych))

        for i in range(dlugosc - sumaZnakow):
            haslo.append(rnd.choice(listaDuzychLiter + listaMalychLiter + listaCyfr + listaZnakowSpecjalnych))

        rnd.shuffle(haslo)
        print(*haslo)