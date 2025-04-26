from datetime import datetime
import random

print(datetime.now())

class Person:
    def __init__(self, imie, nazwisko, email, data_waznosci):
        self.imie = imie
        self.nazwisko = nazwisko
        self.email = email
        self.data_waznosci = data_waznosci

    def __str__(self):
        return self.imie + " " + self.nazwisko + " " + self.email + " " + self.data_waznosci


token_list = []
person_list = []

while True:
    komenda = input("Podaj komende:\n"
                    "q -> wyjscie\n"
                    "w -> generacja tokena\n"
                    "e -> znalezienie danych własciciela tokena\n"
                    "r -> sprawdz date waznosci tokena")

    if komenda == "q":
        break
    elif komenda == "w":

        imie = input("Podaj imie: ")
        nazwisko = input("Podaj nazwisko: ")
        email = input("Podaj email: ")
        data_waznosci = input("Podaj data_waznosci: ")

        person = Person(imie, nazwisko, email, data_waznosci)

        token = random.choice(imie).upper() + random.choice(nazwisko).upper() + (random.choice(email).upper()+"@") + random.choice(data_waznosci).upper()

        person_list.append(person)
        token_list.append(token)
        print("Lista tokenów")
        for i in token_list:
            print(i)
        print(f"{person} ----> {token}")

    elif komenda == "e":
        person_token_dict = dict(zip(token_list, person_list))
        token_do_wyszukania_osoby = input("Podaj token do wyszukania osoby: ")
        if token_do_wyszukania_osoby in person_token_dict:
            print(person_token_dict[token_do_wyszukania_osoby])
        else:
            print("Nie znaleziono osoby")

    elif komenda == "r":
        token_data = input("Podaj token do sprawdzenia daty: ")
        if token_data in person_token_dict:
            osoba = person_token_dict[token_data]
            print(osoba)

            try:
                data_waznosci = datetime.strptime(osoba.data_waznosci, "%d-%m-%Y")
            except ValueError:
                print("Niepoprawny format daty w danych!")
                continue

            akutualny_dzien = datetime.today()

            if data_waznosci >= akutualny_dzien:
                print("Token aktualny")
            else:
                print("Token nie aktualny")