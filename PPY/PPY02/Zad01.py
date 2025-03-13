imie = input("Podaj imie")
data = input("Podaj Date urodzenia")
email = input("Podaj adres email")
nrTelefonu = input("Podaj numer  telefonu")

print("Lista")
list = [imie,data,email,nrTelefonu]
print(list)

print("Krotka")
krotka = (imie,data,email,nrTelefonu)
print(krotka)

print("Slownik")
slownik = {"Imie":imie,"Data urodzenia":data,"Email":email,"Numer telefonu":nrTelefonu}
print(slownik)
