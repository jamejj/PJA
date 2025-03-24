import random as rnd

listaDuzychLiter = [chr(i) for i in list(range(65,91))]
print(listaDuzychLiter)
listaMalychLiter = [chr(i) for i in list(range(97,123))]
print(listaMalychLiter)
listaCyfr = list(range(0,10))
print(listaCyfr)


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

def met3Trudne(lista1,lista2,dlugoscHasla):
    print("Twoje hasła to: ")
    for i in range(10):
        haslo = [rnd.choice(lista1 + lista2) for i in range(dlugoscHasla)]
        rnd.shuffle(haslo)
        for i in haslo:
            print(i, end="")
        print()


dlugoscHasla = 5
trudnosc = input("Podaj poziom trudnosci hasła\n")



while trudnosc.lower() not in ("latwe","srednie","trudne"):
    print("Czy poprawnie wpisałes poziom?")
    trudnosc= input("Podaj poziom trudnosci hasła\n")

if trudnosc.lower() == "latwe":
    sklad = input("Czy hasło ma składać się tylko z dużych liter? --> 1\n"
                      "Czy hasło ma składać się tylko z małych liter? --> 2\n"
                      "Czy hasło ma składać się tylko z cyfr? --> 3\n")
    if sklad == "1":
        met1Latwe(listaDuzychLiter,dlugoscHasla)


    elif sklad == "2":
        met1Latwe(listaMalychLiter,dlugoscHasla)


    elif sklad == "3":
        met1Latwe(listaCyfr,dlugoscHasla)


elif trudnosc.lower() == "srednie":
    sklad = input("Czy hasło ma składać się liter małych i dużych? --> 1\n"
                  "Czy hasło ma składać się liter małych i cyfry? --> 2\n"
                  "Czy hasło ma składać się liter dużych i cyfr? --> 3\n")
    if sklad == "1":
        met2Srednie(listaDuzychLiter,listaMalychLiter,dlugoscHasla)


    elif sklad == "2":
        met2Srednie(listaMalychLiter,listaCyfr,dlugoscHasla)


    elif sklad == "3":
        met2Srednie(listaDuzychLiter,listaCyfr,listaMalychLiter)


elif trudnosc.lower() == "trudne":
       met3Trudne(listaMalychLiter,listaDuzychLiter,dlugoscHasla)