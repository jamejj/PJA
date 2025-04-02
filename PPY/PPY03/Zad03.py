import random as rnd

listaDuzychLiter = [chr(i) for i in list(range(65,91))]
print(listaDuzychLiter)
listaMalychLiter = [chr(i) for i in list(range(97,123))]
print(listaMalychLiter)
listaCyfr = list(range(0,10))
print(listaCyfr)
listaZnakowSpecjalnych = [chr(i) for i in list(range(33,65)) if i not in (range(48,58))]
print(listaZnakowSpecjalnych)


maleLiteryMod = [listaMalychLiter[i] for i in range(len(listaMalychLiter)) if i%2 == 0 or i%5 == 0]
duzeLiteryMod = [listaDuzychLiter[i] for i in range(len(listaDuzychLiter) - 1) if i%3 == 0 or i%2 == 0]
cyfryModParzyste = [listaCyfr[i] for i in range(len(listaCyfr)) if i%2 == 0]
cyfryModNieParzyste = [listaCyfr[i] for i in range(len(listaCyfr) -1) if i%2 != 0]
cyfryMod = cyfryModParzyste + cyfryModNieParzyste


dlugoscHasla = 5
trudnosc = input("Podaj poziom trudnosci hasła\n")



def met1Latwe(lista,dlugoscHasla):
    print("Twoje hasła to: ")
    for i in range(10):
        haslo = [rnd.choice(lista) for i in range(dlugoscHasla)]
        for i in haslo:
            print(i, end="")
        print()

def met2Srednie(lista1,lista2,dlugoscHasla):
    print("Twoje hasła to: ")
    for i in range(10):
        haslo = [rnd.choice(lista1 + lista2) for i in range(dlugoscHasla)]
        rnd.shuffle(haslo)
        for i in haslo:
            print(i, end="")
        print()

def met3Trudne(lista1,lista2,lista3,dlugoscHasla):
    print("Twoje hasła to: ")
    for i in range(10):
        haslo = [rnd.choice(lista1 + lista2 + lista3) for i in range(dlugoscHasla)]
        rnd.shuffle(haslo)
        for i in haslo:
            print(i, end="")
        print()


while trudnosc.lower() not in ("latwe", "srednie", "trudne"):
    print("Czy poprawnie wpisałes poZiom?")
    trudnosc = input("Podaj poziom trudnosci hasła\n")

if trudnosc.lower() == "latwe":
    sklad = input("Czy hasło ma składać się tylko z dużych liter? --> 1\n"
                  "Czy hasło ma składać się tylko z małych liter? --> 2\n"
                  "Czy hasło ma składać się tylko z cyfr? --> 3\n")
    if sklad == "1":
        met1Latwe(duzeLiteryMod, dlugoscHasla)

    elif sklad == "2":
        met1Latwe(maleLiteryMod, dlugoscHasla)

    elif sklad == "3":
        met1Latwe(cyfryMod, dlugoscHasla)


elif trudnosc.lower() == "srednie":
    sklad = input("Czy hasło ma składać się liter małych i dużych? --> 1\n"
                  "Czy hasło ma składać się liter małych i cyfry? --> 2\n"
                  "Czy hasło ma składać się liter dużych i cyfr? --> 3\n")
    if sklad == "1":
        met2Srednie(duzeLiteryMod,maleLiteryMod,dlugoscHasla)

    elif sklad == "2":
        met2Srednie(maleLiteryMod,cyfryMod,dlugoscHasla)

    elif sklad == "3":
        met2Srednie(duzeLiteryMod,cyfryMod,dlugoscHasla)


elif trudnosc.lower() == "trudne":
    met3Trudne(duzeLiteryMod,maleLiteryMod,cyfryMod,dlugoscHasla)